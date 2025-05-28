package eapli.base.representativeManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.usermanagement.domain.ExemploPasswordPolicy;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RepresentativeTest {

    private Calendar now;
    private SystemUser user;
    private Customer customer;
    private final PasswordEncoder passwordEncoder = new PlainTextEncoder();
    private final PasswordPolicy passwordPolicy = new ExemploPasswordPolicy();

    @BeforeEach
    void setUp() {
        now = Calendar.getInstance();
        user = new SystemUserBuilder( passwordPolicy, passwordEncoder)
                .with("john", "StrongPass123", "John", "Doe", "john@email.com")
                .withRoles(Roles.ADMIN).build();

        Name name = Name.valueOf("Acme Corp", "Inc.");
        EmailAddress email = EmailAddress.valueOf("acme@email.com");
        Optional<Password> password = Password.encodedAndValid("VAT123", passwordPolicy, passwordEncoder);
        customer = new Customer(name, "Acme Corp", email, password, "911234567", "CC123456", user, Customer.CustomerStatus.CREATED, now);
    }

    @Test
    void constructor_shouldCreateRepresentative() {
        Name name = Name.valueOf("Alice", "Smith");
        EmailAddress email = EmailAddress.valueOf("alice@email.com");
        Optional<Password> password = Password.encodedAndValid("password123", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "912345678",
                customer,
                "Sales Manager",
                user
        );

        assertEquals("Alice Smith", rep.representativeName());
        assertEquals("alice@email.com", rep.representativeEmail());
        assertEquals("password123", rep.representativePassword());
        assertEquals("912345678", rep.representativePhoneNumber());
        assertEquals(customer, rep.associatedCustomer());
        assertEquals("Sales Manager", rep.representativePosition());
        assertEquals(user, rep.createdBy());
        assertTrue(rep.isActive());
        assertNotNull(rep.createdOn());
        assertNull(rep.deactivatedOn());
    }

    @Test
    void deactivate_validDate_shouldDeactivateRepresentative() {
        Name name = Name.valueOf("Bob", "Jones");
        EmailAddress email = EmailAddress.valueOf("bob@email.com");
        Optional<Password> password = Password.encodedAndValid("pass123", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "923456789",
                customer,
                "Support",
                user
        );

        Calendar futureDate = (Calendar) now.clone();
        futureDate.add(Calendar.DAY_OF_YEAR, 1);

        rep.deactivate(futureDate);
        assertFalse(rep.isActive());
        assertEquals(futureDate, rep.deactivatedOn());
    }

    @Test
    void deactivate_withDateBeforeCreatedOn_shouldThrowException() {
        Name name = Name.valueOf("Carla", "Lima");
        EmailAddress email = EmailAddress.valueOf("carla@email.com");
        Optional<Password> password = Password.encodedAndValid("pass123", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "933456789",
                customer,
                "Marketing",
                user
        );

        Calendar pastDate = (Calendar) now.clone();
        pastDate.add(Calendar.DAY_OF_YEAR, -1);

        assertThrows(IllegalArgumentException.class, () -> rep.deactivate(pastDate));
    }

    @Test
    void deactivate_whenAlreadyInactive_shouldThrowException() {
        Name name = Name.valueOf("David", "Silva");
        EmailAddress email = EmailAddress.valueOf("david@email.com");
        Optional<Password> password = Password.encodedAndValid("pass123", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "943456789",
                customer,
                "IT",
                user
        );

        Calendar futureDate = (Calendar) now.clone();
        futureDate.add(Calendar.DAY_OF_YEAR, 1);

        rep.deactivate(futureDate);
        assertThrows(IllegalStateException.class, () -> rep.deactivate(futureDate));
    }

    @Test
    void activate_shouldReactivateRepresentative() {
        Name name = Name.valueOf("Eva", "Costa");
        EmailAddress email = EmailAddress.valueOf("eva@email.com");
        Optional<Password> password = Password.encodedAndValid("pass123", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "953456789",
                customer,
                "Logistics",
                user
        );

        Calendar futureDate = (Calendar) now.clone();
        futureDate.add(Calendar.DAY_OF_YEAR, 1);

        rep.deactivate(futureDate);
        rep.activate();

        assertTrue(rep.isActive());
        assertNull(rep.deactivatedOn());
    }

    @Test
    void changeMethods_shouldUpdateFieldsCorrectly() {
        Name name = Name.valueOf("Felipe", "Oliveira");
        EmailAddress email = EmailAddress.valueOf("felipe@email.com");
        Optional<Password> password = Password.encodedAndValid("oldpass123", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "963456789",
                customer,
                "Analyst",
                user
        );

        Name newName = Name.valueOf("Felipe", "Santos");
        EmailAddress newEmail = EmailAddress.valueOf("felipe.santos@email.com");
        Optional<Password> newPassword = Password.encodedAndValid("newpass123", passwordPolicy, passwordEncoder);
        rep.changeName(newName);
        rep.changeEmail(newEmail);
        rep.changePassword(newPassword);
        rep.changePhoneNumber("964444444");
        rep.changePosition("Senior Analyst");

        assertEquals("Felipe Santos", rep.representativeName());
        assertEquals("felipe.santos@email.com", rep.representativeEmail());
        assertEquals("newpass123", rep.representativePassword());
        assertEquals("964444444", rep.representativePhoneNumber());
        assertEquals("Senior Analyst", rep.representativePosition());
    }

    @Test
    void toString_shouldContainRelevantData() {
        Name name = Name.valueOf("Gustavo", "Martins");
        EmailAddress email = EmailAddress.valueOf("gustavo@email.com");
        Optional<Password> password = Password.encodedAndValid("secret", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "965555555",
                customer,
                "Engineer",
                user
        );

        String repString = rep.toString();
        assertTrue(repString.contains("Gustavo Martins"));
        assertTrue(repString.contains("gustavo@email.com"));
        assertTrue(repString.contains("Engineer"));
    }

    @Test
    void changeChangedOn_shouldUpdateChangedOnField() throws InterruptedException {
    Name name = Name.valueOf("Helena", "Fernandes");
        EmailAddress email = EmailAddress.valueOf("helena@email.com");
        Optional<Password> password = Password.encodedAndValid("mypassword", passwordPolicy, passwordEncoder);
        Representative rep = new Representative(
                name,
                email,
                now,
                password,
                "967777777",
                customer,
                "Manager",
                user
        );

        Calendar originalChangedOn = rep.createdOn();

        Thread.sleep(10);

        rep.changeChangedOn();

        Calendar updatedChangedOn = rep.changedOn();

        assertNotNull(updatedChangedOn);
        assertTrue(updatedChangedOn.after(originalChangedOn),
                "Expected changedOn to be after the original value");
    }

}
