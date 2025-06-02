package eapli.base.showProposalManagement.domain;

import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Embeddable
public class ProposalAnswerFeedback{

    public enum Answer{
        ACCEPTED,
        REJECTED
    }

    @Enumerated(EnumType.STRING)
    private Answer answer;

    private String feedback;

    public ProposalAnswerFeedback(Answer answer, String feedback){
        Preconditions.noneNull(new Object[] {answer});
        this.answer = answer;
        this.feedback = feedback;
    }

    protected  ProposalAnswerFeedback(){
    }

    public Answer answer(){
        return this.answer;
    }

    public String feedback(){
        return this.feedback;
    }


    @Override
    public String toString() {
        return "ProposalAnswerFeedback{" +
                ", answer=" + answer +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
