package eapli.base.app.backoffice.presentation.customerManagement;

import eapli.base.customerManagement.dto.CustomerDTO;
import eapli.framework.visitor.Visitor;

public class CustomerDTOPrinter implements Visitor<CustomerDTO> {
    @Override
    public void visit(CustomerDTO visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.getCustomerName(), visitee.getStatus() , visitee.getCustomerPhoneNumber(), visitee.getCustomerEmail());
    }
}
