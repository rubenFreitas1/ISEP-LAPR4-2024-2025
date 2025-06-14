package eapli.base.figureManagement.repository;

import eapli.base.figureManagement.domain.DSL;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface DSLRepository extends DomainRepository<Long, DSL> {

    Optional<DSL> findByFilePath(String filePath);

    Iterable<DSL> findByVersion(String version);
}
