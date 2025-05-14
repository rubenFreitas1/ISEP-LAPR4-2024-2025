package eapli.base.figureManagement.application;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FigureManagementServiceTest {
    @Mock
    private FigureRepository repo;

    @InjectMocks
    private FigureManagementService service;

    private FigureCategory category;
    private Figure figure;

    private final Calendar now = CurrentTimeCalendars.now();
    @BeforeEach
    public void setup() {
        category = new FigureCategory("Geometria", "Estudo de figuras geométricas", now);
        Set<String> keywords = new HashSet<>(Set.of("triângulo", "ângulo", "figura"));
        figure = new Figure("Triângulo equilátero", keywords, category, false, null);
    }

    @Test
    public void registerNewFigure_success() {
        when(repo.save(any(Figure.class))).thenAnswer(i -> i.getArguments()[0]);

        Figure result = service.registerNewFigure(
                "Triângulo equilátero",
                Set.of("triângulo", "ângulo", "figura"),
                category,
                false,
                null
        );

        assertEquals("Triângulo equilátero", result.description());
        verify(repo).save(any(Figure.class));
    }

    @Test
    public void decommissionFigure_setsInactive() {
        when(repo.save(figure)).thenReturn(figure);

        Figure result = service.decommissionFigure(figure);

        assertFalse(result.isActive());
        assertNotNull(result.deactivatedOn());
        verify(repo).save(figure);
    }

    @Test
    public void activateFigure_setsActive() {
        figure.deactivate(CurrentTimeCalendars.now());
        when(repo.save(figure)).thenReturn(figure);

        Figure result = service.activateFigure(figure);

        assertTrue(result.isActive());
        assertNull(result.deactivatedOn());
        verify(repo).save(figure);
    }

    @Test
    public void activeFigures_returnsOnlyActive() {
        List<Figure> expected = List.of(figure);
        when(repo.findByActive(true)).thenReturn(expected);

        Iterable<Figure> result = service.activeFigures();

        assertEquals(expected, result);
        verify(repo).findByActive(true);
    }

    @Test
    public void inactiveFigures_returnsOnlyInactive() {
        List<Figure> expected = List.of(figure);
        when(repo.findByActive(false)).thenReturn(expected);

        Iterable<Figure> result = service.inactiveFigures();

        assertEquals(expected, result);
        verify(repo).findByActive(false);
    }

    @Test
    public void findByCategory_returnsCorrectFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByFigureCategory(category)).thenReturn(expected);

        Iterable<Figure> result = service.findByCategory(category);

        assertEquals(expected, result);
        verify(repo).findByFigureCategory(category);
    }
    @Test
    public void findByKeyword_returnsCorrectFigures() {
        when(repo.findByKeyword("triângulo")).thenReturn(List.of(figure));

        Iterable<Figure> result = service.findByKeyword("triângulo");

        assertNotNull(result);

        List<Figure> figures = new ArrayList<>();
        result.forEach(figures::add);

        assertEquals(1, figures.size());
        assertEquals(figure, figures.get(0));
    }

    @Test
    public void findByNonExclusivity_returnsCorrectFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByExclusivity(false)).thenReturn(expected);

        Iterable<Figure> result = service.findByExclusivity(false);

        assertEquals(expected, result);
        verify(repo).findByExclusivity(false);
    }
    @Test
    public void findByKeywordAndCategory_returnsCorrectFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByKeywordAndCategory("triângulo", category)).thenReturn(expected);

        Iterable<Figure> result = service.findByKeywordAndCategory("triângulo", category);

        assertNotNull(result);
        List<Figure> figures = new ArrayList<>();
        result.forEach(figures::add);

        assertEquals(1, figures.size());
        assertEquals(figure, figures.get(0));
        verify(repo).findByKeywordAndCategory("triângulo", category);
    }

    @Test
    public void listPublicFigures_returnsNonExclusiveFigures() {
        List<Figure> expected = List.of(figure);
        when(repo.findByExclusivity(false)).thenReturn(expected);

        Iterable<Figure> result = service.listPublicFigures();

        assertNotNull(result);
        assertEquals(expected, result);
        verify(repo).findByExclusivity(false);
    }

}