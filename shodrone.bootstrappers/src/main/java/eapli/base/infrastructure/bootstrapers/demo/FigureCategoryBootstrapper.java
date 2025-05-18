package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.figureCategoryManagement.application.AddFigureCategoryController;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FigureCategoryBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            FigureCategoryBootstrapper.class);

    private final AddFigureCategoryController addFigureCategoryController = new AddFigureCategoryController();
    @Override
    public boolean execute() {
        addFigureCategory("Logos", "Logos for companies");
        addFigureCategory("Geometric Figures", "geometric figures");
        addFigureCategory("Animals", "Animals");
        return true;
    }



    private FigureCategory addFigureCategory(final String categoryName, final String description){
        FigureCategory figureCategory = null;
        try {
            figureCategory = addFigureCategoryController.addFigureCategory(categoryName, description);
        } catch (final Exception e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", categoryName);
            LOGGER.trace("Assuming existing record", e);
        }
        return figureCategory;
    }
}
