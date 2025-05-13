package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.framework.actions.Action;

public class DisableRepresentativeAction implements Action {
    @Override
    public boolean execute() {
        return new DisableRepresentativeUI().doShow();
    }
}
