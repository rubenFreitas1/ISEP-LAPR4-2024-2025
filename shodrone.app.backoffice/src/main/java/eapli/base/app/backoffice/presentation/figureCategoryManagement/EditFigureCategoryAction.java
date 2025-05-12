package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.framework.actions.Action;

public class EditFigureCategoryAction implements Action {
    @Override
    public boolean execute() {
        return new EditFigureCategoryUI().show();
    }
}
