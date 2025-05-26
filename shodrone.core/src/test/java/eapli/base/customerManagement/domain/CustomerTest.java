package eapli.base.customerManagement.domain;

import eapli.base.representativeManagement.domain.Representative;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Optional;

import static eapli.base.customerManagement.domain.Customer.CustomerStatus.*;
import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {

    private Customer customer;
    private Calendar now;
    private SystemUser user;

    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();

        var policy = new ExemploPasswordPolicy();
        var encoder = new PlainTextEncoder();
        user = new SystemUserBuilder(policy, encoder)
                .with("john", "StrongPass123", "John", "Doe", "john@email.com")
                .withRoles(Roles.ADMIN).build();


        Name name = Name.valueOf("John", "Doe");
        EmailAddress email = EmailAddress.valueOf("john@example.com");
        Optional<Password> password = Password.encodedAndValid("password123", policy, encoder);
        customer = new Customer(
                name,
                "123 Main St",
                email,
                password,
                "912345678",
                "PT123456789",
                user,
                CREATED,
                now
        );
    }

    @Test
    void changeStatus_success() {
        assertEquals(CREATED, customer.status());

        customer.changeStatus(REGULAR);

        assertEquals(REGULAR, customer.status());
    }

    @Test
    void addRepresentative_shouldAddSuccessfully() {
        Representative rep = new Representative("Alice Smith", "alice@email.com", now, "password123", "912345678", customer, "Sales Manager", user);

        customer.addRepresentative(rep);

        assertEquals(1, customer.representatives().size());
        assertTrue(customer.representatives().contains(rep));
    }

    @Test
    void getters_returnCorrectValues() {
        assertEquals("John Doe", customer.customerName());
        assertEquals("123 Main St", customer.customerAddress());
        assertEquals("john@example.com", customer.customerEmail());
        assertEquals("password123", customer.customerPassword());
        assertEquals("912345678", customer.customerPhoneNumber());
        assertEquals("PT123456789", customer.customerVatNumber());
        assertEquals(user, customer.createdBy());
        assertEquals(now, customer.createdOn());
        assertEquals(CREATED, customer.status());
    }

}
