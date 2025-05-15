package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.framework.actions.Action;

public class EditRepresentativeAction implements Action {
    @Override
    public boolean execute() {
        return new EditRepresentativeUI().show();
    }
}
