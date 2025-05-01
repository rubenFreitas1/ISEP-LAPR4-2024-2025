package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.framework.actions.Action;

public class SearchFigureAction implements Action {
    @Override
    public boolean execute() {
        return new SearchFigureUI().show();
    }
}
