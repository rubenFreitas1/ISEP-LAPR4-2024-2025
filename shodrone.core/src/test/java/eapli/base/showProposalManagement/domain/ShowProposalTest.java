package eapli.base.showProposalManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.droneModelManagement.domain.Axis;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.domain.DroneWindBehavior;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.DSL;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.domain.PluginType;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShowProposalTest {

    private ShowProposal proposal;
    private DroneModel modelA;
    private DroneModel modelB;
    private SystemUser user;
    private Calendar now;
    private GeoLocation geoLocation;
    private Template template;

    private FigureCategory category;
    private DroneWindBehavior behavior;

    private Customer customer;

    private List<Figure> figures;

    @BeforeEach
    void setUp() {

        behavior = new DroneWindBehavior();
        behavior.addTolerance(Axis.X,0,10, 0.5);
        behavior.addTolerance(Axis.X,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Y,0,10, 0.5);
        behavior.addTolerance(Axis.Y,10.0001,20, 0.8);
        behavior.addTolerance(Axis.Z,0,10, 0.5);
        behavior.addTolerance(Axis.Z,10.0001,20, 0.8);

        var encoder = new PlainTextEncoder();
        var policy = new eapli.base.usermanagement.domain.ExemploPasswordPolicy();
        user = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN)
                .build();

        now = CurrentTimeCalendars.now();
        geoLocation = new GeoLocation(38.7169, -9.1399, 100);

        Name name = Name.valueOf("Alice", "Smith");
        EmailAddress email = EmailAddress.valueOf("alice@mail.com");
        Optional<Password> password = Password.encodedAndValid("987654321", policy, encoder);
        customer = new Customer(name, "Wonderland Street", email,
                password, "123123123", "456456456", user, Customer.CustomerStatus.CREATED, Calendar.getInstance());
        category = new FigureCategory("Sci-fi", "Sci-fi figures", Calendar.getInstance());
        Set<String> keywords = new HashSet<>(Set.of("alien", "space"));
        Plugin plugin = new Plugin(new PluginName("dsl plugin"), "Plugin for dsls", PluginType.DSL);
        DSL dsl = new DSL("DSL body content", plugin, "1.2");
        String dslBody = "DSL body content";
        Figure figure = new Figure("Alien figure", keywords, category, false, null, user, dsl, dslBody);
        figures = new ArrayList<>(List.of(figure));
        GeoLocation location = new GeoLocation(40.0, -8.0, 30);
        ShowRequest request = new ShowRequest(location,Calendar.getInstance(),20,30,figures,customer, "Aniversário", user);
        template = new Template("template", "content");
        proposal = new ShowProposal(request, location, Calendar.getInstance(), LocalTime.now(),30, 5,1, user, template, 50);
        modelA = new DroneModel("DJI", "Phantom 4", Calendar.getInstance(), user,behavior);
        modelB = new DroneModel("Parrot", "Anafi",Calendar.getInstance(), user, behavior);
    }

    @Test
    void addDroneToList_Succeed() {
        boolean result1 = proposal.addDroneToList(modelA, 3);
        assertTrue(result1);
        assertEquals(3, proposal.allDroneModels_Quantity());

        boolean result2 = proposal.addDroneToList(modelB, 2);
        assertTrue(result2);
        assertEquals(5, proposal.allDroneModels_Quantity());
    }

    @Test
    void addDroneToList_Fail_DroneModelIsNull() {
        boolean result = proposal.addDroneToList(null, 2);
        assertFalse(result);
    }

    @Test
    void addDroneToList_Fail_QuantityIsNonPositive() {
        boolean resultZero = proposal.addDroneToList(modelA, 0);
        boolean resultNegative = proposal.addDroneToList(modelA, -1);

        assertFalse(resultZero);
        assertFalse(resultNegative);
    }

    @Test
    void addDroneToList_Fail_ExceedingTotalLimit() {
        assertTrue(proposal.addDroneToList(modelA, 4));
        assertFalse(proposal.addDroneToList(modelB, 2)); // Total é 5
    }

    @Test
    void addDroneToList_Fail_ModelAlreadyAdded() {
        assertTrue(proposal.addDroneToList(modelA, 3));
        assertFalse(proposal.addDroneToList(modelA, 1));
    }
    @Test
    void validateShowRequest_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateShowRequest(null);
        });
        assertEquals("ShowRequest cannot be null", ex.getMessage());
    }

    @Test
    void validateShowRequest_Valid_Returns() {
        ShowRequest validRequest = new ShowRequest(geoLocation, now, 2, 20, figures, customer, "Initial", user);
        assertEquals(validRequest, proposal.validateShowRequest(validRequest));
    }

    @Test
    void validateLocation_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateLocation(null);
        });
        assertEquals("Location cannot be null", ex.getMessage());
    }

    @Test
    void validateLocation_InvalidAltitude_Throws() {
        GeoLocation loc = new GeoLocation(0, 0, 0); // altitude <= 0
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateLocation(loc);
        });
        assertEquals("Altitude must be a positive number.", ex.getMessage());
    }

    @Test
    void validateLocation_Valid_Returns() {
        GeoLocation loc = new GeoLocation(45, 45, 10);
        assertEquals(loc, proposal.validateLocation(loc));
    }

    @Test
    void validateDate_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateDate(null);
        });
        assertEquals("Date cannot be null", ex.getMessage());
    }

    @Test
    void validateDate_Valid_Returns() {
        Calendar todayOrFuture = Calendar.getInstance();
        todayOrFuture.add(Calendar.DAY_OF_MONTH, 1);
        assertEquals(todayOrFuture, proposal.validateDate(todayOrFuture));
    }

    @Test
    void validateTime_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateTime(null);
        });
        assertEquals("Time cannot be null", ex.getMessage());
    }

    @Test
    void validateTime_Valid_Returns() {
        LocalTime time = LocalTime.now();
        assertEquals(time, proposal.validateTime(time));
    }

    @Test
    void validateDuration_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateDuration(null);
        });
        assertEquals("Duration cannot be null.", ex.getMessage());
    }

    @Test
    void validateDuration_NonPositive_Throws() {
        IllegalArgumentException ex0 = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateDuration(0);
        });
        IllegalArgumentException exNeg = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateDuration(-1);
        });
        assertEquals("Duration must be greater than 0.", ex0.getMessage());
        assertEquals("Duration must be greater than 0.", exNeg.getMessage());
    }

    @Test
    void validateDuration_Valid_Returns() {
        assertEquals(10, proposal.validateDuration(10));
    }

    @Test
    void validateTotalDroneNumber_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateTotalDroneNumber(null);
        });
        assertEquals("Total drone number cannot be null.", ex.getMessage());
    }

    @Test
    void validateTotalDroneNumber_NonPositive_Throws() {
        IllegalArgumentException ex0 = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateTotalDroneNumber(0);
        });
        IllegalArgumentException exNeg = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateTotalDroneNumber(-1);
        });
        assertEquals("Total drone number must be greater than 0.", ex0.getMessage());
        assertEquals("Total drone number must be greater than 0.", exNeg.getMessage());
    }

    @Test
    void validateTotalDroneNumber_Valid_Returns() {
        assertEquals(5, proposal.validateTotalDroneNumber(5));
    }

    @Test
    void validateProposalNumber_Negative_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateProposalNumber(-1);
        });
        assertEquals("Proposal number cannot be negative", ex.getMessage());
    }

    @Test
    void validateProposalNumber_Valid_Returns() {
        assertEquals(3, proposal.validateProposalNumber(3));
    }

    @Test
    void validateCreatedBy_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateCreatedBy(null);
        });
        assertEquals("CreatedBy (SystemUser) cannot be null", ex.getMessage());
    }

    @Test
    void validateCreatedBy_Valid_Returns() {
        assertEquals(user, proposal.validateCreatedBy(user));
    }

    @Test
    void addVideoToProposal_ValidLink_ReturnsTrue() {
        String validLink = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        boolean result = proposal.addVideoToProposal(validLink);
        assertTrue(result);
        assertEquals(validLink, proposal.videoLink());
    }

    @Test
    void addVideoToProposal_InvalidLink_ReturnsFalse() {
        String invalidLink = "htp:/invalid-url";
        boolean result = proposal.addVideoToProposal(invalidLink);
        assertFalse(result);
        assertNull(proposal.videoLink());
    }

    @Test
    void isValidVideoLink_ValidUrls_ReturnsTrue() {
        assertTrue(proposal.isValidVideoLink("https://youtube.com/video123"));
        assertTrue(proposal.isValidVideoLink("http://example.com"));
        assertTrue(proposal.isValidVideoLink("www.example.com/test"));
    }

    @Test
    void isValidVideoLink_InvalidUrls_ReturnsFalse() {
        assertFalse(proposal.isValidVideoLink("invalid-url"));
        assertFalse(proposal.isValidVideoLink("ftp://wrongprotocol.com"));
        assertFalse(proposal.isValidVideoLink("example..com"));
        assertFalse(proposal.isValidVideoLink(""));
    }

    @Test
    void isValidVideoLink_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.isValidVideoLink(null);
        });
        assertEquals("Video link cannot be null", ex.getMessage());
    }

    @Test
    void validateTemplate_Null_Throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.validateTemplate(null);
        });
        assertEquals("Template cannot be null", ex.getMessage());
    }

    @Test
    void validateTemplate_Valid_Returns() {
        assertEquals(template, proposal.validateTemplate(template));
    }

    @Test
    void testMarkShowProposalAccepted() {
        ProposalAnswerFeedback answer = new ProposalAnswerFeedback(ProposalAnswerFeedback.Answer.ACCEPTED, "Approved");
        proposal.updateProposalAnswer(answer);
        boolean result = proposal.markShowProposal();
        assertTrue(result);
        assertEquals(ShowStatus.ACCEPTED, proposal.status());
    }

    @Test
    void testMarkShowProposalFailsWhenAnswerNotAccepted() {
        ProposalAnswerFeedback answer = new ProposalAnswerFeedback(ProposalAnswerFeedback.Answer.REJECTED, "Not approved");
        proposal.updateProposalAnswer(answer);

        boolean result = proposal.markShowProposal();

        assertFalse(result);
        assertNotEquals(ShowStatus.ACCEPTED, proposal.status());
    }

    @Test
    void testAddValidDocument() {
        Document document = new Document("proposal.pdf", "PROP1");
        boolean result = proposal.addDocument(document);

        assertTrue(result);
        assertEquals(document, proposal.document());
    }

    @Test
    void testAddNullDocumentFails() {
        boolean result = proposal.addDocument(null);
        assertFalse(result);
    }

    @Test
    void addFigureWithDroneModel_Succeed() {
        Figure figure = figures.get(0);
        boolean result = proposal.addFigureWithDroneModel(figure, modelA, 1);
        assertTrue(result);
    }

    @Test
    void addFigureWithDroneModel_Fail_NullFigureOrDroneModel() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> {
            proposal.addFigureWithDroneModel(null, modelA, 1);
        });
        assertEquals("Figure or DroneModel cannot be null!", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> {
            proposal.addFigureWithDroneModel(figures.get(0), null, 1);
        });
        assertEquals("Figure or DroneModel cannot be null!", ex2.getMessage());
    }

    @Test
    void addFigureWithDroneModel_Fail_DuplicateSequenceNumber() {
        Figure figure = figures.get(0);
        assertTrue(proposal.addFigureWithDroneModel(figure, modelA, 1));
        assertFalse(proposal.addFigureWithDroneModel(figure, modelA, 1));
    }

    @Test
    void addFigureWithDroneModel_Fail_InvalidSequenceNumber() {
        Figure figure = figures.get(0);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            proposal.addFigureWithDroneModel(figure, modelA, -1);
        });
        assertEquals("Sequence number must be positive!", ex.getMessage());
    }

    @Test
    void addFigureWithDroneModel_ListContainsAddedFigures() {
        Figure figure1 = figures.get(0);
        Figure figure2 = new Figure("New Figure", Set.of("test"), category, false, null, user, null, "DSL content");

        assertTrue(proposal.addFigureWithDroneModel(figure1, modelA, 1));
        assertTrue(proposal.addFigureWithDroneModel(figure2, modelB, 2));

        List<FigureListItem> items = proposal.figureListItems();
        assertEquals(2, items.size());
        assertEquals(figure1, items.get(0).figure());
        assertEquals(figure2, items.get(1).figure());
    }
}