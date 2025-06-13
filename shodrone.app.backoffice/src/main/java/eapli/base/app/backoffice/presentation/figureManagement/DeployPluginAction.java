package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.framework.actions.Action;

public class DeployPluginAction implements Action{
    @Override
    public boolean execute() {
        return new DeployPluginUI().show();
    }
}
