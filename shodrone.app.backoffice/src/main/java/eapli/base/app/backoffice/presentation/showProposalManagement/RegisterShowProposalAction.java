package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.framework.actions.Action;

public class RegisterShowProposalAction implements Action {
    @Override
    public boolean execute() {
        return new RegisterShowProposalUI().show();
    }
}
