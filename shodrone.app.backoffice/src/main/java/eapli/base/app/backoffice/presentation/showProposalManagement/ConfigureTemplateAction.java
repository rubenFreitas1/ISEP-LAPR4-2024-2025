package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.framework.actions.Action;

public class ConfigureTemplateAction implements Action {

    @Override
    public boolean execute() {
        return new ConfigureTemplateUI().show();
    }
}
