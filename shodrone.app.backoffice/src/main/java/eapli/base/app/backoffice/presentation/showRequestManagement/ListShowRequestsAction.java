package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.framework.actions.Action;

public class ListShowRequestsAction implements Action {

    @Override
    public boolean execute() {
        return new ListShowRequestsUI().show();
    }
}
