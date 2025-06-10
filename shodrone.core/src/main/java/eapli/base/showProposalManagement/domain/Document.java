package eapli.base.showProposalManagement.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class Document implements ValueObject, Serializable {

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
                "finalContent='" + finalContent + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
