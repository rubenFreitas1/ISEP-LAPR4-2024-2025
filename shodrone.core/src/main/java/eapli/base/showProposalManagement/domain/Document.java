package eapli.base.showProposalManagement.domain;


import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

@Entity
public class Document implements DomainEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;

    @Column( length = 5000, unique = true)
    private String finalContent;

    @Column(unique = true)
    private String code;

    protected Document(){}

    public Document(String finalContent, String code){
        Preconditions.noneNull(new Object[]{finalContent, code});
        this.finalContent = finalContent;
        this.code = code;
    }

    public String code(){return this.code;}

    public String finalContent(){return this.finalContent;}


    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", finalContent='" + finalContent + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (!(other instanceof Document)) return false;
        Document that = (Document) other;
        return documentId != null && documentId.equals(that.documentId);
    }

    @Override
    public Long identity() {
        return this.documentId;
    }
}
