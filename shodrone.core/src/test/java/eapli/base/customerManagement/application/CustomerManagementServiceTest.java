package eapli.base.customerManagement.application;

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

    @Test
    void registerNewCustomer_shouldRegisterSuccessfully() {
        when(customerRepository.isEmailUsed("client@email.com")).thenReturn(false);
        when(customerRepository.isVatNumberUsed("CC123456")).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer result = service.registerNewCustomer(
                "Client Name",
                "Client Address",
                "client@email.com",
                "VAT123",
                "910000000",
                "CC123456",
                systemUser
        );

        assertNotNull(result);
        assertEquals("Client Name", result.customerName());
        verify(customerRepository).save(any(Customer.class));
    }

    @Test
    void registerNewCustomer_shouldThrowException_whenEmailAlreadyUsed() {
        when(customerRepository.isEmailUsed("client@email.com")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> service.registerNewCustomer(
                "Client Name",
                "Client Address",
                "client@email.com",
                "VAT123",
                "910000000",
                "CC123456",
                systemUser
        ));
    }

    @Test
    void changeCustomerStatus_shouldChangeStatusSuccessfully() {
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer updated = service.changeCustomerStatus(customer, Customer.CustomerStatus.VIP);

        assertEquals(Customer.CustomerStatus.VIP, updated.status());
        verify(customerRepository).save(customer);
    }

    @Test
    void findCustomerById_shouldReturnCustomer() {
        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));

        var result = service.findCustomerById(1L);

        assertTrue(result.isPresent());
        assertEquals(customer, result.get());
        verify(customerRepository).findById(1L);
    }

    @Test
    void findAllCustomers_shouldReturnAllCustomers() {
        List<Customer> allCustomers = List.of(customer);
        when(customerRepository.findAll()).thenReturn(allCustomers);

        var result = service.findAllCustomers();

        assertNotNull(result);
        assertEquals(allCustomers, result);
        verify(customerRepository).findAll();
    }

    @Test
    void isEmailUsed_shouldDelegateToRepository() {
        when(customerRepository.isEmailUsed("client@email.com")).thenReturn(true);

        boolean result = service.isEmailUsed("client@email.com");

        assertTrue(result);
        verify(customerRepository).isEmailUsed("client@email.com");
    }

    @Test
    void isVatNumberUsed_shouldDelegateToRepository() {
        when(customerRepository.isVatNumberUsed("CC123456")).thenReturn(true);

        boolean result = service.isVatNumberUsed("CC123456");

        assertTrue(result);
        verify(customerRepository).isVatNumberUsed("CC123456");
    }

}
