package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.framework.actions.Action;

public class AddFiguresToProposalAction implements Action {
    @Override
    public boolean execute() {
        return new AddFiguresToProposalUI().show();
    }
}
