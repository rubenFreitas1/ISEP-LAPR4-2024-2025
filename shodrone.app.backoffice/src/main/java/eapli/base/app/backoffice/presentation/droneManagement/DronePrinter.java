package eapli.base.app.backoffice.presentation.droneManagement;

import eapli.base.droneManagement.domain.Drone;
import eapli.framework.visitor.Visitor;

public class DronePrinter implements Visitor<Drone> {
    @Override
    public void visit(Drone visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.serialNumber(), visitee.droneModel().modelName(), visitee.isActive() ? "Active" : "Inactive", visitee.createdBy().name());
    }
}
