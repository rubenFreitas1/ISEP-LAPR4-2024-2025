package eapli.base.app.testing.presentation.UI;


import eapli.framework.actions.Action;

public class ShowTestingAction implements Action {
    @Override
    public boolean execute() {
        return new ShowTestingUI().show();
    }
}
