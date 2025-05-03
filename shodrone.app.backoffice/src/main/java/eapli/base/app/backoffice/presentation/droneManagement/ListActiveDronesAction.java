package eapli.base.app.backoffice.presentation.droneManagement;

import eapli.framework.actions.Action;

public class ListActiveDronesAction implements Action {

    @Override
    public boolean execute() {
        return new ListActiveDronesUI().show();
}}

