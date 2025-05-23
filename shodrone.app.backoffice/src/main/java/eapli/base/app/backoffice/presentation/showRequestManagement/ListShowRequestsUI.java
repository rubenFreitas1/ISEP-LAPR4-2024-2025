package eapli.base.app.backoffice.presentation.showRequestManagement;

import eapli.base.app.backoffice.presentation.customerManagement.CustomerPrinter;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.showRequestManagement.application.ListShowRequestsController;

import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;


public class ListShowRequestsUI extends AbstractUI {

    private final ListShowRequestsController controller = new ListShowRequestsController();

    @Override
    protected boolean doShow() {
        Iterable<Customer> customers = this.controller.listCustomers();
        if (!customers.iterator().hasNext()) {
            System.out.println("There are no registered Customers in the system!");
            return false;
        } else {
            String headerModel = String.format("Select Customer\n#  %-30s%-30s%-30s%-30s", "NAME", "STATUS", "PHONE NUMBER", "EMAIL");
            final SelectWidget<Customer> selector = new SelectWidget<>(headerModel, customers, new CustomerPrinter());
            selector.show();
            final Customer customer = selector.selectedElement();
            if (customer == null) {
                System.out.println("No customer selected!");
                return false;
            }else{
                final Iterable<ShowRequest> showRequests = this.controller.findByCustomer(customer);
                if(!showRequests.iterator().hasNext()) {
                    System.out.println("There are no registered Show Requests in the system for this Customer!");
                } else {
                    String headerShowRequest = String.format("List of Show Requests\n#  %-80s%-30s%-30s%-30s%-30s", "LOCATION", "DATE", "NUMBER OF DRONES", "DURATION", "CUSTOMER");
                    final ListWidget<ShowRequest> listWidget = new ListWidget<>(headerShowRequest, showRequests, new ShowRequestPrinter());
                    listWidget.show();
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "List Show Requests";
    }
}
