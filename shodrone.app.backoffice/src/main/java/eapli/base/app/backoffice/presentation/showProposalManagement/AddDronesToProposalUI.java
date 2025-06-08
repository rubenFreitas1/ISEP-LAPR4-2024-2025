package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.app.backoffice.presentation.droneModelManagement.DroneModelDTOPrinter;
import eapli.base.droneModelManagement.dto.DroneModelDTO;
import eapli.base.showProposalManagement.application.AddDronesToProposalController;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

public class AddDronesToProposalUI extends AbstractUI {

    private final AddDronesToProposalController controller = new AddDronesToProposalController();
    @Override
    protected boolean doShow() {
        Iterable<ShowProposalDTO> showProposalList = this.controller.getListShowProposals();
        if (!showProposalList.iterator().hasNext()) {
            System.out.println("There are no registered Show Proposals in the system to add Drone Models!");
            return false;
        }
        String headerModel = String.format("Select Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION","PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
        SelectWidget<ShowProposalDTO> selectorShowProposal = new SelectWidget<>(headerModel, showProposalList, new ShowProposalDTOPrinter());
        selectorShowProposal.show();
        ShowProposalDTO showProposalDTO = selectorShowProposal.selectedElement();
        if(showProposalDTO == null){
            System.out.println("Show Proposal cannot be null!");
            return false;
        }
        if(addingDroneModels(showProposalDTO)){
            if (this.controller.save(showProposalDTO)){
                System.out.println("Show Proposal successfully saved with Drone Models!");
            }else {
                System.out.println("Show Proposal error saving!");
            }
        }

        return true;
    }


    public boolean addingDroneModels(ShowProposalDTO showProposal){
        List<DroneModelDTO> availableDroneModels = new ArrayList<>();
        Iterable<DroneModelDTO> droneModels = this.controller.getListDroneModels();
        for (DroneModelDTO model : droneModels) {
            availableDroneModels.add(model);
        }
        while(true){
            int numberOfDronesLeft = showProposal.getTotalDroneNumber() - controller.allDronesInDroneList(showProposal);
            if(numberOfDronesLeft == 0){
                System.out.println("\n--- Drone Models Successfully Added! ---\n");
                return true;
            }
            System.out.println("\n--- Number of Drones Left " + numberOfDronesLeft + " ---");
            if (availableDroneModels.isEmpty()) {
                System.out.println("No more Drone Models available to select.");
                break;
            }
            String headerdroneModel = String.format("Select Drone Model\n#  %-30s%-30s%-30s%-30s", "MODEL NAME", "MANUFACTURER", "STATUS", "CREATED BY");
            SelectWidget<DroneModelDTO> droneModelSelectWidget = new SelectWidget<>(headerdroneModel, availableDroneModels, new DroneModelDTOPrinter());
            droneModelSelectWidget.show();
            DroneModelDTO droneModel = droneModelSelectWidget.selectedElement();
            if(droneModel == null){
                System.out.println("The Drone Model cannot be null!");
                break;
            }
            int quantity = Console.readInteger("Quantity:");
            try{
                if(controller.addDroneModelToProposal(showProposal, droneModel, quantity)){
                    System.out.printf("\n--- Drone Model: %s added successfully! ---\n", droneModel.getModelName());
                  availableDroneModels.remove(droneModel);
                }else{
                    System.out.println("Error adding Drone Model!");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Add Drone Models to the Show Proposal";
    }
}
