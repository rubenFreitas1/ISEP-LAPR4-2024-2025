package eapli.base.app.backoffice.presentation.customerManagement;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.showRequestManagement.domain.GenericSelector;
import eapli.framework.visitor.Visitor;

public class CustomerPrinter implements Visitor<Customer>, GenericSelector.ItemPrinter<Customer> {
    @Override
    public void visit(Customer visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.customerName(), visitee.status() , visitee.customerPhoneNumber(), visitee.customerEmail());
    }

    @Override
    public String print(Customer customer) {
        return String.format("%-30s%-30s%-30s%-30s", customer.customerName(), customer.status(),
                customer.customerPhoneNumber(), customer.customerEmail());
    }
}
