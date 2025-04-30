package eapli.base.figureManagement.domain;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Figure implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long figureId;

    @ElementCollection
    private Set<String> keywords;

    private String description;

    @ManyToOne
    private FigureCategory figureCategory;

    private boolean exclusive;

    private boolean active;

    //ainda falta adicionar aqui o Customer que pediu esta figura

    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    protected Figure(){
    }

    public Figure(final String description, Set<String> keywords, FigureCategory figureCategory, boolean exclusive) {
        this.keywords = new HashSet<>(keywords);
        this.description = description;
        this.figureCategory = figureCategory;
        this.active = true;
    }

    public Set<String> keywords(){
        return this.keywords;
    }

    public String description(){
        return this.description;
    }

    public FigureCategory figureCategory(){
        return this.figureCategory;
    }

    public boolean isActive(){return this.active;}

    public boolean isExclusive(){return this.exclusive;}



    public void deactivate(final Calendar deactivatedOn) {
        if (deactivatedOn != null) {
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
    public String toString() {
        return "Figure{" +
                "figureId=" + figureId +
                ", keywords=" + keywords +
                ", description='" + description + '\'' +
                ", figureCategory=" + figureCategory +
                ", exclusive=" + exclusive +
                ", active=" + active +
                ", deactivatedOn=" + deactivatedOn +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (!(other instanceof Figure)) return false;
        Figure that = (Figure) other;
        return figureId != null && figureId.equals(that.figureId);
    }

    @Override
    public Long identity() {
        return this.figureId;
    }
}
