package eapli.base.showRequestManagement.application;

import eapli.base.showRequestManagement.repositories.ShowRequestRepository;

public class ShowRequestManagementService {
    private final ShowRequestRepository showRequestRepository;

    public ShowRequestManagementService(final ShowRequestRepository showRequestRepository) {
        this.showRequestRepository = showRequestRepository;
    }
}
