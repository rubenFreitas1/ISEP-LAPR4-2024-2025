package eapli.base.figureManagement.repository;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface FigureRepository extends DomainRepository<Long, Figure> {

    Optional<Figure> findById(Long id);

    Iterable<Figure> findByKeyword(String keyword);

    Iterable<Figure> findByFigureCategory(FigureCategory figureCategory);

    Iterable<Figure> findByActive(boolean active);

    Iterable<Figure> findByExclusivity(boolean exclusive);

    Iterable<Figure> findByKeywordAndCategory(String keyword, FigureCategory category);

    Iterable <Figure> findByExclusivityAndCustomer(boolean exclusive, Customer customer);


}
