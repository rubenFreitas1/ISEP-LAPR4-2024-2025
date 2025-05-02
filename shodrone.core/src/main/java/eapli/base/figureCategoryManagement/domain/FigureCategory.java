package eapli.base.figureCategoryManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.util.Calendar;

@Entity
public class FigureCategory implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long figureCategoryId;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;
    private boolean active;
    @Temporal(TemporalType.DATE)
    private Calendar changedOn;



    protected FigureCategory() {
    }

    public FigureCategory(final String name, final String description, final Calendar createdOn) {
        Preconditions.noneNull(new Object[]{name, description});
        this.name = name;
        this.description = description;
        this.active = true;
        this.createdOn = createdOn == null ? Calendar.getInstance() : createdOn;
        this.changedOn = createdOn == null ? Calendar.getInstance() : createdOn;
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return this.description;
    }

    public Calendar createdOn() {return this.createdOn;}

    public Calendar changedOn() {return this.changedOn;}

    public boolean isActive() {
        return this.active;
    }

    public void deactivate(final Calendar changedOn) {
        if (changedOn != null && !changedOn.before(this.createdOn)) {
            if (!this.active) {
                throw new IllegalStateException("FigureCategory is already deactivated");
            }
            this.active = false;
            this.changedOn = changedOn;
        } else {
            throw new IllegalArgumentException("Deactivation date cannot be before creation date");
        }
    }

    public void activate(final Calendar changedOn) {
        if (!this.isActive()) {
            this.active = true;
            this.changedOn = changedOn == null ? Calendar.getInstance() : changedOn;
        } else {
            throw new IllegalStateException("FigureCategory is already active");
        }
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FigureCategory)) {
            return false;
        }
        FigureCategory that = (FigureCategory) other;
        return this.name.equals(that.name);
    }

    @Override
    public String toString() {
        return "FigureCategory{" +
                "figureCategoryId=" + figureCategoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdOn=" + createdOn +
                ", active=" + active +
                ", changedOn=" + changedOn +
                '}';
    }


    @Override
    public Long identity() {
        return figureCategoryId;
    }
}
