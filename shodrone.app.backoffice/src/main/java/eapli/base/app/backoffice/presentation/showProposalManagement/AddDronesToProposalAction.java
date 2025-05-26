package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.framework.actions.Action;

public class AddDronesToProposalAction implements Action {
    @Override
    public boolean execute() {
        return new AddDronesToProposalUI().show();
    }
}
