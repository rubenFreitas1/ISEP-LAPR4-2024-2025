package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.representativeManagement.application.DisableRepresentativeController;
import eapli.base.representativeManagement.domain.Representative;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class DisableRepresentativeUI extends AbstractUI {
    private final DisableRepresentativeController controller = new DisableRepresentativeController();
    @Override
    protected boolean doShow() {
        while (true) {
            final SelectWidget<Customer> selectWidgetCustomer = new SelectWidget<>("Customers (Enter 0 to exit)", this.controller.listCustomers(), new CustomerPrinter());
            selectWidgetCustomer.show();
            Customer customer = selectWidgetCustomer.selectedElement();
            if (customer == null) {
                System.out.println("Exit selected. Returning to main menu.");
                break;
            }

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
                final SelectWidget<Representative> selectWidgetRepresentative = new SelectWidget<>("Customer Representatives (Enter 0 to exit)", listOfCustomerRepresentatives, new RepresentativePrinter());
                selectWidgetRepresentative.show();
                Representative representative = selectWidgetRepresentative.selectedElement();
                if (representative == null) {
                    System.out.println("Exit selected. Returning to previous menu.");
                    break;
                }
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
