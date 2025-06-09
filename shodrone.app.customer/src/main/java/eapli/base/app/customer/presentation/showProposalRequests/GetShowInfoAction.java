package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.framework.actions.Action;

public class GetShowInfoAction implements Action {
    private final String customerEmail;

    public GetShowInfoAction(String customerEmail){
        this.customerEmail = customerEmail;
    }
    @Override
    public boolean execute() {
        return new GetShowInfoUI(customerEmail).show();
    }
}
