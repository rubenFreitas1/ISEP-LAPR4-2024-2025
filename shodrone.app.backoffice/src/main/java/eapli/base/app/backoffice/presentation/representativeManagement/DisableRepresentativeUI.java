package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.representativeManagement.application.DisableRepresentativeController;
import eapli.base.representativeManagement.domain.Representative;
import eapli.base.showRequestManagement.domain.GenericSelector;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class DisableRepresentativeUI extends AbstractUI {
    private final DisableRepresentativeController controller = new DisableRepresentativeController();
    @Override
    protected boolean doShow() {
        while (true) {
            final SelectWidget<Customer> selectWidgetFigure = new SelectWidget<>("Available figures (Enter 0 to finish)", this.controller.listCustomers(), new CustomerPrinter());
            selectWidgetFigure.show();
            Customer customer = selectWidgetFigure.selectedElement();
            Iterable<Representative> listOfCustomerRepresentatives = this.controller.listCustomerRepresentatives(customer);
            if (!listOfCustomerRepresentatives.iterator().hasNext()) {
                System.out.println("This customer doesnt have any representative.");
                break;
            }
            while (true) {
                boolean verification = verifyCustomerRepresentativesAllDeactivated(listOfCustomerRepresentatives);
                if (verification) {
                    break;
                }
                Representative representative = GenericSelector.selectItem(listOfCustomerRepresentatives, new RepresentativePrinter(), "Select a Customer Representative");
                if (!representative.isActive()) {
                    System.out.println("The Selected Customer Representative is already deactivated.");
                } else {
                    this.controller.deactivateCustomerRepresentative(representative);
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "";
    }

    private boolean verifyCustomerRepresentativesAllDeactivated(Iterable<Representative> representatives) {
        int cont = 0;
        for (Representative representative : representatives) {
            if (representative.isActive()) {
                cont++;
                break;
            }
        }
        if (cont == 0) {
            System.out.println("The Customer Representatives are all deactivated.");
            return true;
        }
        return false;
    }
}
