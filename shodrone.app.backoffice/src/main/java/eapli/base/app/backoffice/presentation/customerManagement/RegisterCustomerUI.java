package eapli.base.app.backoffice.presentation.customerManagement;

import eapli.base.customerManagement.application.RegisterCustomerController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.strings.util.StringPredicates;

public class RegisterCustomerUI extends AbstractUI {

    private final RegisterCustomerController theController = new RegisterCustomerController();

    protected boolean doShow() {
        String customerFirstName, customerLastName, customerAddress, customerEmail, password, customerPhoneNumber, customerVatNumber;
        String representativeFirstName, representativeLastName, representativeEmail, representativePassword, representativePhoneNumber, representativePosition;

        while (true) {
            try {
                customerFirstName = Console.readLine("Customer First Name: ");
                if (customerFirstName.trim().isEmpty()) throw new IllegalArgumentException("Customer First Name cannot be empty.");
                if (!customerFirstName.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("Customer First Name must contain only letters.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                customerLastName = Console.readLine("Customer Last Name: ");
                if (customerLastName.trim().isEmpty()) throw new IllegalArgumentException("Customer Last Name cannot be empty.");
                if (!customerLastName.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("Customer Last Name must contain only letters.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                customerAddress = Console.readLine("Customer Address: ");
                if (customerAddress.trim().isEmpty()) throw new IllegalArgumentException("Customer Address cannot be empty.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                customerEmail = Console.readLine("Customer Email: ");
                if (customerEmail.trim().isEmpty()) throw new IllegalArgumentException("Customer Email cannot be empty.");
                if (!customerEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) throw new IllegalArgumentException("Invalid email format.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                password = Console.readLine("Password: ");
                if (password.length() < 6) throw new IllegalArgumentException("Password must be at least 6 characters long.");
                if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, and one digit.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                customerPhoneNumber = Console.readLine("Customer Phone Number: ");
                if (customerPhoneNumber.isEmpty() || customerPhoneNumber == null) throw new IllegalArgumentException("Phone number cannot be empty.");
                if (customerPhoneNumber.length() !=9) throw new IllegalArgumentException("Phone number must be 9 digits long.");
                if (!customerPhoneNumber.matches("\\d+")) throw new IllegalArgumentException("Phone Number must be numeric.");
                if (theController.isCustomerPhoneNumberUsed(customerPhoneNumber)) throw new IllegalArgumentException("Phone number is already being used.");
                if (theController.isRepresentativePhoneNumberUsed(customerPhoneNumber)) throw new IllegalArgumentException("Phone number is already being used.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                customerVatNumber = Console.readLine("Customer VAT Number: ");
                if (customerVatNumber.trim().isEmpty()) throw new IllegalArgumentException("VAT Number cannot be empty.");
                if (!customerVatNumber.matches("\\d+")) throw new IllegalArgumentException("VAT Number must be numeric.");
                if (theController.isCustomerVatNumberUsed(customerVatNumber)) throw new IllegalArgumentException("VAT Number is already used.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


        while (true) {
            try {
                representativeFirstName = Console.readLine("Representative First Name: ");
                if (representativeFirstName.trim().isEmpty()) throw new IllegalArgumentException("First Name cannot be empty.");
                if (!representativeFirstName.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("Representative First Name must contain only letters.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                representativeLastName = Console.readLine("Representative Last Name: ");
                if (representativeLastName.trim().isEmpty()) throw new IllegalArgumentException("Last Name cannot be empty.");
                if (!representativeLastName.matches("^[a-zA-Z]+$")) throw new IllegalArgumentException("Representative Last Name must contain only letters.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                representativeEmail = Console.readLine("Representative Email: ");
                if (representativeEmail.trim().isEmpty()) throw new IllegalArgumentException("Email cannot be empty.");

                if (!representativeEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) throw new IllegalArgumentException("Invalid email format.");

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                representativePassword = Console.readLine("Representative Password: ");
                if (representativePassword.length() < 6) throw new IllegalArgumentException("Password must be at least 6 characters long.");
                if (!representativePassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")) throw new IllegalArgumentException("Password must contain at least one uppercase letter, one lowercase letter, and one digit.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                representativePhoneNumber = Console.readLine("Representative Phone Number: ");
                if (representativePhoneNumber.isEmpty() || representativePhoneNumber == null) throw new IllegalArgumentException("Phone number cannot be empty.");
                if (!representativePhoneNumber.matches("\\d+")) throw new IllegalArgumentException("Phone Number must be numeric.");
                if (theController.isRepresentativePhoneNumberUsed(representativePhoneNumber)) throw new IllegalArgumentException("Phone number is already being used.");
                if (theController.isCustomerPhoneNumberUsed(representativePhoneNumber)) throw new IllegalArgumentException("Phone number is already being used.");
                if (representativePhoneNumber.length() !=9) throw new IllegalArgumentException("Phone number must be 9 digits long.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                representativePosition = Console.readLine("Representative Position: ");
                if (representativePosition.trim().isEmpty()) throw new IllegalArgumentException("Position cannot be empty.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            this.theController.registerCustomer(
                    customerFirstName, customerLastName, customerAddress, customerEmail, password,
                    customerPhoneNumber, customerVatNumber,
                    representativeFirstName, representativeLastName, representativeEmail, representativePassword,
                    representativePhoneNumber, representativePosition
            );
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }

        return true;
    }


    @Override
    public String headline() {return "Register Customer";}

}
