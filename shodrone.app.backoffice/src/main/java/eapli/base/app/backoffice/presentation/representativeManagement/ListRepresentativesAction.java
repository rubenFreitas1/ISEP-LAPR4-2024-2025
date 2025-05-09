package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.framework.actions.Action;

public class ListRepresentativesAction implements Action {

    @Override
    public boolean execute() {
        return new ListRepresentativesUI().show();
    }
}
