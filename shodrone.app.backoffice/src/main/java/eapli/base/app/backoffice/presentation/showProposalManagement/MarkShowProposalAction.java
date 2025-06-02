package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.framework.actions.Action;

public class MarkShowProposalAction implements Action {
    @Override
    public boolean execute() {
        return new MarkShowProposalUI().show();
    }
}
