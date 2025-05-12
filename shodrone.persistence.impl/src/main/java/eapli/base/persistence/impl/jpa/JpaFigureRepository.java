package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaFigureRepository extends JpaAutoTxRepository<Figure, Long, Long> implements FigureRepository {
    public JpaFigureRepository(TransactionalContext autoTx){ super(autoTx, "figureId");}

    public JpaFigureRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(), "figureId");
    }

    @Override
    public Iterable<Figure> findByKeyword(String keyword) {
        final String normalizedKeyword = normalize(keyword); // normalize keyword here

        final Map<String, Object> params = new HashMap<>();
        params.put("keyword", normalizedKeyword);

        return match(
                "EXISTS (SELECT k FROM e.keywords k WHERE LOWER(k) = :keyword)",
                params
        );
    }

    @Override
    public Iterable<Figure> findByFigureCategory(FigureCategory figureCategory) {
        final Map<String, Object> params = new HashMap<>();
        params.put("figureCategory", figureCategory);
        return match("e.figureCategory=:figureCategory", params);
    }

    @Override
    public Iterable<Figure> findByActive(boolean active) {
        final Map<String, Object> params = new HashMap<>();
        params.put("active", active);
        return match("e.active = :active", params);
    }

    @Override
    public Iterable<Figure> findByExclusivity(boolean exclusive) {
        final Map<String, Object> params = new HashMap<>();
        params.put("exclusive", exclusive);
        return match("e.exclusive = :exclusive", params);
    }

    @Override
    public Iterable<Figure> findByKeywordAndCategory(String keyword, FigureCategory category) {
        final Map<String, Object> params = new HashMap<>();
        params.put("keyword", normalize(keyword));
        params.put("category", category);

        return match(
                "e.figureCategory = :category AND EXISTS (" +
                        "SELECT k FROM e.keywords k " +
                        "WHERE LOWER(k) = :keyword" +
                        ")",
                params
        );
    }

    @Override
    public Iterable<Figure> findByExclusivityAndCustomer(boolean ignored, Customer customer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("customer", customer);
        return match("(e.exclusive = false OR e.customer = :customer)", params);
    }

    private String normalize(String input) {
        if (input == null) return null;
        return java.text.Normalizer.normalize(input, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }
}
