package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.figureManagement.application.AddFigureController;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;

public class FigureBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            FigureBootstrapper.class);

    private final AddFigureController addFigureController = new AddFigureController();

    private final FigureCategoryRepository figureCategoryRepository = PersistenceContext.repositories().figureCategories();

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();


    @Override
    public boolean execute() {
        Optional<FigureCategory> fc1 = figureCategoryRepository.findById(1L);
        Optional<FigureCategory> fc2 = figureCategoryRepository.findById(2L);
        FigureCategory figureCategory = fc1.orElseThrow(() -> new IllegalArgumentException("FigureCategory with ID 1 not found"));
        FigureCategory figureCategory2 = fc2.orElseThrow(() -> new IllegalArgumentException("FigureCategory with ID 2 not found"));
        Optional<Customer> c1 = customerRepository.findById(1L);
        Customer customer = c1.orElseThrow(() -> new IllegalArgumentException("Customer with ID 1 not found"));
        addFigure("Apple Logo", Set.of("apple", "appleLogo"), figureCategory, true, customer, "filesLPROG/sample_DSL_figure_1.txt");
        addFigure("Star", Set.of("star", "estrela"), figureCategory2, false, null, "filesLPROG/sample_DSL_figure_2.txt");
        addFigure("Heart", Set.of("heart", "coração"), figureCategory2, false, null, "filesLPROG/sample_DSL_figure_3.txt");
        return true;
    }

    private Figure addFigure(final String figureDescription, final Set<String> keywords, final FigureCategory category, boolean exclusive, Customer customer, String dslPath) {
        Figure figure = null;
        try {
            figure = addFigureController.addFigure(figureDescription, keywords, category, exclusive, customer, dslPath);
        } catch (final Exception e) {
            LOGGER.warn("Assuming '{}' already exists (activate trace log for details)", figureDescription);
            System.out.println(e.getMessage());
            LOGGER.trace("Exception while adding figure '{}'", figureDescription, e);
        }
        return figure;
    }
}
