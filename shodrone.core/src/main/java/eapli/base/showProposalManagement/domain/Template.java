package eapli.base.showProposalManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Template implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long templateId;

    private String name;

    private String content;

    protected Template() {
    }

    public Template (String name, String content) {
        this.name = name;
        this.content = content;
    }


    public String name (){return this.name;}

    public String content (){return this.content;}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.templateId;
    }
}
