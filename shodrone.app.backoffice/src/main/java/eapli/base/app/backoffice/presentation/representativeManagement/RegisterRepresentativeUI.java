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
                if (!firstName.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("Representative First Name must contain only letters.");

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
                if (!lastName.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("Representative Last Name must contain only letters.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                email = Console.readLine("Representative Email: ");

                if (email.trim().isEmpty()) {
                    throw new IllegalArgumentException("Email cannot be empty.");
                }
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) throw new IllegalArgumentException("Invalid email format.");


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
                if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, and one digit.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                phone = Console.readLine("Representative Phone Number: ");
                if (phone.isEmpty() || phone == null) throw new IllegalArgumentException("Phone number cannot be empty.");
                if (phone.length() !=9) throw new IllegalArgumentException("Phone number must be 9 digits long.");
                if (theController.isPhoneNumberUsed(phone)) {
                    throw new IllegalArgumentException("Phone number is being already used.");
                }
                if (theController.isCustomerPhoneNumberUsed(phone)) {
                    throw new IllegalArgumentException("Phone number is being already used.");
                }
                if (!phone.matches("\\d+")) throw new IllegalArgumentException("Phone Number must be numeric.");


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
