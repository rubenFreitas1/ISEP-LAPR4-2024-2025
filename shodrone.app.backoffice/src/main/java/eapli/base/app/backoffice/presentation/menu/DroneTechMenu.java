package eapli.base.app.backoffice.presentation.menu;

import eapli.base.app.backoffice.presentation.droneManagement.AddDroneAction;
import eapli.base.app.backoffice.presentation.droneManagement.ListActiveDronesAction;
import eapli.base.app.backoffice.presentation.droneManagement.RemoveDroneAction;
import eapli.base.app.backoffice.presentation.droneModelManagement.AddDroneModelAction;
import eapli.base.app.backoffice.presentation.droneModelManagement.ListDroneModelsAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class DroneTechMenu {

    private static final int EXIT_OPTION = 0;

    private static final String RETURN_LABEL = "Return ";


    // DRONE MENU
    private static final int CREATE_DRONE_MODEL_OPTION = 1;

    private static final int LIST_DRONE_MODELS_OPTION = 2;
    private static final int ADD_DRONE_OPTION = 3;
    private static final int REMOVE_DRONE_OPTION = 4;
    private static final int LIST_DRONES_OPTION = 5;
    private static final int SHOW_GENERATION_OPTION = 6;
    private static final int SPECIFY_PROGRAMMING_LANGUAGE_OPTION = 7;

    public Menu buildDroneMenu() {
        final Menu menu = new Menu("Drone >");
        menu.addItem(CREATE_DRONE_MODEL_OPTION, "Create Drone Model", new AddDroneModelAction());
        menu.addItem(LIST_DRONE_MODELS_OPTION, "List Drone Models", new ListDroneModelsAction());
        menu.addItem(ADD_DRONE_OPTION, "Add Drone to Inventory", new AddDroneAction());
        menu.addItem(REMOVE_DRONE_OPTION, "Remove Drone from Inventory", new RemoveDroneAction());
        menu.addItem(LIST_DRONES_OPTION, "List Active Drones", new ListActiveDronesAction());
        //menu.addItem(SHOW_GENERATION_OPTION, "Show Generation",);
        //menu.addItem(SPECIFY_PROGRAMMING_LANGUAGE_OPTION, "Specify Programming Language",);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
