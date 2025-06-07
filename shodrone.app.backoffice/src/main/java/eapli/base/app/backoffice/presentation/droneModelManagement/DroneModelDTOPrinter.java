package eapli.base.app.backoffice.presentation.droneModelManagement;

import eapli.base.droneModelManagement.dto.DroneModelDTO;
import eapli.framework.visitor.Visitor;

public class DroneModelDTOPrinter implements Visitor<DroneModelDTO> {
    @Override
    public void visit(DroneModelDTO visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.getModelName(), visitee.getManufacturer(), visitee.isActive()? "Active" : "Inactive", visitee.getCreatedBy());

    }
}
