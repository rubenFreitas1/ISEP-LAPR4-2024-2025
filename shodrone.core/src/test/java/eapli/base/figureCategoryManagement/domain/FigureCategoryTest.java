package eapli.base.figureCategoryManagement.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
class FigureCategoryTest {

    private FigureCategory figureCategory;
    private Calendar now;

    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();
        now.set(2024, Calendar.JANUARY, 1);
        figureCategory = new FigureCategory("TestCategory", "Test Description", now);
    }

    @Test
    void testConstructorValid() {
        assertEquals("TestCategory", figureCategory.name());
        assertEquals("Test Description", figureCategory.description());
        assertTrue(figureCategory.isActive());
        assertNotNull(figureCategory.createdOn());

    }

    @Test
    void testConstructorWithNullCreatedOnUsesCurrentDate() {
        FigureCategory cat = new FigureCategory("Name", "Desc", null);
        assertNotNull(cat.createdOn());
    }

    @Test
    void testConstructorWithNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new FigureCategory(null, "desc", now));
    }

    @Test
    void testConstructorWithNullDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new FigureCategory("name", null, now));
    }

    @Test
    void testDeactivateValid() {
        Calendar deactivationDate = (Calendar) now.clone();
        deactivationDate.add(Calendar.DAY_OF_MONTH, 1);
        figureCategory.deactivate(deactivationDate);

        assertFalse(figureCategory.isActive());
        assertEquals(deactivationDate, figureCategory.changedOn());
    }

    @Test
    void testDeactivateWithNullDateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> figureCategory.deactivate(null));
    }

    @Test
    void testDeactivateWithDateBeforeCreatedThrowsException() {
        Calendar pastDate = (Calendar) now.clone();
        pastDate.add(Calendar.DAY_OF_MONTH, -1);

        assertThrows(IllegalArgumentException.class, () -> figureCategory.deactivate(pastDate));
    }

    @Test
    void testDeactivateWhenAlreadyInactiveThrowsException() {
        Calendar deactivationDate = (Calendar) now.clone();
        deactivationDate.add(Calendar.DAY_OF_MONTH, 1);
        figureCategory.deactivate(deactivationDate);

        assertThrows(IllegalStateException.class, () -> figureCategory.deactivate(deactivationDate));
    }

    @Test
    void testActivateWhenInactive() {
        Calendar deactivationDate = (Calendar) now.clone();
        deactivationDate.add(Calendar.DAY_OF_MONTH, 1);
        figureCategory.deactivate(deactivationDate);

        Calendar activationDate = (Calendar) now.clone();
        activationDate.add(Calendar.DAY_OF_MONTH, 2);
        figureCategory.activate(activationDate);

        assertTrue(figureCategory.isActive());
        assertEquals(activationDate, figureCategory.changedOn());
    }

    @Test
    void testActivateWithNullDateUsesCurrentDate() {
        Calendar deactivationDate = (Calendar) now.clone();
        deactivationDate.add(Calendar.DAY_OF_MONTH, 1);
        figureCategory.deactivate(deactivationDate);

        figureCategory.activate(null);

        assertTrue(figureCategory.isActive());
        assertNotNull(figureCategory.changedOn());
    }

    @Test
    void testActivateWhenAlreadyActiveThrowsException() {
        assertThrows(IllegalStateException.class, () -> figureCategory.activate(Calendar.getInstance()));
    }

    @Test
    void testSameAsWithSameNameReturnsTrue() {
        FigureCategory other = new FigureCategory("TestCategory", "Different desc", now);
        assertTrue(figureCategory.sameAs(other));
    }

    @Test
    void testSameAsWithDifferentNameReturnsFalse() {
        FigureCategory other = new FigureCategory("OtherCategory", "desc", now);
        assertFalse(figureCategory.sameAs(other));
    }

    @Test
    void testSameAsWithDifferentObjectReturnsFalse() {
        assertFalse(figureCategory.sameAs("not a category"));
    }

    @Test
    void testSameAsWithSelfReturnsTrue() {
        assertTrue(figureCategory.sameAs(figureCategory));
    }

    @Test
    void testIdentityReturnsId() {
        assertNull(figureCategory.identity()); // ID is null until persisted
    }

    @Test
    void testToStringIncludesAllFields() {
        String str = figureCategory.toString();
        assertTrue(str.contains("TestCategory"));
        assertTrue(str.contains("Test Description"));
        assertTrue(str.contains("createdOn"));
    }

    @Test
    void testEditFigureCategoryValid() {
        String newName = "UpdatedName";
        String newDescription = "Updated Description";

        figureCategory.editFigureCategory(newName, newDescription);

        assertEquals(newName, figureCategory.name());
        assertEquals(newDescription, figureCategory.description());
        assertNotNull(figureCategory.changedOn());
    }

    @Test
    void testEditFigureCategoryWithNullNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                figureCategory.editFigureCategory(null, "Valid Description"));
    }

    @Test
    void testEditFigureCategoryWithNullDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                figureCategory.editFigureCategory("Valid Name", null));
    }

}