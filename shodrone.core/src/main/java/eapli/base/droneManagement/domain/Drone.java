package eapli.base.droneManagement.domain;


import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.util.Calendar;

@Entity
public class Drone implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long droneId;


    @Column(unique = true, nullable = false)
    private String serialNumber;

    @ManyToOne
    private DroneModel droneModel;


    @Temporal(TemporalType.DATE)
    private Calendar acquisitionDate;

    private boolean active;

    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    @ManyToOne
    private SystemUser createdBy;

    protected Drone(){

    }

    public Drone(final String serialNumber, final DroneModel droneModel, final Calendar acquisitionDate, final SystemUser user){
        Preconditions.noneNull(new Object[] {serialNumber, droneModel, user});

        this.serialNumber = serialNumber;
        this.droneModel = droneModel;
        this.createdBy = user;
        this.acquisitionDate = acquisitionDate == null ? CurrentTimeCalendars.now() : acquisitionDate;
        this.active = true;
    }


    public String serialNumber(){return this.serialNumber;}

    public DroneModel droneModel(){return this.droneModel;}

    public Calendar acquisitionDate(){return this.acquisitionDate;}

    public boolean isActive(){return this.active;}

    public SystemUser createdBy(){return this.createdBy;}

    public Calendar deactivatedOn(){return this.deactivatedOn;}

    public void deactivate(final Calendar deactivatedOn) {
        if (deactivatedOn != null && !deactivatedOn.before(this.acquisitionDate)) {
            if (!this.active) {
                throw new IllegalStateException("Cannot deactivate an inactive Drone!");
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
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (!(other instanceof Drone)) return false;
        Drone that = (Drone) other;
        return droneId != null && droneId.equals(that.droneId);
    }

    @Override
    public Long identity() {
        return this.droneId;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + droneId +
                ", serialNumber='" + serialNumber + '\'' +
                ", droneModel=" + droneModel +
                ", acquisitionDate=" + acquisitionDate +
                ", active=" + active +
                ", deactivatedOn=" + deactivatedOn +
                ", createdBy=" + createdBy +
                '}';
    }
}
