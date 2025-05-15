package eapli.base.persistence.impl.inmemory;

import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryRepresentativeRepository extends InMemoryDomainRepository<Representative, Long> implements RepresentativeRepository {

    @Override
    public Optional<Representative> findById(Long id) {
        return matchOne(e -> e.identity().equals(id));
    }

    @Override
    public Iterable<Representative> findByActive(boolean active) {
        return this.match((e) -> {
            return e.isActive() == active;
        });
    }

    @Override
    public boolean isEmailUsed(String representativeEmail) {
        return matchOne(e -> e.representativeEmail().equalsIgnoreCase(representativeEmail)).isPresent();
    }

    @Override
    public Iterable<Representative> findByAssociatedCustomer(eapli.base.customerManagement.domain.Customer associatedCustomer) {
        return this.match((e) -> {
            return e.associatedCustomer().equals(associatedCustomer);
        });
    }

    @Override
    public boolean isPhoneNumberUsed(String representativePhoneNumber) {
        return matchOne(e -> e.representativePhoneNumber().equalsIgnoreCase(representativePhoneNumber)).isPresent();
    }
}
