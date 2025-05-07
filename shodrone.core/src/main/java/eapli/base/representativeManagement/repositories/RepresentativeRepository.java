package eapli.base.representativeManagement.repositories;

import eapli.base.representativeManagement.domain.Representative;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface RepresentativeRepository extends DomainRepository<Long, Representative> {

    Optional<Representative> findById(Long id);

    Iterable<Representative> findByActive(boolean active);

    boolean isEmailUsed(String representativeEmail);

}
