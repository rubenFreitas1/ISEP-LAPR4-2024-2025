package eapli.base.app.testing.presentation.menu;

import eapli.base.Application;
import eapli.base.app.testing.presentation.UI.ShowTestingAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class MainMenuTestingApp extends AbstractUI {

    private String username;

    private static final String SEPARATOR_LABEL = "--------------";
    private static final String RETURN_LABEL = "Return ";
    private static final int TESTING_OPTION = 1;
    private static final int EXIT_OPTION = 0;
    private static final int TEST_SHOW_PROPOSAL = 1;

    public MainMenuTestingApp(String username){
        this.username = username;
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
        return "Testing App User" + "  ["+ username + " ]  ";
    }


    private Menu buildMainMenu() {
        final var mainMenu = new Menu();

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        final var showsMenu = buildTestingMenu();
        mainMenu.addSubMenu(TESTING_OPTION, showsMenu);
        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildTestingMenu() {
        final var menu = new Menu("Simulator >");
        menu.addItem(TEST_SHOW_PROPOSAL, "Test Show Proposal", new ShowTestingAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
}
