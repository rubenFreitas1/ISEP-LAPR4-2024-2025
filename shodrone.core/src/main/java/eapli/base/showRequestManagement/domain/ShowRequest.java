package eapli.base.showRequestManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class ShowRequest implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long showRequestId;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @Column(nullable = false)
    private GeoLocation location;

    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    @Column(nullable = false)
    private int droneNumber;

    @Column(nullable = false)
    private int duration;

    @ManyToMany
    private List<Figure> requestedFigures;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShowStatus status;

    @ManyToOne
    private Customer customer;

    @Temporal(TemporalType.DATE)
    private Calendar editedOn;
    @ManyToOne
    private SystemUser createdBy;
    protected ShowRequest() {}

    public ShowRequest(GeoLocation location, Calendar date, int droneNumber, int duration, List<Figure> requestedFigures, Customer customer, String description, SystemUser user) {
        this.location = location;
        this.date = date;
        this.droneNumber = droneNumber;
        this.duration = duration;
        this.requestedFigures = requestedFigures;
        this.customer = customer;
        this.createdOn = Calendar.getInstance();
        this.status = ShowStatus.PENDING;
        this.description = description;
        this.createdBy = user;

    }

    public Calendar createdOn() { return this.createdOn; }

    public GeoLocation location() { return this.location; }

    public Calendar date() { return this.date; }

    public int droneNumber() { return this.droneNumber; }

    public int duration() { return this.duration; }

    public List<Figure> requestedFigures() { return this.requestedFigures; }

    public ShowStatus status() { return this.status; }

    public Customer customer() { return this.customer; }

    public String description() { return this.description; }

    public Calendar editedOn() { return this.editedOn; }

    public SystemUser user() { return this.createdBy; }

    public void changeDescription(String description) {
        if (description != null) {
            this.description = description;
            this.editedOn = Calendar.getInstance();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void changeLocation(GeoLocation location) {
        if (location != null) {
            this.location = location;
            this.editedOn = Calendar.getInstance();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void changeDate(Calendar date) {
        if (date != null) {
            this.date = date;
            this.editedOn = Calendar.getInstance();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void changeDroneNumber(Integer droneNumber) {
        if (droneNumber != 0) {
            this.droneNumber = droneNumber;
            this.editedOn = Calendar.getInstance();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void changeDuration(Integer duration) {
        if (duration != null) {
            this.duration = duration;
            this.editedOn = Calendar.getInstance();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void changeRequestedFigures(List<Figure> requestedFigures) {
        if (requestedFigures != null) {
            this.requestedFigures = requestedFigures;
            this.editedOn = Calendar.getInstance();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "ShowRequest{" +
                "showRequestId=" + showRequestId +
                ", createdOn=" + createdOn +
                ", location=" + location +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", droneNumber=" + droneNumber +
                ", duration=" + duration +
                ", requestedFigures=" + requestedFigures +
                ", status=" + status +
                ", customer=" + customer +
                ", editedOn=" + editedOn +
                ", createdBy=" + createdBy +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (!(other instanceof ShowRequest)) return false;
        ShowRequest that = (ShowRequest) other;
        return showRequestId != null && showRequestId.equals(that.showRequestId);
    }

    @Override
    public Long identity() {
        return showRequestId;
    }
}
