package eapli.base.persistence.impl.inmemory;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryFigureRepository extends InMemoryDomainRepository<Figure, Long>
            implements FigureRepository {
    @Override
    public Optional<Figure> findByKeyword(String keyword) {
        final String keywordLower = keyword.toLowerCase();
        return matchOne(figure ->
                figure.keywords().stream()
                        .anyMatch(k -> k.equalsIgnoreCase(keywordLower))
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
}
