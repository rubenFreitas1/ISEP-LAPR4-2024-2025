package eapli.base.app.backoffice.presentation.figureManagement;

import eapli.base.figureManagement.application.DecommissionFigureController;
import eapli.base.figureManagement.domain.Figure;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class DecommissionFigureUI extends AbstractUI {

    private final DecommissionFigureController controller = new DecommissionFigureController();

    @Override
    protected boolean doShow() {
        final Iterable<Figure> figures = this.controller.activeFigures();
        if(!figures.iterator().hasNext()){
            System.out.println("There are no registered Figures");
        }else {
            String headerModel = String.format("Select Figure to Decommission\n#  %-30s%-30s%-30s%-30s", "DESCRIPTION", "FIGURE CATEGORY", "STATUS", "EXCLUSIVITY");
            final SelectWidget<Figure> selectWidget = new SelectWidget<>(headerModel, figures, new FigurePrinter());
            selectWidget.show();
            final Figure figure = selectWidget.selectedElement();
            if(figure == null) {
                System.out.println("No figure selected");
            }else {
                this.controller.decommissionFigure(figure);
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Decommission Figure";
    }
}
