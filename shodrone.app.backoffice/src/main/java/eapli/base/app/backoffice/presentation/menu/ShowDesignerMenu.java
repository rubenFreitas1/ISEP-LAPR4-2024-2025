package eapli.base.app.backoffice.presentation.menu;

import eapli.base.app.backoffice.presentation.figureCategoryManagement.AddFigureCategoryAction;
import eapli.base.app.backoffice.presentation.figureCategoryManagement.ChangeFigureCategoryStatusAction;
import eapli.base.app.backoffice.presentation.figureCategoryManagement.EditFigureCategoryAction;
import eapli.base.app.backoffice.presentation.figureCategoryManagement.ListFigureCategoriesAction;
import eapli.base.app.backoffice.presentation.figureManagement.AddFigureAction;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class ShowDesignerMenu {

    private static final int EXIT_OPTION = 0;

    private static final String RETURN_LABEL = "Return ";


    private static final int ADD_FIGURE_OPTION = 1;
    private static final int ADD_FIGURE_CATEGORY_OPTION = 2;
    private static final int EDIT_FIGURE_CATEGORY_OPTION = 3;
    private static final int LIST_FIGURE_CATEGORIES_OPTION = 4;
    private static final int CHANGE_FIGURE_CATEGORY_STATUS_OPTION = 5;

    public Menu buildFigureMenu() {
        final Menu menu = new Menu("Figure >");
        menu.addItem(ADD_FIGURE_OPTION, "Add Figure", new AddFigureAction());
        menu.addItem(ADD_FIGURE_CATEGORY_OPTION, "Add Figure Category", new AddFigureCategoryAction());
        menu.addItem(EDIT_FIGURE_CATEGORY_OPTION, "Edit Figure Category", new EditFigureCategoryAction());
        menu.addItem(LIST_FIGURE_CATEGORIES_OPTION, "List Figure Categories", new ListFigureCategoriesAction());
        menu.addItem(CHANGE_FIGURE_CATEGORY_STATUS_OPTION, "Change Status Figure Category", new ChangeFigureCategoryStatusAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
