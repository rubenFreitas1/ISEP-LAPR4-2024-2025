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
        String firstName = null, lastName = null,email = null,password = null,phone = null,position = null;

        while (true) {
            try {
                firstName = Console.readLine("Representative First Name: ");
                if (firstName.trim().isEmpty()) {
                    throw new IllegalArgumentException("First Name cannot be empty.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                lastName = Console.readLine("Representative Last Name: ");
                if (lastName.trim().isEmpty()) {
                    throw new IllegalArgumentException("Last Name cannot be empty.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                email = Console.readLine("Representative Email: ");
                if (theController.isEmailUsed(email)) {
                    throw new IllegalArgumentException("Email is already used by another representative.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                password = Console.readLine("Representative Password: ");
                if (password.length() < 6) {
                    throw new IllegalArgumentException("Password must be at least 6 characters long.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                phone = Console.readLine("Representative Phone Number: ");
                if (theController.isPhoneNumberUsed(phone)) {
                    throw new IllegalArgumentException("Phone number is already used by another representative.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                position = Console.readLine("Representative Position: ");
                if (position.trim().isEmpty()) {
                    throw new IllegalArgumentException("Position cannot be empty.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        try{
            this.theController.registerRepresentative(firstName, lastName, email, password, phone, selectedCustomer, position);
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
