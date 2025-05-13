package eapli.base.showRequestManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.domain.model.AggregateRoot;
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
    private String location;

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
    private ShowRequestStatus status;

    @ManyToOne
    private Customer customer;

    protected ShowRequest() {}

    public ShowRequest(String location, Calendar date, int droneNumber, int duration, List<Figure> requestedFigures, Customer customer) {
        this.location = location;
        this.date = date;
        this.droneNumber = droneNumber;
        this.duration = duration;
        this.requestedFigures = requestedFigures;
        this.customer = customer;
        this.createdOn = Calendar.getInstance();
        this.status = ShowRequestStatus.PENDING;
    }

    public Calendar createdOn() { return this.createdOn; }

    public String location() { return this.location; }

    public Calendar date() { return this.date; }

    public int droneNumber() { return this.droneNumber; }

    public int duration() { return this.duration; }

    public List<Figure> requestedFigures() { return this.requestedFigures; }

    public ShowRequestStatus status() { return this.status; }

    public Customer customer() { return this.customer; }

    @Override
    public String toString() {
        return "ShowRequest{" +
                "showRequestId=" + showRequestId +
                ", createdOn=" + createdOn +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", droneNumber=" + droneNumber +
                ", duration=" + duration +
                ", requestedFigures=" + requestedFigures +
                ", status=" + status +
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
