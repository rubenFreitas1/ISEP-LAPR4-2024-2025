package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.framework.actions.Action;

public class EditShowRequestAction implements Action{
    @Override
    public boolean execute() {
        return new EditShowRequestUI().show();
    }
}
