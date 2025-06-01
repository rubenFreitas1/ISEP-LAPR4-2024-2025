package eapli.base.app.customer.presentation.menu;

import eapli.base.Application;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;



public class MainMenuCustomer extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;
    private String customerEmail;


    // MAIN MENU

    private static final int SHOWS_OPTION = 1;


    // SHOWS MENU

    private static final int ANALYSE_PROPOSAL_OPTION = 1;

    private static final int ACCEPT_OR_REJECT_SHOW_PROPOSAL_OPTION = 2;

    private static final int LIST_SHOWS_OPTION = 3;

    private static final int GET_SHOW_INFO_OPTION = 4;


    private static final String SEPARATOR_LABEL = "--------------";

    public MainMenuCustomer(String email){
        this.customerEmail = email;
    }

    public String customerEmail(){
        return  this.customerEmail;
    }



    @Override
    protected boolean doShow() {
        final var menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {
        return "Customer" + "  ["+ customerEmail + " ]  ";
    }


    private Menu buildMainMenu() {
        final var mainMenu = new Menu();

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        final var showsMenu = buildShowsMenu();
        mainMenu.addSubMenu(SHOWS_OPTION, showsMenu);
        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }



    private Menu buildShowsMenu() {
        final var menu = new Menu("Shows >");
        //menu.addItem(ANALYSE_PROPOSAL_OPTION, "Analyse Proposal", );
        //menu.addItem(ACCEPT_OR_REJECT_SHOW_PROPOSAL_OPTION, "Answer to Show Proposals", );
        //menu.addItem(LIST_SHOWS_OPTION, "List Shows", );
        //menu.addItem(GET_SHOW_INFO_OPTION, "Get Show Info", );
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

}
