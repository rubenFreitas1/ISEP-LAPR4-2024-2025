package eapli.base.app.customer.presentation.showProposalRequests;

import eapli.framework.actions.Action;

public class ScheduledShowsAction implements Action {

    private final String customerEmail;

    public ScheduledShowsAction(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public boolean execute() {
        return new ScheduledShowsUI(customerEmail).show();
    }
}
