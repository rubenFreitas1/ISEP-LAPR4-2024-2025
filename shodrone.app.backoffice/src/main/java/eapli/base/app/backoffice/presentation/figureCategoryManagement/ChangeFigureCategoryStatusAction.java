package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.framework.actions.Action;

public class ChangeFigureCategoryStatusAction implements Action {

    @Override
    public boolean execute() {
        return new ChangeFigureCategoryStatusUI().show();
    }
}
