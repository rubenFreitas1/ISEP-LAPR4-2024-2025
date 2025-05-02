package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.framework.actions.Action;

public class RegisterShowRequestAction implements Action {
    @Override
    public boolean execute() {
        return new RegisterShowRequestUI().show();
    }
}
