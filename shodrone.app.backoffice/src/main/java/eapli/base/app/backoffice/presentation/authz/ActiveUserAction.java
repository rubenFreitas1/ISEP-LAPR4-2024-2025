package eapli.base.app.backoffice.presentation.authz;

import eapli.framework.actions.Action;

public class ActiveUserAction implements Action {

    @Override
    public boolean execute() {
        return new ActiveUserUI().show();
    }
}
