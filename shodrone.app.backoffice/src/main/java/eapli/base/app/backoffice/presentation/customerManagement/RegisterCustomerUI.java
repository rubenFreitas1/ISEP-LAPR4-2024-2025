package eapli.base.app.backoffice.presentation.customerManagement;

import eapli.base.customerManagement.application.RegisterCustomerController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RegisterCustomerUI extends AbstractUI {

    private final RegisterCustomerController theController = new RegisterCustomerController();

    @Override
    protected boolean doShow() {
        final String customerName = Console.readLine("Customer Name");
        final String customerAddress = Console.readLine("Customer Address");
        final String customerEmail = Console.readLine("Customer Email");
        final String password = Console.readLine("Password");
        final String customerPhoneNumber = Console.readLine("Customer Phone Number");
        final String customerVatNumber = Console.readLine("Customer VAT Number");

        try {
            this.theController.registerCustomer(customerName, customerAddress, customerEmail, password, customerPhoneNumber, customerVatNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }

    @Override
    public String headline() {return "Register Customer";}

}
