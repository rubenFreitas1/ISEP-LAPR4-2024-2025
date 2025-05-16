package eapli.base.customerManagementService.application;

import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
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

import static org.mockito.Mockito.*;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerManagementServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerManagementService service;

    private Customer customer;
    private SystemUser systemUser;

    @BeforeEach
    void setUp() {
        PasswordPolicy policy = new ExemploPasswordPolicy();
        PlainTextEncoder encoder = new PlainTextEncoder();

        systemUser = new SystemUserBuilder(policy, encoder)
                .with("jdoe", "StrongPass123", "John", "Doe", "jdoe@email.com")
                .withRoles(Roles.ADMIN)
                .build();

        customer = new Customer(
                "Client Name",
                "Client Address",
                "client@email.com",
                "VAT123",
                "910000000",
                "CC123456",
                systemUser,
                Customer.CustomerStatus.CREATED,
                Calendar.getInstance()
        );
    }

    @Test
    void findAllActiveCustomers_shouldReturnActiveCustomers() {
        List<Customer> expected = List.of(customer);
        when(customerRepository.findByActive()).thenReturn(expected);

        Iterable<Customer> result = service.findAllActiveCustomers();

        assertNotNull(result);
        assertEquals(expected, result);
        verify(customerRepository).findByActive();
    }
}
