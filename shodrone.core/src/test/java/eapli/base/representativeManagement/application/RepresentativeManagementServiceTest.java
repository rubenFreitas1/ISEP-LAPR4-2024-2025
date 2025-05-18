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

    @Test
    void registerNewRepresentative_shouldSaveCustomerWithRepresentative() {
        when(representativeRepository.isEmailUsed("new.rep@email.com")).thenReturn(false);

        service.registerNewRepresentative(
                "New Rep",
                "new.rep@email.com",
                "securePass123",
                "910000002",
                customer,
                "Marketing",
                systemUser
        );

        verify(customerRepository).save(customer);
    }

    @Test
    void registerNewRepresentative_withUsedEmail_shouldThrowException() {
        when(representativeRepository.isEmailUsed("john.rep@email.com")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () ->
                service.registerNewRepresentative(
                        "New Rep",
                        "john.rep@email.com",
                        "securePass123",
                        "910000002",
                        customer,
                        "Marketing",
                        systemUser
                )
        );
    }

    @Test
    void editRepresentative_shouldUpdateAndSaveRepresentative() {
        when(representativeRepository.isEmailUsed("john.new@email.com")).thenReturn(false);

        service.editRepresentative(representative,
                "New Name",
                "john.new@email.com",
                "newPass123",
                "910000999",
                "Director");

        verify(representativeRepository).save(representative);
        assertEquals("New Name", representative.representativeName());
        assertEquals("john.new@email.com", representative.representativeEmail());
        assertEquals("newPass123", representative.representativePassword());
        assertEquals("910000999", representative.representativePhoneNumber());
        assertEquals("Director", representative.representativePosition());
    }

    @Test
    void editRepresentative_withUsedEmail_shouldThrowException() {
        when(representativeRepository.isEmailUsed("existing@email.com")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () ->
                service.editRepresentative(representative,
                        "New Name",
                        "existing@email.com",
                        "newPass123",
                        "910000999",
                        "Director")
        );
    }

    @Test
    void activateRepresentative_shouldActivateAndSave() {
        representative.deactivate(Calendar.getInstance());
        assertFalse(representative.isActive());

        when(representativeRepository.save(any(Representative.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Representative result = service.activateRepresentative(representative);

        assertTrue(result.isActive());
        assertNull(result.deactivatedOn());
        verify(representativeRepository).save(representative);
    }

    @Test
    void isPhoneNumberUsed_shouldReturnRepositoryResult() {
        when(representativeRepository.isPhoneNumberUsed("910000001")).thenReturn(true);

        boolean result = service.isPhoneNumberUsed("910000001");

        assertTrue(result);
        verify(representativeRepository).isPhoneNumberUsed("910000001");
    }

}
