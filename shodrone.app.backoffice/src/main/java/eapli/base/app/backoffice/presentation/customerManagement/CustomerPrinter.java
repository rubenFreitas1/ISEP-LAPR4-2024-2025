package eapli.base.app.backoffice.presentation.customerManagement;

import eapli.base.customerManagement.domain.Customer;
import eapli.framework.visitor.Visitor;

public class CustomerPrinter implements Visitor<Customer> {
    @Override
    public void visit(Customer visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.customerName(), visitee.status() , visitee.customerPhoneNumber(), visitee.customerEmail());
    }
}
