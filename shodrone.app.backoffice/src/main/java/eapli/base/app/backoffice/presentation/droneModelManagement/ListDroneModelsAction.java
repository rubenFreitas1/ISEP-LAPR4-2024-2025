package eapli.base.app.backoffice.presentation.droneModelManagement;

import eapli.framework.actions.Action;

public class ListDroneModelsAction implements Action {
    @Override
    public boolean execute() {
        return new ListDroneModelsUI().show();
    }
}
