package eapli.base.showRequestManagement.application;


import eapli.base.customerManagement.application.CustomerManagementService;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.showRequestManagement.domain.ShowRequest;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ListShowRequestsController {

    private final CustomerRepository customerRepository = PersistenceContext.repositories().customers();
    private final CustomerManagementService customerManagementService = new CustomerManagementService(customerRepository);

    private final ShowRequestRepository showRequestRepository = PersistenceContext.repositories().showRequests();

    private final ShowRequestManagementService showRequestManagementService = new ShowRequestManagementService(showRequestRepository);

    public Iterable<Customer> listCustomers() {
        return customerManagementService.findAllActiveCustomers();
    }

    public Iterable<ShowRequest> findByCustomer(Customer customer) {
        return showRequestManagementService.findByCustomer(customer);
    }

}
