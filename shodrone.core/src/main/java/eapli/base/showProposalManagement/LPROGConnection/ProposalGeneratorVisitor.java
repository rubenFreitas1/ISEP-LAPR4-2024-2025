package eapli.base.showProposalManagement.LPROGConnection;

import eapli.base.showProposalManagement.domain.DroneListItem;
import eapli.base.showProposalManagement.domain.FigureListItem;
import eapli.base.showProposalManagement.domain.ShowProposal;
import genShowProposalPlaceholder.ShowProposalPlaceholderBaseVisitor;
import genShowProposalPlaceholder.ShowProposalPlaceholderParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class ProposalGeneratorVisitor extends ShowProposalPlaceholderBaseVisitor<String> {

    private final ShowProposal proposal;

    public ProposalGeneratorVisitor(ShowProposal proposal) {
        this.proposal = proposal;
    }

    @Override
    protected String defaultResult() {
        return "";
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate == null) aggregate = "";
        if (nextResult == null) nextResult = "";
        return aggregate + nextResult;
    }

    // === PLACEHOLDERS ===

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
        return "PT" + proposal.showRequest().customer().customerVatNumber();
    }

    @Override
    public String visitPersonNamePlaceholder(ShowProposalPlaceholderParser.PersonNamePlaceholderContext ctx) {
        return proposal.showRequest().customer().customerName().toString();
    }

    @Override
    public String visitReferencePlaceHolder(ShowProposalPlaceholderParser.ReferencePlaceHolderContext ctx) {
        String originalText = ctx.getText();
        String result = originalText;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        result = result.replace("[proposal number]",String.valueOf(proposal.proposalNumber()));
        result = result.replace("[date]", sdf.format(proposal.createdOn().getTime()));

        return result;
    }

    @Override
    public String visitVip_line1_Placeholder(ShowProposalPlaceholderParser.Vip_line1_PlaceholderContext ctx) {
        String originalText = ctx.getText();
        return originalText.replace("[Company Name]", proposal.showRequest().customer().customerName().toString());
    }

    @Override
    public String visitLine3_placeholder(ShowProposalPlaceholderParser.Line3_placeholderContext ctx) {
        String originalText = ctx.getText();
        return originalText.replace("[link to show video]", proposal.videoLink());
    }

    @Override
    public String visitClosing_placeholder(ShowProposalPlaceholderParser.Closing_placeholderContext ctx) {
        String originalText = ctx.getText();
        String insuranceAmountValue = String.valueOf(proposal.insuranceAmount());

        return originalText
                .replace("[insurance amount]", insuranceAmountValue)
                .replace("[valor do seguro]", insuranceAmountValue);
    }

    @Override
    public String visitManagerName_Placeholder(ShowProposalPlaceholderParser.ManagerName_PlaceholderContext ctx) {
        return proposal.createdBy().name().toString();
    }

    @Override
    public String visitAttachment_placeholder(ShowProposalPlaceholderParser.Attachment_placeholderContext ctx) {
        String.valueOf(proposal.proposalNumber());
        String originalText = ctx.getText();
        return originalText.replace("[show proposal number]", String.valueOf(proposal.proposalNumber()));
    }

    @Override
    public String visitLocation_placeholder(ShowProposalPlaceholderParser.Location_placeholderContext ctx) {
        String originalText = ctx.getText();
        String placeholderReplacer = proposal.location().latitude() + ", " + proposal.location().longitude();
        return originalText.replace("[GPS coordinates of the location]", placeholderReplacer);
    }

    public String visitDate_placeholder(ShowProposalPlaceholderParser.Date_placeholderContext ctx) {
        String originalText = ctx.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return originalText.replace("[date of the event]", sdf.format(proposal.date().getTime()));
    }
    @Override
    public String visitTime_placeholder(ShowProposalPlaceholderParser.Time_placeholderContext ctx) {
        String originalText = ctx.getText();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return originalText.replace("[time of the event]", proposal.time().format(dateTimeFormatter));
    }

    @Override
    public String visitDuration_placeholder(ShowProposalPlaceholderParser.Duration_placeholderContext ctx) {
        String originalText = ctx.getText();
        return originalText.replace("[duration]", String.valueOf(proposal.duration()));
    }

    @Override
    public String visitDroneListPlaceholders(ShowProposalPlaceholderParser.DroneListPlaceholdersContext ctx) {
        StringBuilder droneList = new StringBuilder();

        String templateLine = ctx.getText().trim();

        for (DroneListItem drone : proposal.droneListItem()) {
            if (droneList.length() > 0) {
                droneList.append("\n");
            }

            String droneItemLine = templateLine
                    .replace("[model]", drone.droneModel().modelName())
                    .replace("[quantity]", String.valueOf(drone.numberOfDrones()));

            droneList.append(droneItemLine);
        }

        return droneList.toString();
    }

    @Override
    public String visitFigureListPlaceholder(ShowProposalPlaceholderParser.FigureListPlaceholderContext ctx) {
        StringBuilder figureList = new StringBuilder();

        String templateLine = ctx.getText().trim();
        Set<Integer> printedSequence = new HashSet<>();

        for (FigureListItem figureListItem : proposal.figureListItems()) {

            if (printedSequence.add(figureListItem.figureListItemID().sequenceNumber())) {
                if (figureList.length() > 0) {
                    figureList.append("\n");
                }

                String figureItemLine = templateLine
                        .replace("[position in show]", String.valueOf(figureListItem.figureListItemID().sequenceNumber()))
                        .replace("[figure name]", figureListItem.figure().description());

                figureList.append(figureItemLine);
            }
        }

        return figureList.toString();
    }

    // === TRATAMENTO DE TEXTO LITERAL ===
    // Para todos os outros nós que contêm texto literal, mantemos o texto original

    @Override
    public String visitTerminal(TerminalNode node) {
        return node.getText();
    }

    // === ESTRUTURAS PRINCIPAIS ===
    // Implementações específicas para estruturas que precisam de formatação especial

    @Override
    public String visitProposal(ShowProposalPlaceholderParser.ProposalContext ctx) {

        // header

        String result = visit(ctx.header()) +
                "\n" +

                // reference
                visit(ctx.reference()) +
                "\n\n" +

                // body
                visit(ctx.body()) +
                "\n\n" +

                // closing
                visit(ctx.closing()) +
                "\n\n" +

                // signature
                visit(ctx.signature()) +
                "\n\n" +

                // page break
                "[page break]" +
                "\n\n" +

                // showDetails
                visit(ctx.showDetails());

        return result;
    }

    @Override
    public String visitHeader(ShowProposalPlaceholderParser.HeaderContext ctx) {
        String result = visit(ctx.greeting()) +
                "\n" +
                visit(ctx.companyInfo());
        return result;
    }

    @Override
    public String visitCompanyInfo(ShowProposalPlaceholderParser.CompanyInfoContext ctx) {
        StringBuilder result = new StringBuilder();

        if (ctx.personName() != null) {
            result.append(visit(ctx.personName()));
            result.append("\n");
        }

        result.append(visit(ctx.company()));
        result.append("\n");
        result.append(visit(ctx.address()));
        result.append("\n");
        result.append(visit(ctx.vatNumber()));
        result.append("\n");

        return result.toString();
    }

    @Override
    public String visitReference(ShowProposalPlaceholderParser.ReferenceContext ctx) {
        String result = visit(ctx.referencePlaceHolder()) +
                "\n" +
                visit(ctx.titleProposal());
        return result;
    }

    @Override
    public String visitBody(ShowProposalPlaceholderParser.BodyContext ctx) {
        String result = visit(ctx.line_1()) +
                "\n" +
                visit(ctx.line_2()) +
                "\n" +
                visit(ctx.line_3());
        return result;
    }

    @Override
    public String visitSignature(ShowProposalPlaceholderParser.SignatureContext ctx) {
        String result = visit(ctx.signature_option()) +
                "\n" +
                visit(ctx.regards()) +
                "\n\n" +
                visit(ctx.crmManagerName()) +
                "\n" +
                "CRM Manager";
        return result;
    }

    @Override
    public String visitSignature_option(ShowProposalPlaceholderParser.Signature_optionContext ctx) {
        StringBuilder result = new StringBuilder();

        if (ctx.preferencePhrase() != null && ctx.subscribePhrase() != null) {
            result.append(visit(ctx.preferencePhrase()));
            result.append("\n\n");
            result.append(visit(ctx.subscribePhrase()));
            result.append("\n");
        } else if (ctx.lastPhrase() != null) {
            result.append(visit(ctx.lastPhrase()));
            result.append("\n");
        }

        return result.toString();
    }

    @Override
    public String visitShowDetails(ShowProposalPlaceholderParser.ShowDetailsContext ctx) {

        String result = visit(ctx.attachment()) +
                "\n\n" +
                visit(ctx.location()) +
                "\n" +
                visit(ctx.date()) +
                "\n" +
                visit(ctx.time()) +
                "\n" +
                visit(ctx.duration()) +
                "\n\n" +
                visit(ctx.droneList()) +
                "\n\n" +
                visit(ctx.figureList());

        return result;
    }


}
