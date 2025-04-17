/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.presentation.menu;

import eapli.base.Application;
import eapli.base.app.backoffice.presentation.authz.ActiveUserAction;
import eapli.base.app.backoffice.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.presentation.authz.ListUsersAction;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

	private static final String RETURN_LABEL = "Return ";

	private static final int EXIT_OPTION = 0;

	// USERS
	private static final int ADD_USER_OPTION = 1;
	private static final int LIST_USERS_OPTION = 2;
	private static final int DEACTIVATE_USER_OPTION = 3;

	private static final int ACTIVATE_USER_OPTION = 4;


	// MAIN MENU
	private static final int MY_USER_OPTION = 1;
	private static final int USERS_OPTION = 2;

	private static final String SEPARATOR_LABEL = "--------------";


	// CRM COLLABORATOR MENU
	private static final int CUSTOMER_OPTION = 2;

	private static final int SHOW_REQUEST_OPTION = 3;

	private static final int FIGURE_OPTION = 4;

	// CRM MANAGER MENU
	private static final int CRM_MANAGER_OPTION = 2;


	// DRONE TECH MENU
	private static final int DRONE_MENU_OPTION = 2;

	// SHOW DESIGNER MENU
	private static final int FIGURE_MENU_OPTION = 2;


	private final AuthorizationService authz = AuthzRegistry.authorizationService();

	@Override
	public boolean show() {
		drawFormTitle();
		return doShow();
	}

	/**
	 * @return true if the user selected the exit option
	 */
	@Override
	public boolean doShow() {
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

		return authz.session().map(s -> "Backoffice [ @" + s.authenticatedUser().identity() + " ]")
				.orElse("Backoffice [ ==Anonymous== ]");
	}

	private Menu buildMainMenu() {
		final var mainMenu = new Menu();

		final Menu myUserMenu = new MyUserMenu();
		mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

		if (!Application.settings().isMenuLayoutHorizontal()) {
			mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
		}

		if (authz.isAuthenticatedUserAuthorizedTo(Roles.POWER_USER, Roles.ADMIN)) {
			final var usersMenu = buildUsersMenu();
			mainMenu.addSubMenu(USERS_OPTION, usersMenu);
		}

		if(authz.isAuthenticatedUserAuthorizedTo(Roles.CRM_COLLABORATOR)){
			final Menu customerMenu = new CRM_CollaboratorMenu().buildCustomerMenu();
			mainMenu.addSubMenu(CUSTOMER_OPTION, customerMenu);
			final Menu showRequestMenu = new CRM_CollaboratorMenu().buildShowRequestMenu();
			mainMenu.addSubMenu(SHOW_REQUEST_OPTION, showRequestMenu);
			final Menu showFigureMenu = new CRM_CollaboratorMenu().buildFigureMenu();
			mainMenu.addSubMenu(FIGURE_OPTION, showFigureMenu);
		}

		if(authz.isAuthenticatedUserAuthorizedTo(Roles.CRM_MANAGER)){
			final Menu crmManagerMenu = new CRM_ManagerMenu().buildCRM_ManagerMenu();
			mainMenu.addSubMenu(CRM_MANAGER_OPTION, crmManagerMenu);
		}

		if(authz.isAuthenticatedUserAuthorizedTo(Roles.DRONE_TECH)){
			final Menu droneMenu = new DroneTechMenu().buildDroneMenu();
			mainMenu.addSubMenu( DRONE_MENU_OPTION ,droneMenu);
		}

		if(authz.isAuthenticatedUserAuthorizedTo(Roles.SHOW_DESIGNER)){
			final Menu figureMenu = new ShowDesignerMenu().buildFigureMenu();
			mainMenu.addSubMenu( FIGURE_MENU_OPTION,figureMenu);

		}


		if (!Application.settings().isMenuLayoutHorizontal()) {
			mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
		}

		mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

		return mainMenu;
	}



	private Menu buildUsersMenu() {
		final var menu = new Menu("Users >");

		menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
		menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
		menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
		menu.addItem(ACTIVATE_USER_OPTION, "Activate User", new ActiveUserAction());
		menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
		return menu;
	}

}
