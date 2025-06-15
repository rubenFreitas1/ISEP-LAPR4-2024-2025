package eapli.base.customerManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Optional;

@Component
public class CustomerManagementService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordPolicy passwordPolicy;

    public CustomerManagementService(final CustomerRepository customerRepository, final PasswordEncoder passwordEncoder, final PasswordPolicy passwordPolicy) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = new PlainTextEncoder();
        this.passwordPolicy = new ExemploPasswordPolicy();
    }

    public Customer registerNewCustomer(final String customerFirstName,final String customerLastName, final String customerAddress, final String customerEmail, final String password, final String customerPhoneNumber, final String customerVatNumber, final SystemUser createdBy, final Customer.CustomerStatus status, final Calendar createdOn) {
        Name newCustomerName = Name.valueOf(customerFirstName, customerLastName);

        if (customerAddress == null || customerAddress.isEmpty()) {
            throw new IllegalArgumentException("Customer address cannot be null or empty");
        }
        EmailAddress customerEmailAddress = EmailAddress.valueOf(customerEmail);

        Optional<Password> customerPassword = Password.encodedAndValid(password, passwordPolicy, passwordEncoder);

        if (customerPassword.isEmpty()) {
            throw new IllegalArgumentException("Invalid password according to policy.");
        }
        if (customerVatNumber == null || customerVatNumber.isEmpty() || isVatNumberUsed(customerVatNumber)) {
            throw new IllegalArgumentException("Customer VAT number cannot be null or empty");
        }
        if (createdBy == null) {
            throw new IllegalArgumentException("Created by cannot be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Customer status cannot be null");
        }
        Customer newCustomer = new Customer(newCustomerName, customerAddress, customerEmailAddress, customerPassword, customerPhoneNumber, customerVatNumber, createdBy, status, createdOn);
        return (Customer) this.customerRepository.save(newCustomer);
    }

    public Customer registerNewCustomer(final String customerFirstName,final String customerLastName, final String customerAddress, final String customerEmail, final String password, final String customerPhoneNumber, final String customerVatNumber, final SystemUser createdBy) {
        return registerNewCustomer(customerFirstName, customerLastName, customerAddress, customerEmail, password, customerPhoneNumber, customerVatNumber, createdBy, Customer.CustomerStatus.CREATED, CurrentTimeCalendars.now());
    }

    public Optional<Customer> findCustomerById(final Long id) {
        return this.customerRepository.findById(id);
    }

    public Iterable<Customer> findAllActiveCustomers() {
        return this.customerRepository.findByActive();
    }

    public Iterable<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer changeCustomerStatus(final Customer customer, final Customer.CustomerStatus status) {
        customer.changeStatus(status);
        return (Customer) this.customerRepository.save(customer);
    }

    public boolean isVatNumberUsed(String customerVatNumber) {
        return this.customerRepository.isVatNumberUsed(customerVatNumber);
    }
}
