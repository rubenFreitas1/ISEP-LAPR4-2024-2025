package eapli.base.app.backoffice.presentation.droneManagement;

import eapli.framework.actions.Action;


public class AddDroneAction implements Action {
    @Override
    public boolean execute() {
        return new AddDroneUI().show();
    }
}
