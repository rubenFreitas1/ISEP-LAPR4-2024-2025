package eapli.base.representativeManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.infrastructure.authz.domain.model.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RepresentativeManagementServiceTest {

    @Mock
    private RepresentativeRepository representativeRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private RepresentativeManagementService service;

    PasswordPolicy policy = new ExemploPasswordPolicy();
    PasswordEncoder encoder = new PlainTextEncoder();
    private Representative representative;
    private Customer customer;
    private SystemUser systemUser;

    @BeforeEach
    void setUp() {
        systemUser = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles( Roles.ADMIN).build();

        customer = new Customer("Client Name", "Client Address", "client@email.com", "VAT123", "910000000", "CC123456", systemUser, Customer.CustomerStatus.CREATED, Calendar.getInstance());

        representative = new Representative(
                "John Rep",
                "john.rep@email.com",
                Calendar.getInstance(),
                "securePass",
                "910000001",
                customer,
                "Sales",
                systemUser
        );
    }

    @Test
    void findAll_shouldReturnAllRepresentatives() {
        List<Representative> expected = List.of(representative);
        when(representativeRepository.findAll()).thenReturn(expected);

        Iterable<Representative> result = service.findAll();

        assertNotNull(result);
        assertEquals(expected, result);
        verify(representativeRepository).findAll();
    }

    @Test
    void findByAssociatedCustomer_shouldReturnCustomerRepresentatives() {
        List<Representative> expected = List.of(representative);
        when(representativeRepository.findByAssociatedCustomer(customer)).thenReturn(expected);

        Iterable<Representative> result = service.findByAssociatedCustomer(customer);

        assertNotNull(result);
        assertEquals(expected, result);
        verify(representativeRepository).findByAssociatedCustomer(customer);
    }

    @Test
    void deactivateCustomerRepresentative_shouldDeactivateAndSaveRepresentative() {
        when(representativeRepository.save(any(Representative.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Representative result = service.deactivateCustomerRepresentative(representative);

        assertNotNull(result);
        assertFalse(result.isActive());
        assertNotNull(result.deactivatedOn());
        verify(representativeRepository).save(representative);
    }
}
