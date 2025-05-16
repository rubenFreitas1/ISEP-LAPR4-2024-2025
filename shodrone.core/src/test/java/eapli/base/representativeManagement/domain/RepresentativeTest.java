package eapli.base.representativeManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class RepresentativeTest {

    private Calendar now;
    private SystemUser user;
    private Customer customer;

    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();

        var policy = new ExemploPasswordPolicy();
        var encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("john", "StrongPass123", "John", "Doe", "john@email.com")
                .withRoles(Roles.ADMIN).build();

        customer = new Customer("123456789", "Acme Corp", "Rua A", "acme@email.com", "911234567", "CC123456", user, Customer.CustomerStatus.CREATED, now);
    }

    @Test
    void constructor_shouldCreateRepresentative() {
        Representative rep = new Representative(
                "Alice Smith",
                "alice@email.com",
                now,
                "password123",
                "912345678",
                customer,
                "Sales Manager",
                user
        );

        assertEquals("Alice Smith", rep.representativeName());
        assertEquals("alice@email.com", rep.representativeEmail());
        assertEquals("password123", rep.representativePassword());
        assertEquals("912345678", rep.representativePhoneNumber());
        assertEquals(customer, rep.associatedCustomer());
        assertEquals("Sales Manager", rep.representativePosition());
        assertEquals(user, rep.createdBy());
        assertTrue(rep.isActive());
        assertNotNull(rep.createdOn());
        assertNull(rep.deactivatedOn());
    }

    @Test
    void deactivate_validDate_shouldDeactivateRepresentative() {
        Representative rep = new Representative(
                "Bob Jones",
                "bob@email.com",
                now,
                "pass123",
                "923456789",
                customer,
                "Support",
                user
        );

        Calendar futureDate = (Calendar) now.clone();
        futureDate.add(Calendar.DAY_OF_YEAR, 1);

        rep.deactivate(futureDate);
        assertFalse(rep.isActive());
        assertEquals(futureDate, rep.deactivatedOn());
    }

    @Test
    void deactivate_withDateBeforeCreatedOn_shouldThrowException() {
        Representative rep = new Representative(
                "Carla Lima",
                "carla@email.com",
                now,
                "pass123",
                "933456789",
                customer,
                "Marketing",
                user
        );

        Calendar pastDate = (Calendar) now.clone();
        pastDate.add(Calendar.DAY_OF_YEAR, -1);

        assertThrows(IllegalArgumentException.class, () -> rep.deactivate(pastDate));
    }

    @Test
    void deactivate_whenAlreadyInactive_shouldThrowException() {
        Representative rep = new Representative(
                "David Silva",
                "david@email.com",
                now,
                "pass123",
                "943456789",
                customer,
                "IT",
                user
        );

        Calendar futureDate = (Calendar) now.clone();
        futureDate.add(Calendar.DAY_OF_YEAR, 1);

        rep.deactivate(futureDate);
        assertThrows(IllegalStateException.class, () -> rep.deactivate(futureDate));
    }

    @Test
    void activate_shouldReactivateRepresentative() {
        Representative rep = new Representative(
                "Eva Costa",
                "eva@email.com",
                now,
                "pass123",
                "953456789",
                customer,
                "Logistics",
                user
        );

        Calendar futureDate = (Calendar) now.clone();
        futureDate.add(Calendar.DAY_OF_YEAR, 1);

        rep.deactivate(futureDate);
        rep.activate();

        assertTrue(rep.isActive());
        assertNull(rep.deactivatedOn());
    }

    @Test
    void changeMethods_shouldUpdateFieldsCorrectly() {
        Representative rep = new Representative(
                "Felipe",
                "felipe@email.com",
                now,
                "pass123",
                "963456789",
                customer,
                "Analyst",
                user
        );

        rep.changeName("Felipe Santos");
        rep.changeEmail("felipe.santos@email.com");
        rep.changePassword("newpass123");
        rep.changePhoneNumber("964444444");
        rep.changePosition("Senior Analyst");

        assertEquals("Felipe Santos", rep.representativeName());
        assertEquals("felipe.santos@email.com", rep.representativeEmail());
        assertEquals("newpass123", rep.representativePassword());
        assertEquals("964444444", rep.representativePhoneNumber());
        assertEquals("Senior Analyst", rep.representativePosition());
    }

    @Test
    void toString_shouldContainRelevantData() {
        Representative rep = new Representative(
                "Gustavo",
                "gustavo@email.com",
                now,
                "secret",
                "965555555",
                customer,
                "Engineer",
                user
        );

        String repString = rep.toString();
        assertTrue(repString.contains("Gustavo"));
        assertTrue(repString.contains("gustavo@email.com"));
        assertTrue(repString.contains("Engineer"));
    }

    @Test
    void changeChangedOn_shouldUpdateChangedOnField() throws InterruptedException {
        Representative rep = new Representative(
                "Helena",
                "helena@email.com",
                now,
                "mypassword",
                "967777777",
                customer,
                "Manager",
                user
        );

        Calendar originalChangedOn = rep.createdOn(); // No construtor, changedOn == createdOn

        Thread.sleep(10); // Garante um pequeno intervalo de tempo

        rep.changeChangedOn();

        Calendar updatedChangedOn = rep.changedOn();

        assertNotNull(updatedChangedOn);
        assertTrue(updatedChangedOn.after(originalChangedOn),
                "Expected changedOn to be after the original value");
    }

}
