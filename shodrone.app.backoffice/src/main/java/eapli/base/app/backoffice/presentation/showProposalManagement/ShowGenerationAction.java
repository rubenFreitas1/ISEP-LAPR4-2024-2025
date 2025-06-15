package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.framework.actions.Action;

public class ShowGenerationAction implements Action {

    @Override
    public boolean execute() {
        return new ShowGenerationUI().show();
    }
}
