package eapli.base.figureManagement.domain;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.text.Normalizer;
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

    @ElementCollection
    private Set<String> normalizedKeywords;

    private String description;

    @ManyToOne
    private FigureCategory figureCategory;

    @ManyToOne
    private SystemUser createdBy;

    private boolean exclusive;

    private boolean active;

    @Version
    private Long version;

    @ManyToOne
    private Customer customer;

    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    protected Figure(){
    }

    public Figure(final String description, Set<String> keywords, FigureCategory figureCategory, boolean exclusive, Customer customer, SystemUser createdBy) {
        Preconditions.noneNull(new Object[] {keywords, figureCategory, createdBy});
        this.keywords = new HashSet<>(keywords);
        this.description = description;
        this.figureCategory = figureCategory;
        this.active = true;
        this.exclusive = exclusive;
        this.customer = customer;
        this.createdBy = createdBy;
        this.normalizedKeywords = new HashSet<>();
        for (String keyword : keywords) {
            this.normalizedKeywords.add(normalize(keyword));
        }

    }

    public Long figureId() { return figureId; }

    public Set<String> keywords(){
        return this.keywords;
    }

    public String description(){
        return this.description;
    }

    public FigureCategory figureCategory(){
        return this.figureCategory;
    }

    public Calendar deactivatedOn(){
        return this.deactivatedOn;
    }

    public Customer customer(){
        return this.customer;
    }

    public boolean isActive(){return this.active;}

    public boolean isExclusive(){return this.exclusive;}

    public Set<String> normalizedKeywords() { return this.normalizedKeywords; }

    public SystemUser createdBy() { return this.createdBy;}

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
                ", normalizedKeywords=" + normalizedKeywords +
                ", description='" + description + '\'' +
                ", figureCategory=" + figureCategory +
                ", createdBy=" + createdBy +
                ", exclusive=" + exclusive +
                ", active=" + active +
                ", customer=" + customer +
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

    private String normalize(String input) {
        if (input == null) return null;

        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}+", "").toLowerCase();
    }
}
