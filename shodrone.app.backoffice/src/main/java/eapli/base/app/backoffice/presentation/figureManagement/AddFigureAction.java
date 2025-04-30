package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.framework.actions.Action;

public class AddFigureAction implements Action {

    @Override
    public boolean execute() {
        return new AddFigureUI().show();
    }
}
