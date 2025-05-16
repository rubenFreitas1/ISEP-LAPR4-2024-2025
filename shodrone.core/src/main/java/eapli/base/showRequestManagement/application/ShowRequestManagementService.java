package eapli.base.showRequestManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Calendar;
import java.util.List;

public class ShowRequestManagementService {
    private final ShowRequestRepository showRequestRepository;

    public ShowRequestManagementService(final ShowRequestRepository showRequestRepository) {
        this.showRequestRepository = showRequestRepository;
    }
    public ShowRequest registerShowRequest(Customer customer, GeoLocation location, Calendar date, int duration, int droneNumber, List<Figure> figureSequence, String description, int altitude, SystemUser authenticatedUser) {
        //RequestedFigures newRequestedFigures = new RequestedFigures(figureSequence);
        ShowRequest newShowRequest = new ShowRequest(location, date, droneNumber, duration, figureSequence, customer, description, altitude, authenticatedUser);
        return (ShowRequest) this.showRequestRepository.save(newShowRequest);
    }

    public Iterable<ShowRequest> findByCustomer(Customer customer) {
        return this.showRequestRepository.findByCustomer(customer);
    }

    public ShowRequest editShowRequestLocation(ShowRequest showRequest, GeoLocation location) {
        showRequest.changeLocation(location);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }
    public ShowRequest editShowRequestDescription(ShowRequest showRequest, String description) {
        showRequest.changeDescription(description);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }
    public ShowRequest editShowRequestAltitude(ShowRequest showRequest, int altitude) {
        showRequest.changeAltitude(altitude);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }

    public ShowRequest editShowRequestDate(ShowRequest showRequest, Calendar date) {
        showRequest.changeDate(date);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }

    public ShowRequest editShowRequestDroneNumber(ShowRequest showRequest, int droneNumber) {
        showRequest.changeDroneNumber(droneNumber);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }

    public ShowRequest editShowRequestDuration(ShowRequest showRequest, int duration) {
        showRequest.changeDuration(duration);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }

    public ShowRequest editShowRequestSequenceOfFigures(ShowRequest showRequest, List<Figure> sequenceOfFigures) {
        showRequest.changeRequestedFigures(sequenceOfFigures);
        return (ShowRequest) this.showRequestRepository.save(showRequest);
    }
}
