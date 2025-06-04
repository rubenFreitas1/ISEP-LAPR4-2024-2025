package generators;

import eapli.base.showProposalManagement.domain.DroneListItem;
import eapli.base.showProposalManagement.domain.ShowProposal;
import genShowProposalPlaceholder.ShowProposalPlaceholderBaseVisitor;
import genShowProposalPlaceholder.ShowProposalPlaceholderParser;

public class ProposalGeneratorVisitor extends ShowProposalPlaceholderBaseVisitor<String> {

    private final ShowProposal proposal;

    public ProposalGeneratorVisitor(ShowProposal proposal) {
        this.proposal = proposal;
    }

    @Override
    public String visitCompanyPlaceHolder(ShowProposalPlaceholderParser.CompanyPlaceHolderContext ctx) {
        return proposal.showRequest().customer().customerName().toString();
    }

    @Override
    public String visitAddressPlaceHolder(ShowProposalPlaceholderParser.AddressPlaceHolderContext ctx) {
        return proposal.showRequest().customer().customerAddress();
    }

    @Override
    public String visitVatNumberPlaceHolder(ShowProposalPlaceholderParser.VatNumberPlaceHolderContext ctx) {
        return proposal.showRequest().customer().customerVatNumber();
    }

    @Override
    public String visitPersonNamePlaceholder(ShowProposalPlaceholderParser.PersonNamePlaceholderContext ctx) {
        return proposal.showRequest().customer().customerName().toString();
    }

    @Override
    public String visitReferencePlaceHolder(ShowProposalPlaceholderParser.ReferencePlaceHolderContext ctx) {
        return "Referência " + proposal.identity() + " / " + proposal.createdOn();
    }

    @Override
    public String visitVip_line1_Placeholder(ShowProposalPlaceholderParser.Vip_line1_PlaceholderContext ctx) {
        return proposal.showRequest().customer().customerName().toString() + " is a VIP client and Shodrone is pleased to submit for your consideration a proposal for the execution of an aerial show with drones, as described below.";
    }

    @Override
    public String visitLine3_placeholder(ShowProposalPlaceholderParser.Line3_placeholderContext ctx) {
        return "In the link " + proposal.videoLink() + " there is a video with a simulation of the proposed show.";
    }

    @Override
    public String visitClosing_placeholder(ShowProposalPlaceholderParser.Closing_placeholderContext ctx) {
        return "With the application of AI-Test, a Shodrone exclusive, we are confident in offering liability insurance in the amount of " + proposal.insuranceAmount() + " for the show. Detailed show data is presented in the attachment.";
    }

    @Override
    public String visitManagerName_Placeholder(ShowProposalPlaceholderParser.ManagerName_PlaceholderContext ctx) {
        return proposal.createdBy().name().toString();
    }

    @Override
    public String visitAttachment_placeholder(ShowProposalPlaceholderParser.Attachment_placeholderContext ctx) {
        return "Attachment - Show Details " + proposal.identity();
    }

    @Override
    public String visitLocation_placeholder(ShowProposalPlaceholderParser.Location_placeholderContext ctx) {
        return "Location - " + proposal.location();
    }

    @Override
    public String visitDate_placeholder(ShowProposalPlaceholderParser.Date_placeholderContext ctx) {
        return "Date - " + proposal.date();
    }

    @Override
    public String visitTime_placeholder(ShowProposalPlaceholderParser.Time_placeholderContext ctx) {
        return "Time - " + proposal.time();
    }

    @Override
    public String visitDuration_placeholder(ShowProposalPlaceholderParser.Duration_placeholderContext ctx) {
        return "Duration - " + proposal.duration() + " minutes";
    }

    @Override
    public String visitDroneListPlaceholders(ShowProposalPlaceholderParser.DroneListPlaceholdersContext ctx) {
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
