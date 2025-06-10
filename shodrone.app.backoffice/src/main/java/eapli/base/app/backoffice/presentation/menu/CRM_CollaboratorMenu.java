package eapli.base.app.backoffice.presentation.menu;

import eapli.base.app.backoffice.presentation.customerManagement.RegisterCustomerAction;
import eapli.base.app.backoffice.presentation.figureCategoryManagement.ListFigureCategoriesAction;
import eapli.base.app.backoffice.presentation.figureManagement.ListFigureAction;
import eapli.base.app.backoffice.presentation.figureManagement.SearchFigureAction;
import eapli.base.app.backoffice.presentation.representativeManagement.DisableRepresentativeAction;
import eapli.base.app.backoffice.presentation.representativeManagement.EditRepresentativeAction;
import eapli.base.app.backoffice.presentation.representativeManagement.ListRepresentativesAction;
import eapli.base.app.backoffice.presentation.representativeManagement.RegisterRepresentativeAction;
import eapli.base.app.backoffice.presentation.showProposalManagement.*;
import eapli.base.app.backoffice.presentation.showRequestManagement.EditShowRequestAction;
import eapli.base.app.backoffice.presentation.showRequestManagement.ListShowRequestsAction;
import eapli.base.app.backoffice.presentation.showRequestManagement.RegisterShowRequestAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class CRM_CollaboratorMenu {

    private static final int EXIT_OPTION = 0;

    private static final String RETURN_LABEL = "Return ";


    // CUSTOMER MENU
    private static final int REGISTER_CUSTOMER_OPTION = 1;
    private static final int REGISTER_CUSTOMER_REPRESENTATIVE_OPTION = 2;
    private static final int LIST_CUSTOMER_REPRESENTATIVES_OPTION = 3;
    private static final int EDIT_CUSTOMER_REPRESENTATIVE_OPTION = 4;
    private static final int DISABLE_CUSTOMER_REPRESENTATIVE_OPTION = 5;


    // SHOW REQUEST MENU

    private static final int REGISTER_SHOW_REQUEST_OPTION = 1;

    private static final int LIST_SHOW_REQUESTS_OPTION = 2;

    private static final int EDIT_SHOW_REQUEST_OPTION = 3;

    // SHOW PROPOSAL MENU

    private static final int REGISTER_SHOW_PROPOSAL_OPTION = 1;

    private static final int ADD_DRONE_MODELS_PROPOSAL = 2;

    private static final int ADD_FIGURES_TO_PROPOSAL = 3;

    private static final int ADD_VIDEO_SIMULATION_PROPOSAL = 4;

    private static final int MARK_SHOW_PROPOSAL_OPTION = 5;

    private static final int SEND_SHOW_PROPOSAL = 6;

    // FIGURE MENU

    private static final int LIST_PUBLIC_FIGURE_OPTION = 1;

    private static final int SEARCH_FIGURE_CATALOGUE_OPTION = 2;

    private static final int LIST_FIGURE_CATEGORIES_OPTION = 3;



    public Menu buildCustomerMenu() {
        final Menu menu = new Menu("Customer >");
        menu.addItem(REGISTER_CUSTOMER_OPTION, "Register Customer", new RegisterCustomerAction());
        menu.addItem(REGISTER_CUSTOMER_REPRESENTATIVE_OPTION, "Register Customer Representative", new RegisterRepresentativeAction());
        menu.addItem(LIST_CUSTOMER_REPRESENTATIVES_OPTION, "List Customer Representatives", new ListRepresentativesAction());
        menu.addItem(EDIT_CUSTOMER_REPRESENTATIVE_OPTION, "Edit Customer Representative",new EditRepresentativeAction());
        menu.addItem(DISABLE_CUSTOMER_REPRESENTATIVE_OPTION, "Disable Customer Representative", new DisableRepresentativeAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    public Menu buildShowRequestMenu() {
        final Menu menu = new Menu("Show Request >");
        menu.addItem(REGISTER_SHOW_REQUEST_OPTION, "Register Show Request", new RegisterShowRequestAction());
        menu.addItem(LIST_SHOW_REQUESTS_OPTION, "List Show Requests", new ListShowRequestsAction());
        menu.addItem(EDIT_SHOW_REQUEST_OPTION, "Edit Show Request", new EditShowRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    public Menu buildShowProposalMenu() {
        final Menu menu = new Menu("Show Proposal >");
        menu.addItem(REGISTER_SHOW_PROPOSAL_OPTION, "Register Show Proposal", new RegisterShowProposalAction());
        menu.addItem(ADD_DRONE_MODELS_PROPOSAL, "Add Drone Models to Proposal", new AddDronesToProposalAction());
        menu.addItem(ADD_FIGURES_TO_PROPOSAL, "Add Figures to Proposal", new AddFiguresToProposalAction());
        menu.addItem(ADD_VIDEO_SIMULATION_PROPOSAL, "Add Video Simulation to Proposal", new AddVideoProposalAction());
        menu.addItem(MARK_SHOW_PROPOSAL_OPTION, "Mark Show Proposal", new MarkShowProposalAction());
        menu.addItem(SEND_SHOW_PROPOSAL, "Send Show Proposal", new SendShowProposalAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    public Menu buildFigureMenu() {
        final Menu menu = new Menu("Figure >");
        menu.addItem(LIST_PUBLIC_FIGURE_OPTION, "List all Public Figures", new ListFigureAction());
        menu.addItem(SEARCH_FIGURE_CATALOGUE_OPTION, "Search Figure Catalogue", new SearchFigureAction());
        menu.addItem(LIST_FIGURE_CATEGORIES_OPTION, "List Figure Categories", new ListFigureCategoriesAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }


}
