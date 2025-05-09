package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.framework.actions.Action;

public class RegisterRepresentativeAction implements Action {

    @Override
    public boolean execute() {
        return new RegisterRepresentativeUI().show();
    }
}
