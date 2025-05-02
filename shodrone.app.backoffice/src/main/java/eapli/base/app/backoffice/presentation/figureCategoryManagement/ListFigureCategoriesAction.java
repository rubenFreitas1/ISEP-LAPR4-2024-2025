package eapli.base.app.backoffice.presentation.figureCategoryManagement;

import eapli.framework.actions.Action;

public class ListFigureCategoriesAction implements Action {
    @Override
    public boolean execute() {
        return new ListFigureCategoriesUI().show();
    }
}
