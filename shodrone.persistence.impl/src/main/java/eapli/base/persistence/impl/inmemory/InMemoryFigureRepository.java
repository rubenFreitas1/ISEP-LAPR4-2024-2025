package eapli.base.persistence.impl.inmemory;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.text.Normalizer;
import java.util.Optional;

public class InMemoryFigureRepository extends InMemoryDomainRepository<Figure, Long>
            implements FigureRepository {
    @Override
    public Iterable<Figure> findByKeyword(String keyword) {
        final String normalizedKeyword = normalize(keyword);

        return match(figure ->
                figure.keywords().stream()
                        .map(this::normalize)
                        .anyMatch(k -> k.equals(normalizedKeyword))
        );
    }

    @Override
    public Iterable<Figure> findByFigureCategory(FigureCategory figureCategory) {
        return match(e -> e.figureCategory().equals(figureCategory));
    }

    @Override
    public Iterable<Figure> findByActive(boolean active) {
        return this.match((e) -> {
            return e.isActive() == active;
        });
    }

    @Override
    public Iterable<Figure> findByExclusivity(boolean exclusive) {
        return this.match((e) -> {
            return e.isExclusive() == exclusive;
        });
    }

    @Override
    public Iterable<Figure> findByKeywordAndCategory(String keyword, FigureCategory category) {
        final String normalizedKeyword = normalize(keyword);

        return match(figure ->
                figure.figureCategory().equals(category) &&
                        figure.keywords().stream()
                                .map(this::normalize)
                                .anyMatch(k -> k.equals(normalizedKeyword))
        );
    }

    private String normalize(String input) {
        if (input == null) return null;
        // Remove accents and convert to lowercase
        String noAccents = Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", ""); // Remove non-spacing marks (accents)
        return noAccents.toLowerCase(); // Convert to lowercase
    }
}
