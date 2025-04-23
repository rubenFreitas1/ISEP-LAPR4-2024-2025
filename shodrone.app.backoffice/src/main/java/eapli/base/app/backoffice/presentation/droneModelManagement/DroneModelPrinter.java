package eapli.base.app.backoffice.presentation.droneModelManagement;

import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.framework.visitor.Visitor;

public class DroneModelPrinter implements Visitor<DroneModel> {
    @Override
    public void visit(DroneModel visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.modelName(), visitee.manufacturer(), visitee.isActive()? "Active" : "Inactive", visitee.createdBy().name());

    }
}
