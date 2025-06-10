package eapli.base.showProposalManagement.dto;

import eapli.base.showProposalManagement.domain.DroneListItem;
import eapli.base.showProposalManagement.domain.ProposalAnswerFeedback;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowStatus;
import eapli.framework.representations.dto.DTO;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@DTO
public class ShowProposalDTO{

    private Long showProposalId;
    private Long showRequestId;
    private String customerName;
    private String showRequestDescription;
    private GeoLocation location;
    private Calendar date;
    private LocalTime time;
    private int duration;
    private int totalDroneNumber;
    private double insuranceAmount;
    private Calendar createdOn;
    private int proposalNumber;
    private String createdBy;
    private ShowStatus status;
    private String videoLink;

    private List<DroneListItemDTO> listItemDTOS;
    private String templateName;
    private String documentContent;
    private String documentCode;
    private ProposalAnswerFeedback proposalAnswerFeedback;

    public ShowProposalDTO(){}

    public ShowProposalDTO(Long showProposalId, Long showRequestId, String customerName, String showRequestDescription, GeoLocation location, Calendar date, LocalTime time, int duration, int totalDroneNumber, double insuranceAmount, Calendar createdOn, int proposalNumber, String createdBy, ShowStatus status, String videoLink, List<DroneListItem> listDroneModels, String templateName, String documentContent, String documentCode, ProposalAnswerFeedback proposalAnswerFeedback) {
        this.showProposalId = showProposalId;
        this.showRequestId = showRequestId;
        this.customerName = customerName;
        this.showRequestDescription = showRequestDescription;
        this.location = location;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.totalDroneNumber = totalDroneNumber;
        this.insuranceAmount = insuranceAmount;
        this.createdOn = createdOn;
        this.proposalNumber = proposalNumber;
        this.createdBy = createdBy;
        this.status = status;
        this.videoLink = videoLink;
        this.listItemDTOS = convertDroneItemsToDTO(listDroneModels);
        this.templateName = templateName;
        this.documentContent = documentContent;
        this.documentCode = documentCode;
        this.proposalAnswerFeedback = proposalAnswerFeedback;
    }

    public Long getShowProposalId() {
        return showProposalId;
    }

    public Long getShowRequestId() {
        return showRequestId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getShowRequestDescription() {
        return showRequestDescription;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public Calendar getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getDuration() {
        return duration;
    }

    public int getTotalDroneNumber() {
        return totalDroneNumber;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public int getProposalNumber() {
        return proposalNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public ShowStatus getStatus() {
        return status;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public List<DroneListItemDTO> getListItemDTOS() {
        return listItemDTOS;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public ProposalAnswerFeedback getProposalAnswerFeedback() {
        return proposalAnswerFeedback;
    }

    private List<DroneListItemDTO> convertDroneItemsToDTO(List<DroneListItem> droneModelList){
        return  droneModelList.stream().map(DroneListItem::toDTO).collect(Collectors.toList());
    }
}
