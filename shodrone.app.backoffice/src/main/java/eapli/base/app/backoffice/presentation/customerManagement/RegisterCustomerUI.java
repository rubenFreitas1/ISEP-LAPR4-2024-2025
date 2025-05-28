package eapli.base.app.backoffice.presentation.customerManagement;

import eapli.base.customerManagement.application.RegisterCustomerController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RegisterCustomerUI extends AbstractUI {

    private final RegisterCustomerController theController = new RegisterCustomerController();

    @Override
    protected boolean doShow() {
        final String customerFirstName = Console.readLine("Customer First Name");
        final String customerLastName = Console.readLine("Customer Last Name");
        final String customerAddress = Console.readLine("Customer Address");
        final String customerEmail = Console.readLine("Customer Email");
        final String password = Console.readLine("Password");
        final String customerPhoneNumber = Console.readLine("Customer Phone Number");
        final String customerVatNumber = Console.readLine("Customer VAT Number");
        final String representativeFirstName = Console.readLine("Representative First Name");
        final String representativeLastName = Console.readLine("Representative Last Name");
        final String representativeEmail = Console.readLine("Representative Email");
        final String representativePassword = Console.readLine("Representative Password");
        final String representativePhoneNumber = Console.readLine("Representative Phone Number");
        final String representativePosition = Console.readLine("Representative Position");


        try {
            this.theController.registerCustomer(customerFirstName,customerLastName, customerAddress, customerEmail, password, customerPhoneNumber, customerVatNumber,
                    representativeFirstName,representativeLastName, representativeEmail, representativePassword, representativePhoneNumber, representativePosition);
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
        return true;
    }

    @Override
    public String headline() {return "Register Customer";}

}
