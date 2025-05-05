package eapli.base.droneModelManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.util.Calendar;

@Entity
public class DroneModel implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long droneModelId;

    @Column( unique = true, nullable = false)
    private String modelName;

    private String manufacturer;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;
    private boolean active;
    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    @ManyToOne
    private SystemUser createdBy;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private DroneWindBehavior windBehavior;

    protected DroneModel(){
    }


    public DroneModel(final String modelName, final String manufacturer,  final Calendar createdOn, final SystemUser createdBy, final DroneWindBehavior windBehavior) {
        Preconditions.noneNull(new Object[] {modelName, manufacturer, windBehavior});
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.createdBy = createdBy;
        this.createdOn = createdOn == null ? CurrentTimeCalendars.now() : createdOn;
        this.windBehavior = windBehavior;
        this.active = true;
    }

    public DroneWindBehavior windBehavior() {return this.windBehavior;}

    public String modelName (){ return this.modelName;}

    public String manufacturer(){return this.manufacturer;}

    public SystemUser createdBy(){return this.createdBy;}

    public Calendar createdOn(){return this.createdOn;}

    public boolean isActive() {return this.active;}

    public Calendar deactivatedOn(){return this.deactivatedOn;}

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
        if (!(other instanceof DroneModel)) return false;
        DroneModel that = (DroneModel) other;
        return droneModelId != null && droneModelId.equals(that.droneModelId);
    }


    @Override
    public String toString() {
        return "DroneModel{" +
                "modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public Long identity() {return this.droneModelId;}

}
