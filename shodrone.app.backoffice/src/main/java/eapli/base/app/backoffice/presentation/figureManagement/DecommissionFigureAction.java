package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.framework.actions.Action;

public class DecommissionFigureAction implements Action {

    @Override
    public boolean execute() {
        return new DecommissionFigureUI().show();
    }
}
