package eapli.base.showProposalManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Template implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long templateId;

    @Column(unique = true)
    private String name;

    @Column(name = "CONTENT", length = 5000, unique = true)
    private String content;

    protected Template() {
    }

    public Template (String name, String content) {
        Preconditions.noneNull(new Object[] {name, content});
        this.name = name;
        this.content = content;
    }


    public String name (){return this.name;}

    public String content (){return this.content;}

    @Override
    public String toString() {
        return "Template{" +
                "templateId=" + templateId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equals(templateId, template.templateId) && Objects.equals(name, template.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateId, name);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.templateId;
    }
}
