package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.framework.actions.Action;

public class ListFigureAction implements Action {
    @Override
    public boolean execute() { return new ListFigureUI().show(); }
}
