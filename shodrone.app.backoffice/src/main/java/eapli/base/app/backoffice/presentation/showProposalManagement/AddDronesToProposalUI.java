package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.app.backoffice.presentation.droneModelManagement.DroneModelPrinter;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.showProposalManagement.application.AddDronesToProposalController;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

public class AddDronesToProposalUI extends AbstractUI {

    private final AddDronesToProposalController controller = new AddDronesToProposalController();
    @Override
    protected boolean doShow() {
        Iterable<ShowProposal> showProposalList = this.controller.getListShowProposals();
        if (!showProposalList.iterator().hasNext()) {
            System.out.println("There are no registered Show Proposals in the system to add Drone Models!");
            return false;
        }
        String headerModel = String.format("Select Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION","PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
        SelectWidget<ShowProposal> selectorShowProposal = new SelectWidget<>(headerModel, showProposalList, new ShowProposalPrinter());
        selectorShowProposal.show();
        ShowProposal showProposal = selectorShowProposal.selectedElement();
        if(showProposal == null){
            System.out.println("Show Proposal cannot be null!");
            return false;
        }
        if(addingDroneModels(showProposal)){
            this.controller.save(showProposal);
        }

        return true;
    }


    public boolean addingDroneModels(ShowProposal showProposal){
        List<DroneModel> availableDroneModels = new ArrayList<>();
        Iterable<DroneModel> droneModels = this.controller.getListDroneModels();
        for (DroneModel model : droneModels) {
            availableDroneModels.add(model);
        }
        while(true){
            int numberOfDronesLeft = showProposal.totalDroneNumber() - controller.allDronesInDroneList(showProposal);
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
            SelectWidget<DroneModel> droneModelSelectWidget = new SelectWidget<>(headerdroneModel, availableDroneModels, new DroneModelPrinter());
            droneModelSelectWidget.show();
            DroneModel droneModel = droneModelSelectWidget.selectedElement();
            if(droneModel == null){
                System.out.println("The Drone Model cannot be null!");
                break;
            }
            int quantity = Console.readInteger("Quantity:");
            try{
                if(controller.addDroneModelToProposal(showProposal, droneModel, quantity)){
                    System.out.printf("\n--- Drone Model: %s added successfully! ---\n", droneModel.modelName());
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
