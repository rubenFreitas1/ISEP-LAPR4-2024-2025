package rcomp.server;

import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.usermanagement.domain.Roles;

public class LoginService {

    private AuthenticationCredentialHandler credentialHandler = new AuthenticationCredentialHandler();

    public boolean validateLogin(String email, String password){
        return credentialHandler.authenticated(email, password, Roles.CUSTOMER_REPRESENTATIVE) | credentialHandler.authenticated(email, password, Roles.CUSTOMER);
    }
}
