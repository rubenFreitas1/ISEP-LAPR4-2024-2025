package eapli.base.app.backoffice.presentation.representativeManagement;

import eapli.base.representativeManagement.domain.Representative;
import eapli.framework.visitor.Visitor;

public class RepresentativePrinter implements Visitor<Representative> {
    @Override
    public void visit(Representative visitee) {
        System.out.printf("%-30s%-30s%-30s%-30s", visitee.representativeName(), visitee.representativeEmail(), visitee.isActive() ? "Active" : "Inactive", visitee.createdBy().name());
    }
}
