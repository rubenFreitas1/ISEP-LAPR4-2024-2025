package eapli.base.app.backoffice.presentation.droneModelManagement;

import eapli.base.droneModelManagement.application.ListDroneModelsController;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListDroneModelsUI extends AbstractListUI<DroneModel> {

    private final ListDroneModelsController theController = new ListDroneModelsController();

    @Override
    public String headline() {
        return "List Drone Models";
    }

    @Override
    protected Iterable<DroneModel> elements() {
        return theController.allDroneModels();
    }

    @Override
    protected Visitor<DroneModel> elementPrinter() {
        return new DroneModelPrinter();
    }

    @Override
    protected String elementName() {
        return "Drone Model";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-30s%-30s%-30s", "MODEL NAME", "MANUFACTURER", "STATUS", "CREATED BY");
    }

    @Override
    protected String emptyMessage() {
        return null;
    }
}
