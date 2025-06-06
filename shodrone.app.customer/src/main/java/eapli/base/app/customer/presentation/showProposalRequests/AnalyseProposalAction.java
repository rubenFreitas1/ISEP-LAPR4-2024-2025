package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.framework.actions.Action;

public class AnalyseProposalAction implements Action {

    private final String customerEmail;

    public AnalyseProposalAction(String customerEmail) {
        this.customerEmail = customerEmail;
    }


        @Override
    public boolean execute() {
        return new AnalyseProposalUI(customerEmail).show();
    }
}
