package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.framework.actions.Action;

public class ProposalFeedbackAction implements Action {

    private final String customerEmail;

    public ProposalFeedbackAction(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public boolean execute() {
        return new ProposalFeedbackUI(customerEmail).show();
    }
}
