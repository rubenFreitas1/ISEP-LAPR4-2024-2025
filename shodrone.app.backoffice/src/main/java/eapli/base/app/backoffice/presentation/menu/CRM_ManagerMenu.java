package eapli.base.app.backoffice.presentation.menu;

import eapli.base.app.backoffice.presentation.figureManagement.DecommissionFigureAction;
import eapli.base.app.backoffice.presentation.showProposalManagement.ConfigureTemplateAction;
import eapli.base.app.backoffice.presentation.showRequestManagement.ListShowRequestsAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class CRM_ManagerMenu {

    private static final int EXIT_OPTION = 0;

    private static final String RETURN_LABEL = "Return ";

    private static final int DECOMMISSION_FIGURE_OPTION = 1;

    private static final int LIST_SHOW_REQUESTS_OPTION = 2;

    private static final int CONFIGURE_TEMPLATE_OPTION = 3;


    public Menu buildCRM_ManagerMenu() {
        final Menu menu = new Menu("Features >");
        menu.addItem(DECOMMISSION_FIGURE_OPTION, "Decommission Figure", new DecommissionFigureAction());
        menu.addItem(LIST_SHOW_REQUESTS_OPTION, "List Show Requests", new ListShowRequestsAction());
        menu.addItem(CONFIGURE_TEMPLATE_OPTION, "Configure Template", new ConfigureTemplateAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
