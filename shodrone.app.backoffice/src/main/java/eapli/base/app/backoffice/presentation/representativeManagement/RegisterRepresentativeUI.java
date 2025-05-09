package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.representativeManagement.application.RegisterRepresentativeController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RegisterRepresentativeUI extends AbstractUI {

    private final RegisterRepresentativeController theController = new RegisterRepresentativeController();

    private Customer selectedCustomer;

    @Override
    public boolean doShow() {

        if (selectedCustomer == null) {
            selectCustomer();
        }

        final String representativeName = Console.readLine("Representative Name: ");
        final String representativeEmail = Console.readLine("Representative Email: ");
        final String representativePassword = Console.readLine("Representative Password: ");
        final String representativePhone = Console.readLine("Representative Phone Number: ");
        final String representativePosition = Console.readLine("Representative Position: ");
        try{
            this.theController.registerRepresentative(representativeName, representativeEmail, representativePassword, representativePhone, selectedCustomer, representativePosition);
        } catch (IllegalArgumentException e){
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Register Representative";
    }

    private void selectCustomer() {
        System.out.println("Select a Customer:");
        Iterable<Customer> customers = theController.allCustomers();
        int index = 1;
        for (Customer customer : customers) {
            System.out.printf("%d - %s%n", index++, customer.customerName());
        }

        int choice = Console.readInteger("Select a customer: ");
        index = 1;
        for (Customer customer : customers) {
            if (index == choice) {
                selectedCustomer = customer;
                break;
            }
            index++;
        }
    }
}
