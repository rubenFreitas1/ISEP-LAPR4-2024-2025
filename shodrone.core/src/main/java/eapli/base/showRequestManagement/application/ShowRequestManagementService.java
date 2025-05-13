package eapli.base.showRequestManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;

import java.util.Calendar;
import java.util.List;

public class ShowRequestManagementService {
    private final ShowRequestRepository showRequestRepository;

    public ShowRequestManagementService(final ShowRequestRepository showRequestRepository) {
        this.showRequestRepository = showRequestRepository;
    }
    public ShowRequest registerShowRequest(Customer customer, String location, Calendar date, int duration, int droneNumber, List<Figure> figureSequence) {
        //RequestedFigures newRequestedFigures = new RequestedFigures(figureSequence);
        ShowRequest newShowRequest = new ShowRequest(location, date, droneNumber, duration, figureSequence, customer);
        return (ShowRequest) this.showRequestRepository.save(newShowRequest);
    }

    public Iterable<ShowRequest> findByCustomer(Customer customer) {
        return this.showRequestRepository.findByCustomer(customer);
    }

}
