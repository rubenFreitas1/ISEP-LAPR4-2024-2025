package eapli.base.app.backoffice.presentation.droneModelManagement;

import eapli.framework.actions.Action;

public class AddDroneModelAction implements Action {
    @Override
    public boolean execute() {
        return new AddDroneModelUI().show();
    }
}
