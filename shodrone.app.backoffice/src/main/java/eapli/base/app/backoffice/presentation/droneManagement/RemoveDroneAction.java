package eapli.base.app.backoffice.presentation.droneManagement;

import eapli.framework.actions.Action;

public class RemoveDroneAction implements Action {
    @Override
    public boolean execute() {
        return new RemoveDroneUI().show();
    }
}
