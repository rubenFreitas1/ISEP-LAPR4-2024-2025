package eapli.base.showRequestManagement.domain;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.domain.model.DomainEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class RequestedFigures implements DomainEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestedFiguresId;

    @Column(nullable = false)
    private List<Figure> sequence;

    protected RequestedFigures() {}

    public RequestedFigures(List<Figure> sequence) {
        this.sequence = sequence;
    }

    public List<Figure> sequence() { return this.sequence; }

    @Override
    public String toString() {
        return "RequestedFigures{" +
                "requestedFiguresId=" + requestedFiguresId +
                ", sequence=" + sequence +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}

