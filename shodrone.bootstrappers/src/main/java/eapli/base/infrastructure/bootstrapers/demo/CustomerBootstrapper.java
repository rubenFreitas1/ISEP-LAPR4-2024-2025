package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customerManagement.application.RegisterCustomerController;
import eapli.base.customerManagement.domain.Customer;
import eapli.base.representativeManagement.application.RegisterRepresentativeController;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            CustomerBootstrapper.class);

    private final RegisterCustomerController registerCustomerController = new RegisterCustomerController();
    private final RegisterRepresentativeController registerRepresentativeController = new RegisterRepresentativeController();
    @Override
    public boolean execute() {
        addCustomer("Pedro", "Rua da Calheta", "pedro@gmail.com", "12345","939864301","948503204",
                "Pedro Jr", "pedro@gmail", "12345", "940371294", "Chefe");
        addCustomer("João Freitas", "Ponta do Sol", "joao.boss@gmail.com", "12345","939983230","948432982",
                "Martim Ferreira", "martim.ferreira@gmail", "12345", "949339281", "Empregado");
        addCustomer("Joana Correia", "Rua da Avenida, Funchal", "joana.correiaboss@gmail.com", "12345","928571922","109532894",
                "Ana Maria", "ana.maria@gmail", "12345", "919385255", "Empregada");
        return true;
    }

    private Customer addCustomer(final String name, final String address, final String email, final String password, final String phoneNumber,
            final String vatNumber, final String username, final String email2, final String password2, final String phoneNumber2,
            final String role) {
        Customer customer = null;
        try {
            customer = registerCustomerController.registerCustomer(name, address, email, password, phoneNumber, vatNumber,
                    username, email2, password2, phoneNumber2, role);
        } catch (final Exception e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", name);
            LOGGER.trace("Assuming existing record", e);
        }
        return customer;

    }
}
