package eapli.base.figureManagement.domain;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FigureTest {

    private FigureCategory category;
    private Set<String> keywords;

    private final Calendar now = CurrentTimeCalendars.now();


    @BeforeEach
    void setup() {
        category = new FigureCategory("Fantasy", "Fantasy figures", now);
        keywords = new HashSet<>();
        keywords.add("dragon");
        keywords.add("magic");
    }

    @Test
    void constructor_createsActiveFigure() {
        Figure figure = new Figure("A dragon figure", keywords, category, true);
        assertEquals("A dragon figure", figure.description());
        assertEquals(category, figure.figureCategory());
        assertTrue(figure.isActive());
        assertTrue(figure.keywords().contains("dragon"));
    }

    @Test
    void constructor_nullKeywords_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Figure("Invalid figure", null, category, false);
        });
    }

    @Test
    void constructor_nullCategory_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Figure("Invalid figure", keywords, null, false);
        });
    }

    @Test
    void deactivate_setsInactiveAndStoresDate() {
        Figure figure = new Figure("Alien sculpture", keywords, category, false);
        Calendar today = Calendar.getInstance();

        figure.deactivate(today);

        assertFalse(figure.isActive());
        assertEquals(today, figure.deactivatedOn());
    }

    @Test
    void deactivate_alreadyInactive_throwsException() {
        Figure figure = new Figure("Alien sculpture", keywords, category, false);
        Calendar today = Calendar.getInstance();
        figure.deactivate(today);

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> figure.deactivate(today));

        assertEquals("Cannot deactivate an inactive Drone!", exception.getMessage());
    }

    @Test
    void deactivate_nullDate_throwsException() {
        Figure figure = new Figure("Alien sculpture", keywords, category, false);

        assertThrows(IllegalArgumentException.class, () -> figure.deactivate(null));
    }

    @Test
    void activate_reactivatesFigureAndClearsDeactivationDate() {
        Figure figure = new Figure("Alien sculpture", keywords, category, false);
        Calendar today = Calendar.getInstance();
        figure.deactivate(today);

        figure.activate();

        assertTrue(figure.isActive());
        assertNull(figure.deactivatedOn());
    }


}