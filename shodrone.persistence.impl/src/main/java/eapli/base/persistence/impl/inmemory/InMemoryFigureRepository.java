package eapli.base.persistence.impl.inmemory;

import eapli.base.customerManagement.domain.Customer;
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
                figure.normalizedKeywords().contains(normalizedKeyword)
        );
    }

    @Override
    public Optional<Figure> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
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
                        figure.normalizedKeywords().contains(normalizedKeyword)
        );
    }

    @Override
    public Iterable<Figure> findByExclusivityAndCustomer(boolean ignored, Customer customer) {
        return match(figure ->
                !figure.isExclusive() || customer.equals(figure.customer())
        );
    }

    private String normalize(String input) {
        if (input == null) return null;

        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}+", "").toLowerCase();
    }
}
