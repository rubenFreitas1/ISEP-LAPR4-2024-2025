package eapli.base.app.backoffice.presentation.showProposalManagement;

import eapli.base.app.backoffice.presentation.droneModelManagement.DroneModelDTOPrinter;
import eapli.base.app.backoffice.presentation.figureManagement.FigurePrinter;
import eapli.base.droneModelManagement.dto.DroneModelDTO;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showProposalManagement.application.AddFiguresToProposalController;
import eapli.base.showProposalManagement.dto.DroneListItemDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

public class AddFiguresToProposalUI extends AbstractUI {

    private final AddFiguresToProposalController controller = new AddFiguresToProposalController();

    @Override
    protected boolean doShow() {
        Iterable<ShowProposalDTO> showProposalList = this.controller.getListShowProposals();
        if (!showProposalList.iterator().hasNext()) {
            System.out.println("There are no registered Show Proposals in the system to add Figures!");
            return false;
        }
        String headerModel = String.format("Select Show Proposal\n#  %-30s%-30s%-30s%-30s%-30s", "DESCRIPTION", "PROPOSAL NUMBER", "CUSTOMER NAME", "DATE", "DURATION");
        SelectWidget<ShowProposalDTO> selectorShowProposal = new SelectWidget<>(headerModel, showProposalList, new ShowProposalDTOPrinter());
        selectorShowProposal.show();
        ShowProposalDTO showProposal = selectorShowProposal.selectedElement();
        if (showProposal == null) {
            System.out.println("Show Proposal cannot be null!");
            return false;
        }
        if (addingFigures(showProposal)) {
            this.controller.save(showProposal);
        }
        return true;
    }

    private boolean addingFigures(ShowProposalDTO showProposal) {
        Iterable<Figure> figureList = this.controller.getListFigures(showProposal);
        if (!figureList.iterator().hasNext()) {
            System.out.println("There is no available Figures!");
            return false;
        }

        List<Figure> sequence = new ArrayList<>();
        String response = Console.readLine("Do you wish to create a new sequence? (y/n): ");
        if ("y".equalsIgnoreCase(response)) {
            sequence = createNewSequence(figureList);
        } else {
            sequence = this.controller.selectExistingFigures(showProposal);
        }

        if (!sequence.isEmpty()) {
            associateFiguresToDroneModels(showProposal, sequence);
        }

        return true;
    }

    private List<Figure> createNewSequence(Iterable<Figure> figureList) {
        List<Figure> sequence = new ArrayList<>();
        Figure previousFigure = null;

        while (true) {
            String headerModel = String.format("Select a Figure\n#  %-30s%-30s%-30s%-30s", "DESCRIPTION", "CATEGORY", "ACTIVE", "EXCLUSIVE");
            SelectWidget<Figure> selectorFigure = new SelectWidget<>(headerModel, figureList, new FigurePrinter());
            selectorFigure.show();
            Figure selectedFigure = selectorFigure.selectedElement();

            if (selectedFigure == null) {
                System.out.println("Figure can't be null!");
                continue;
            }

            if (selectedFigure.equals(previousFigure)) {
                System.out.println("You can't repeat the same Figure twice!");
                continue;
            }

            sequence.add(selectedFigure);
            previousFigure = selectedFigure;

            for (Figure figure : sequence) {
                System.out.print(figure.description() + " > ");
            }
            System.out.println();

            String addMore = Console.readLine("Do you wish to add more Figures? (y/n): ");
            if (!"y".equalsIgnoreCase(addMore)) {
                break;
            }
        }

        return sequence;
    }


    private void associateFiguresToDroneModels(ShowProposalDTO showProposal, List<Figure> figures) {
        List<DroneModelDTO> listDroneModels = new ArrayList<>();
        for (DroneListItemDTO droneListItem : showProposal.getListItemDTOS()) {
            listDroneModels.add(droneListItem.getDroneModelDTO());
        }

        if (listDroneModels.isEmpty()) {
            System.out.println("Não existem modelos de drones associados a esta proposta de show!");
            return;
        }

        int sequenceNumber = 1;
        for (Figure figure : figures) {
            boolean addMoreDrones = true;

            while (addMoreDrones) {
                System.out.println("Select a Drone Model to associate to the figure : " + figure.description());
                String headerModel = String.format("Select a Drone Model\n#  %-30s%-30s%-30s%-30s", "MODEL NAME", "MANUFACTURER", "STATUS", "CREATED BY");
                SelectWidget<DroneModelDTO> selectorDrone = new SelectWidget<>(headerModel, listDroneModels, new DroneModelDTOPrinter());
                selectorDrone.show();
                DroneModelDTO selectedDrone = selectorDrone.selectedElement();

                if (selectedDrone == null) {
                    System.out.println("The Drone Model can't be null please select again.");
                    continue;
                }

                if (this.controller.addFigureWithDroneModel(showProposal, figure, selectedDrone, sequenceNumber)) {
                    System.out.println("Figure associated with success to Drone Model : " + selectedDrone.getModelName());
                } else {
                    System.out.println("Failed to associate Figure to Drone Model : " + selectedDrone.getModelName());
                }

                String response = Console.readLine("Do you wish to add more Drones Models to this Figure? (y/n): ");
                addMoreDrones = "y".equalsIgnoreCase(response);
            }
            sequenceNumber++;
        }
    }

    @Override
    public String headline() {
        return "Add Figures to Show Proposal";
    }
}