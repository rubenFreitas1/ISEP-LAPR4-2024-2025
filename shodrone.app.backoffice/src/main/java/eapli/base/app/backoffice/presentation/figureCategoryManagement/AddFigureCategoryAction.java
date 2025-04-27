package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.framework.actions.Action;

public class AddFigureCategoryAction implements Action {

    @Override
    public boolean execute() {
        return new AddFigureCategoryUI().show();
    }
}
