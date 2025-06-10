package eapli.base.showRequestManagement.dto;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showProposalManagement.domain.DroneListItem;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class ShowRequestDTO {

    private Long showRequestId;
    private Calendar createdOn;
    private Calendar editedOn;
    private Calendar date;
    private GeoLocation location;
    private String description;
    private int droneNumber;
    private int duration;
    private ShowStatus status;
    private CustomerDTO customer;
    private List<Long> requestedFiguresId;
    private String createdByUsername;

    public ShowRequestDTO() {}

    public ShowRequestDTO(Long showRequestId, Calendar createdOn, Calendar editedOn, Calendar date, GeoLocation location, String description, int droneNumber, int duration, ShowStatus status, Customer customer, List<Figure> requestedFiguresId, String createdByUsername) {
        this.showRequestId = showRequestId;
        this.createdOn = createdOn;
        this.editedOn = editedOn;
        this.date = date;
        this.location = location;
        this.description = description;
        this.droneNumber = droneNumber;
        this.duration = duration;
        this.status = status;
        this.customer = convertCustomerToDTO(customer);
        this.requestedFiguresId = getFigureId(requestedFiguresId);
        this.createdByUsername = createdByUsername;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public Long getShowRequestId() {
        return showRequestId;
    }

    public Calendar getEditedOn() {
        return editedOn;
    }

    public String getCreatedByUsername() {
        return createdByUsername;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public List<Long> getRequestedFiguresId() {
        return requestedFiguresId;
    }

    public ShowStatus getStatus() {
        return status;
    }

    public int getDuration() {
        return duration;
    }

    public int getDroneNumber() {
        return droneNumber;
    }

    public String getDescription() {
        return description;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public Calendar getDate() {
        return date;
    }
    private CustomerDTO convertCustomerToDTO(Customer customer) {
        return customer.toDTO();
    }
    private List<Long> getFigureId(List<Figure> figureList) {
        List<Long> figureIds = new ArrayList<>();
        for (Figure figure : figureList) {
            figureIds.add(figure.figureId());
        }
        return figureIds;
    }
}
