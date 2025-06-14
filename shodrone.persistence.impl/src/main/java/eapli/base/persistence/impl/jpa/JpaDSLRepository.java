package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.figureManagement.domain.DSL;
import eapli.base.figureManagement.repository.DSLRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaDSLRepository extends JpaAutoTxRepository<DSL, Long, Long> implements DSLRepository {

    public JpaDSLRepository(final TransactionalContext autoTx) {
        super(autoTx, "dslId");
    }

    public JpaDSLRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "dslId");
    }

    @Override
    public Optional<DSL> findByFilePath(String filePath) {
        final Map<String, Object> params = new HashMap<>();
        params.put("filePath", filePath);
        return matchOne("e.filePath = :filePath", params);
    }

    @Override
    public Iterable<DSL> findByVersion(String version) {
        final Map<String, Object> params = new HashMap<>();
        params.put("version", version);
        return match("e.version = :version", params);
    }
}
