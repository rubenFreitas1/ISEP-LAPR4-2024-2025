package eapli.base.figureCategoryManagement.application;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FigureCategoryManagementServiceTest {

    @Mock
    private FigureCategoryRepository repo;

    @InjectMocks
    private FigureCategoryManagementService service;

    private Calendar now;

    @BeforeEach
    public void setup() {
        now = CurrentTimeCalendars.now();
    }

    @Test
    void registerNewFigureCategory_success() {
        String name = "Animals";
        String desc = "Figures of animals";

        when(repo.save(any(FigureCategory.class))).thenAnswer(i -> i.getArguments()[0]);

        FigureCategory result = service.registerNewFigureCategory(name, desc);

        assertEquals(name, result.name());
        assertTrue(result.isActive());
        verify(repo).save(any(FigureCategory.class));
    }

    @Test
    void registerNewFigureCategory_withNullName_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewFigureCategory(null, "Description")
        );
    }

    @Test
    void createFigureCategory_withNullDescription_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewFigureCategory("Name", null)
        );
    }

    @Test
    void deactivateFigureCategory_success() {
        FigureCategory cat = new FigureCategory("Sci-Fi", "Science fiction", now);
        when(repo.save(cat)).thenReturn(cat);

        FigureCategory result = service.deactivateFigureCategory(cat);

        assertFalse(result.isActive());
        assertNotNull(result.changedOn());
        verify(repo).save(cat);
    }

    @Test
    void activateFigureCategory_success() {
        FigureCategory cat = new FigureCategory("Fantasy", "Fantasy world", now);
        cat.deactivate(CurrentTimeCalendars.now());
        when(repo.save(cat)).thenReturn(cat);

        FigureCategory result = service.activateFigureCategory(cat);

        assertTrue(result.isActive());

        verify(repo).save(cat);
    }

    @Test
    void findAll_returnsList() {
        List<FigureCategory> list = List.of(
                new FigureCategory("A", "Desc A", now),
                new FigureCategory("B", "Desc B", now)
        );
        when(repo.findAll()).thenReturn(list);

        Iterable<FigureCategory> result = service.findAll();

        assertIterableEquals(list, result);
        verify(repo).findAll();
    }

    @Test
    void findById_existing_returnsCategory() {
        FigureCategory cat = new FigureCategory("Mythology", "Gods & Creatures", now);
        when(repo.findById(100L)).thenReturn(Optional.of(cat));

        Optional<FigureCategory> result = service.findFigureCategoryById(100L);

        assertTrue(result.isPresent());
        assertEquals(cat, result.get());
    }

    @Test
    void findById_notFound_returnsEmpty() {
        when(repo.findById(999L)).thenReturn(Optional.empty());

        Optional<FigureCategory> result = service.findFigureCategoryById(999L);

        assertTrue(result.isEmpty());
    }

    @Test
    void editFigureCategory_success() {
        FigureCategory cat = new FigureCategory("OldName", "Old Description", now);
        when(repo.isFigureCategoryNameUsed("NewName")).thenReturn(false);

        service.editFigureCategory(cat, "NewName", "New Description");

        assertEquals("NewName", cat.name());
        assertEquals("New Description", cat.description());
        verify(repo).save(cat);
    }

    @Test
    void editFigureCategory_nameAlreadyUsed_throwsException() {
        FigureCategory cat = new FigureCategory("OldName", "Old Description", now);
        when(repo.isFigureCategoryNameUsed("UsedName")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () ->
                service.editFigureCategory(cat, "UsedName", "Any Description")
        );

        verify(repo, never()).save(any());
    }

    @Test
    void findFigureCategoryByName_returnsResults() {
        Iterable<FigureCategory> expected = List.of(
                new FigureCategory("Animals", "Various animals", now)
        );
        when(repo.findByName("Animals")).thenReturn(expected);

        Iterable<FigureCategory> result = service.findFigureCategoryByName("Animals");

        assertIterableEquals(expected, result);
    }

    @Test
    void findFigureCategoryByDescription_returnsResults() {
        Iterable<FigureCategory> expected = List.of(
                new FigureCategory("Sci-Fi", "Spaceships and aliens", now)
        );
        when(repo.findByDescription("Spaceships")).thenReturn(expected);

        Iterable<FigureCategory> result = service.findFigureCategoryByDescription("Spaceships");

        assertIterableEquals(expected, result);
    }

    @Test
    void findByActive_returnsCorrectList() {
        Iterable<FigureCategory> expected = List.of(
                new FigureCategory("ActiveCat", "Still in use", now)
        );
        when(repo.findByActive(true)).thenReturn(expected);

        Iterable<FigureCategory> result = service.findByActive(true);

        assertIterableEquals(expected, result);
    }

    @Test
    void isFigureCategoryNameUsed_returnsTrueIfUsed() {
        when(repo.isFigureCategoryNameUsed("Duplicate")).thenReturn(true);

        boolean result = service.isFigureCategoryNameUsed(repo, "Duplicate");

        assertTrue(result);
    }

    @Test
    void changeStatus_shouldActivateFigureCategory_ifInactive() {
        FigureCategory cat = new FigureCategory("Dinosaurs", "Prehistoric figures", now);
        cat.deactivate(Calendar.getInstance()); // começa desativada

        when(repo.save(cat)).thenReturn(cat);

        service.changeStatus(cat, true);

        assertTrue(cat.isActive());
        verify(repo).save(cat);
    }

    @Test
    void changeStatus_shouldDeactivateFigureCategory_ifActive() {
        FigureCategory cat = new FigureCategory("Aliens", "Extraterrestrial figures", now);
        assertTrue(cat.isActive());

        when(repo.save(cat)).thenReturn(cat);

        service.changeStatus(cat, false);

        assertFalse(cat.isActive());
        verify(repo).save(cat);
    }

    @Test
    void changeStatus_shouldThrowException_ifActivatingAlreadyActiveCategory() {
        FigureCategory cat = new FigureCategory("Fantasy", "Magic and myths", now); // já ativa

        assertThrows(IllegalStateException.class, () -> service.changeStatus(cat, true));

        verify(repo, never()).save(any());
    }

    @Test
    void changeStatus_shouldThrowException_ifDeactivationDateBeforeCreatedOn() {
        FigureCategory cat = new FigureCategory("Futuristic", "Futurescapes", now);

        Calendar invalidDeactivationDate = (Calendar) now.clone();
        invalidDeactivationDate.add(Calendar.DATE, -10);

        assertThrows(IllegalArgumentException.class, () -> cat.deactivate(invalidDeactivationDate));
    }


}
