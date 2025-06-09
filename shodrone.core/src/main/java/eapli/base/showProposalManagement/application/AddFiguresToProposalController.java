package eapli.base.showProposalManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.droneModelManagement.domain.DroneModel;
import eapli.base.droneModelManagement.dto.DroneModelDTO;
import eapli.base.droneModelManagement.dto.DroneModelDTOParser;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showProposalManagement.domain.AddFigureService;
import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.dto.ShowProposalDTO;
import eapli.base.showProposalManagement.dto.ShowProposalDTOParser;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.application.UseCaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class AddFiguresToProposalController {

    private final ShowProposalRepository showProposalRepository = PersistenceContext.repositories().showProposals();

    private final FigureRepository figureRepository = PersistenceContext.repositories().figures();

    private final AddFigureService proposalService = new AddFigureService(figureRepository);

    private final ShowProposalDTOParser showProposalDTOParser = new ShowProposalDTOParser();
    private final DroneModelDTOParser droneModelDTOParser = new DroneModelDTOParser();

    public Iterable<Figure> getListFigures(ShowProposalDTO showProposalDTO) {
        Optional<ShowProposal> showProposal = showProposalDTOParser.getShowProposalfromDTO(showProposalDTO);
        return this.figureRepository.findByExclusivityAndCustomer(true, showProposal.get().showRequest().customer());
    }

    public Iterable<ShowProposalDTO> getListShowProposals() {
        Iterable<ShowProposal> showProposals = this.showProposalRepository.findByStatusAndFilledDroneList(ShowStatus.PENDING);
        return showProposalDTOParser.transformToShowProposalDTOlist(showProposals);
     }

    public boolean addFigureWithDroneModel(ShowProposalDTO showProposaldto, Figure figure, DroneModelDTO droneModel, int sequenceNumber) {
        Optional<ShowProposal> showProposalOpt = showProposalDTOParser.getShowProposalfromDTO(showProposaldto);
        Optional<DroneModel> droneModelOpt = droneModelDTOParser.getDroneModelFromDTO(droneModel);
        if (proposalService.addFigureWithDroneModel(showProposalOpt.get(), figure, droneModelOpt.get(), sequenceNumber)) {
            this.showProposalRepository.save(showProposalOpt.get());
            return true;
        }
        return false;
    }

    public List<Figure> selectExistingFigures(ShowProposalDTO showProposal) {
        Optional<ShowProposal> proposal = showProposalDTOParser.getShowProposalfromDTO(showProposal);
        List<Figure> requestedFigures = new ArrayList<>();
        requestedFigures.addAll(proposal.get().showRequest().requestedFigures());

        return requestedFigures;
    }

    public void save(ShowProposalDTO showProposal) {
        Optional<ShowProposal> proposal = showProposalDTOParser.getShowProposalfromDTO(showProposal);
        showProposalRepository.save(proposal.get());
    }
}