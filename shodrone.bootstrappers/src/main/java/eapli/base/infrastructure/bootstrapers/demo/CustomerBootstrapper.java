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
        addCustomer("Pedro","Paulo", "Rua da Calheta", "pedro@gmail.com", "Password1","939864301","948503204",
                "Pedro","João", "pedro@gmail", "Password2", "940371294", "Chefe");
        addCustomer("João","Freitas", "Ponta do Sol", "joao.boss@gmail.com", "Password1","93998","948432982",
                "Martim ","Ferreira", "martim.ferreira@gmail", "Password2", "949339281", "Empregado");
        addCustomer("Joana","Correia", "Rua da Avenida, Funchal", "joana.correiaboss@gmail.com", "Password1","928571922","109532894",
                "Ana"," Maria", "ana.maria@gmail", "Password1", "919385255", "Empregada");
        return true;
    }

    private Customer addCustomer(final String firstName, final String lastName,  final String address, final String email, final String password, final String phoneNumber,
            final String vatNumber, final String firtsName2,final String lastName2, final String email2, final String password2, final String phoneNumber2,
            final String role) {
        Customer customer = null;
        try {

            customer = registerCustomerController.registerCustomer(firstName,lastName, address, email, password, phoneNumber, vatNumber,
                    firtsName2,lastName2, email2, password2, phoneNumber2, role);
        } catch (final Exception e) {
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", e.getMessage());
            LOGGER.trace("Assuming existing record", e);
        }
        return customer;

    }
}
