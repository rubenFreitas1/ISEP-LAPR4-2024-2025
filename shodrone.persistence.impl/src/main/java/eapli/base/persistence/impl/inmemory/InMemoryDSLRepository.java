package eapli.base.persistence.impl.inmemory;

import eapli.base.figureManagement.domain.DSL;
import eapli.base.figureManagement.repository.DSLRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryDSLRepository extends InMemoryDomainRepository<DSL, Long>
        implements DSLRepository {

    @Override
    public Optional<DSL> findByFilePath(String filePath) {
        return matchOne(dsl -> filePath != null && filePath.equals(dsl.filePath()));
    }

    @Override
    public Iterable<DSL> findByVersion(String version) {
        return match(dsl -> version != null && version.equals(dsl.version()));
    }
}
