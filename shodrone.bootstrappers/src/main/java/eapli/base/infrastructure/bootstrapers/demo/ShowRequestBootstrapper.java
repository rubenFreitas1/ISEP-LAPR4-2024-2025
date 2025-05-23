package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showRequestManagement.application.RegisterShowRequestController;
import eapli.base.showRequestManagement.domain.GeoLocation;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class ShowRequestBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            ShowRequestBootstrapper.class);

    private final RegisterShowRequestController registerShowRequestController = new RegisterShowRequestController();

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();

    private final FigureRepository figureRepository = PersistenceContext.repositories().figures();

    @Override
    public boolean execute() {
        final GeoLocation location1 = new GeoLocation(40.7128, -74.0060, 100);
        final GeoLocation location2 = new GeoLocation(34.0522, -118.2437, 55);
        Calendar now = Calendar.getInstance();
        Optional<Customer> c1 = customerRepository.findById(1L);
        Optional<Customer> c2 = customerRepository.findById(2L);
        Customer customer1 = c1.orElseThrow(() -> new IllegalArgumentException("Customer with ID 1 not found"));
        Customer customer2 = c2.orElseThrow(() -> new IllegalArgumentException("Customer with ID 2 not found"));
        Optional<Figure> f1 = figureRepository.findById(1L);
        Optional<Figure> f2 = figureRepository.findById(2L);
        Optional<Figure> f3 = figureRepository.findById(3L);
        Figure figure1 = f1.orElseThrow(() -> new IllegalArgumentException("Figure with ID 1 not found"));
        Figure figure2 = f2.orElseThrow(() -> new IllegalArgumentException("Figure with ID 2 not found"));
        Figure figure3 = f3.orElseThrow(() -> new IllegalArgumentException("Figure with ID 3 not found"));
        addShowRequest(customer1, location1, now, 30, 10, List.of(figure1, figure2), "Business Celebration", 100);
        addShowRequest(customer2, location2, now, 45, 5, List.of(figure3), "Wedding", 150);
        return true;
    }

    private ShowRequest addShowRequest(final Customer customer, final GeoLocation location, final Calendar date, final int duration, final int droneNumber, final List<Figure> figureList, final String description, final int altitude) {
        ShowRequest showRequest = null;
        try {
            showRequest = registerShowRequestController.registerShowRequest(customer, location, date, duration,droneNumber, figureList, description);
        } catch (final Exception e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", location);
            LOGGER.trace("Assuming existing record", e);
        }
        return showRequest;
    }
}
