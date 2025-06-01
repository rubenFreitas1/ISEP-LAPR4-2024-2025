package generators;

import eapli.base.showProposalManagement.domain.DroneListItem;
import eapli.base.showProposalManagement.domain.ShowProposal;
import genShowProposal.ShowProposalBaseVisitor;
import genShowProposal.ShowProposalParser;

public class ProposalGeneratorVisitor extends ShowProposalBaseVisitor<String> {

    private final ShowProposal proposal;

    public ProposalGeneratorVisitor(ShowProposal proposal) {
        this.proposal = proposal;
    }

    @Override
    public String visitCompanyPlaceHolder(ShowProposalParser.CompanyPlaceHolderContext ctx) {
        return proposal.showRequest().customer().customerName().toString();
    }

    @Override
    public String visitAddressPlaceHolder(ShowProposalParser.AddressPlaceHolderContext ctx) {
        return proposal.showRequest().customer().customerAddress();
    }

    @Override
    public String visitVatNumberPlaceHolder(ShowProposalParser.VatNumberPlaceHolderContext ctx) {
        return proposal.showRequest().customer().customerVatNumber();
    }

    @Override
    public String visitPersonNamePlaceholder(ShowProposalParser.PersonNamePlaceholderContext ctx) {
        return proposal.showRequest().customer().customerName().toString();
    }

    @Override
    public String visitReferencePlaceHolder(ShowProposalParser.ReferencePlaceHolderContext ctx) {
        return "Referência " + proposal.identity() + " / " + proposal.createdOn();
    }

    @Override
    public String visitVip_line1_Placeholder(ShowProposalParser.Vip_line1_PlaceholderContext ctx) {
        return proposal.showRequest().customer().customerName().toString() + " is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.";
    }

    @Override
    public String visitLine3_placeholder(ShowProposalParser.Line3_placeholderContext ctx) {
        return "In the link " + proposal.videoLink() + " there is a video with a simulation of the proposed show.";
    }

    @Override
    public String visitClosing_placeholder(ShowProposalParser.Closing_placeholderContext ctx) {
        return "With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of " + proposal.insuranceAmount() + " for the show. Detailed show data is presented in the attachment.";
    }

    @Override
    public String visitManagerName_Placeholder(ShowProposalParser.ManagerName_PlaceholderContext ctx) {
        return proposal.createdBy().name().toString();
    }

    @Override
    public String visitAttachment_placeholder(ShowProposalParser.Attachment_placeholderContext ctx) {
        return "Attachment - Show Details " + proposal.identity();
    }

    @Override
    public String visitLocation_placeholder(ShowProposalParser.Location_placeholderContext ctx) {
        return "Location - " + proposal.location();
    }

    @Override
    public String visitDate_placeholder(ShowProposalParser.Date_placeholderContext ctx) {
        return "Date - " + proposal.date();
    }

    @Override
    public String visitTime_placeholder(ShowProposalParser.Time_placeholderContext ctx) {
        return "Time - " + proposal.time();
    }

    @Override
    public String visitDuration_placeholder(ShowProposalParser.Duration_placeholderContext ctx) {
        return "Duration - " + proposal.duration() + " minutes";
    }

    @Override
    public String visitDroneListPlaceholders(ShowProposalParser.DroneListPlaceholdersContext ctx) {
        String droneList = "";
        for (DroneListItem drone : proposal.droneListItem()) {
            droneList = drone.droneModel().modelName() + " - " + drone.numberOfDrones() + " units.";
        }
        return droneList;
    }

    //@Override
    //public String visitFigureListPlaceholder(ShowProposalParser.FigureListPlaceholderContext ctx) {

    //}
}
