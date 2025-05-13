package eapli.base.customerManagement.domain;

import eapli.base.representativeManagement.domain.Representative;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Customer implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Column( unique = true, nullable = false)
    private String customerName;

    @Column
    private String customerAddress;
    @Column
    private String customerEmail;
    @Column
    private String customerPassword;
    @Column
    private String customerPhoneNumber;
    @Column
    private String customerVatNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Representative> representatives;

    @ManyToOne
    private SystemUser createdBy;
    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatus status;


    public enum CustomerStatus {
        DELETED,
        INFRINGEMENT,
        CREATED,
        REGULAR,
        VIP
    }

    protected Customer() {
    }

    public Customer(final String customerName, final String customerAddress, final String customerEmail, final String password, final String customerPhoneNumber, final String customerVatNumber, final SystemUser createdBy, final CustomerStatus status, final Calendar createdOn) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPassword = password;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerVatNumber = customerVatNumber;
        this.createdBy = createdBy;
        this.status = status;
        this.createdOn = createdOn == null ? CurrentTimeCalendars.now() : createdOn;
        this.representatives = new ArrayList<>();
    }

    public String customerName() {
        return this.customerName;
    }
    public String customerAddress() {
        return this.customerAddress;
    }
    public String customerEmail() {
        return this.customerEmail;
    }
    public String customerPassword() {
        return this.customerPassword;
    }
    public String customerPhoneNumber() {
        return this.customerPhoneNumber;
    }
    public String customerVatNumber() {
        return this.customerVatNumber;
    }
    public SystemUser createdBy() {
        return this.createdBy;
    }
    public Calendar createdOn() {
        return this.createdOn;
    }

    public CustomerStatus status() {
        return this.status;
    }
    public void changeStatus(CustomerStatus newStatus) {
        this.status = newStatus;
    }
    public List<Representative> representatives() {
        return this.representatives;
    }
    public void addRepresentative(Representative representative) {
        this.representatives.add(representative);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", CustomerPassword='" + customerPassword + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerVatNumber='" + customerVatNumber + '\'' +
                ", status=" + status + '\'' +
                ", createdBy=" + createdBy + '\'' +
                ", createdOn=" + createdOn + '\'' +
                ", representatives=" + representatives +
                '}';
    }

    @Override
    public boolean sameAs(final Object other) {
        if (this == other) return true;
        if (!(other instanceof Customer)) return false;
        Customer that = (Customer) other;
        return customerId != null && customerId.equals(that.customerId);
    }

    @Override
    public Long identity() {
        return this.customerId;
    }
}
