package eapli.base.representativeManagement.domain;


import eapli.base.customerManagement.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import jakarta.persistence.*;

import java.util.Calendar;

@Entity
public class Representative implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long representativeId;
    @Column
    private String representativeName;
    @Column( unique = true, nullable = false)
    private String representativeEmail;
    @Column
    private String representativePassword;
    @Column
    private String representativePhoneNumber;

    @ManyToOne
    private Customer associatedCustomer;
    @Column
    private String representativePosition;

    private boolean active;
    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;
    @ManyToOne
    private SystemUser createdBy;

    protected Representative() {
    }

    public Representative(final String representativeName, final String representativeEmail, final Calendar createdOn, final String representativePassword, final String representativePhoneNumber, final Customer associatedCustomer, final String representativePosition, final SystemUser createdBy) {
        this.representativeName = representativeName;
        this.representativeEmail = representativeEmail;
        this.representativePassword = representativePassword;
        this.representativePhoneNumber = representativePhoneNumber;
        this.associatedCustomer = associatedCustomer;
        this.representativePosition = representativePosition;
        this.createdBy = createdBy;
        this.createdOn = createdOn == null ? CurrentTimeCalendars.now() : createdOn;
        this.active = true;
    }

    public String representativeName() {
        return this.representativeName;
    }
    public String representativeEmail() {
        return this.representativeEmail;
    }
    public String representativePassword() {
        return this.representativePassword;
    }
    public String representativePhoneNumber() {
        return this.representativePhoneNumber;
    }
    public Customer associatedCustomer() {
        return this.associatedCustomer;
    }
    public String representativePosition() {
        return this.representativePosition;
    }
    public SystemUser createdBy() {
        return this.createdBy;
    }
    public Calendar createdOn() {
        return this.createdOn;
    }
    public boolean isActive() {
        return this.active;
    }
    public Calendar deactivatedOn(){
        return this.deactivatedOn;
    }
    public void deactivate(final Calendar deactivatedOn) {
        if (deactivatedOn != null && !deactivatedOn.before(this.createdOn)) {
            if (!this.active) {
                throw new IllegalStateException("Cannot deactivate an inactive Drone Model!");
            } else {
                this.active = false;
                this.deactivatedOn = deactivatedOn;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void activate() {
        if (!this.isActive()) {
            this.active = true;
            this.deactivatedOn = null;
        }
    }
    @Override
    public boolean sameAs(final Object other) {
        if (this == other) return true;
        if (!(other instanceof Representative)) return false;
        Representative that = (Representative) other;
        return representativeId != null && representativeId.equals(that.representativeId);
    }
    @Override
    public String toString() {
        return "Representative{" +
                "representativeName='" + representativeName + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                ", representativePassword='" + representativePassword + '\'' +
                ", representativePhoneNumber='" + representativePhoneNumber + '\'' +
                ", associatedCustomer=" + associatedCustomer +
                ", representativePosition='" + representativePosition + '\'' +
                ", active=" + active +
                '}';
    }
    @Override
    public Long identity() {
        return this.representativeId;
    }
}
