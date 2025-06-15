package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.representativeManagement.application.EditRepresentativeController;
import eapli.base.representativeManagement.domain.Representative;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;

import java.util.Scanner;

public class EditRepresentativeUI extends AbstractListUI<Representative> {
    private final EditRepresentativeController theController = new EditRepresentativeController();
    private Customer selectedCustomer;
    @Override
    public String headline() {
        return "Edit Representative";
    }

    @Override
    protected Iterable<Representative> elements() {
        if (selectedCustomer == null) {
            selectCustomer();
        }
        return theController.findByAssociatedCustomerAndActive(selectedCustomer, true);
    }

    @Override
    protected String elementName() {
        return "Representative";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-30s%-30s%-30s%-30s%-30s", "REPRESENTATIVE NAME", "REPRESENTATIVE EMAIL", "REPRESENTATIVE PASSWORD", "REPRESENTATIVE PHONE NUMBER", "REPRESENTATIVE POSITION");
    }

    @Override
    protected String emptyMessage() {
        return "No representatives found.";
    }
    @Override
    protected Visitor<Representative> elementPrinter() {
        return new RepresentativePrinter();
    }


    private void selectCustomer() {
        System.out.println("Select a Customer:");
        Iterable<Customer> customers = theController.allCustomers();
        int index = 1;
        for (Customer customer : customers) {
            System.out.printf("%d - %s%n", index++, customer.customerName());
        }
        System.out.println("\nSelect an option:");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        index = 1;
        for (Customer customer : customers) {
            if (index == choice) {
                selectedCustomer = customer;
                break;
            }
            index++;
        }
    }

    @Override
    protected boolean doShow() {
        final Iterable<Representative> representatives = elements();
        if (!representatives.iterator().hasNext()) {
            System.out.println("There are no registered Representatives in the system");
        } else {
            final SelectWidget<Representative> selector = new SelectWidget<>(listHeader(), representatives, elementPrinter());
            selector.show();
            final Representative representative = selector.selectedElement();
            if (representative == null) {
                System.out.println("No representative selected");
            } else {
                String firstName = null, lastName = null, email = null, password = null, phoneNumber = null, position = null;


                System.out.println("\nEditing Representative:");
                System.out.println("Current values: ");
                System.out.printf("%-30s%-30s%-30s%-30s%-30s\n", representative.representativeName(), representative.representativeEmail(), representative.representativePassword(), representative.representativePhoneNumber(), representative.representativePosition());

                while (true) {
                    try {
                        firstName = Console.readLine("First Name |(If you do not desire to change type N)| : ");
                        if (!firstName.equalsIgnoreCase("n") && firstName.trim().isEmpty()) {
                            throw new IllegalArgumentException("Name cannot be empty.");
                        }
                        if (!firstName.equalsIgnoreCase("n") && !firstName.matches("^[a-zA-Z]+$")) {
                            throw new IllegalArgumentException("First Name must contain only letters.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        lastName = Console.readLine("Last Name |(If you do not desire to change type N)| : ");
                        if (!lastName.equalsIgnoreCase("n") && lastName.trim().isEmpty()) {
                            throw new IllegalArgumentException("Name cannot be empty.");
                        }
                        if (!lastName.equalsIgnoreCase("n") && !lastName.matches("^[a-zA-Z]+$")) {
                            throw new IllegalArgumentException("Last Name must contain only letters.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        email = Console.readLine("Email |(If you do not desire to change type N)| : ");
                        if (email.equalsIgnoreCase("n")) {
                            break;
                        }
                        if (!email.equalsIgnoreCase("n") && email.trim().isEmpty()) {
                            throw new IllegalArgumentException("Email cannot be empty.");

                        }
                        if (!email.equalsIgnoreCase("n") && !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                            throw new IllegalArgumentException("Invalid email format.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        password = Console.readLine("Password |(If you do not desire to change type N)| : ");
                        if (!password.equalsIgnoreCase("n") && password.length() < 6) {
                            throw new IllegalArgumentException("Password must be at least 6 characters long.");
                        }
                        if (!password.equalsIgnoreCase("n") && !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) {
                            throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, and one digit.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        phoneNumber = Console.readLine("Phone Number |(If you do not desire to change type N)| : ");
                        if (!phoneNumber.equalsIgnoreCase("n") && !phoneNumber.trim().isEmpty() ) {
                            throw new IllegalArgumentException("Phone number cannot be empty.");
                        }
                        if (!phoneNumber.equalsIgnoreCase("n") && phoneNumber.length() != 9) {
                            throw new IllegalArgumentException("Phone number must be 9 digits long.");
                        }
                        if (!phoneNumber.equalsIgnoreCase("n") && !phoneNumber.matches("\\d+")) {
                            throw new IllegalArgumentException("Phone number must contain only digits.");
                        }
                        if (!phoneNumber.equalsIgnoreCase("n") && theController.isPhoneNumberUsed(phoneNumber)) {
                            throw new IllegalArgumentException("Phone number is already in use.");
                        }
                        if (!phoneNumber.equalsIgnoreCase("n") && theController.isCustomerPhoneNumberUsed(phoneNumber)) {
                            throw new IllegalArgumentException("Phone number is already in use.");
                        }

                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        position = Console.readLine("Position |(If you do not desire to change type N)| : ");
                        if (!position.equalsIgnoreCase("n") && position.trim().isEmpty()) {
                            throw new IllegalArgumentException("Position cannot be empty.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                try {
                    this.theController.editRepresentative(representative, firstName, lastName, email, password, phoneNumber, position);
                    System.out.println("Representative edited successfully\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Unexpected error while editing representative: " + e.getMessage());
                }
            }
        }
        return true;
    }
}
