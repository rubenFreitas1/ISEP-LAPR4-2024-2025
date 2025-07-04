/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.AbstractUserBootstrapper;
import eapli.base.usermanagement.domain.Roles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends AbstractUserBootstrapper implements Action {

    @SuppressWarnings("squid:S2068")
    private static final String PASSWORD1 = "Password1";

    @Override
    public boolean execute() {
        registerShowDesigner("showDesigner1", PASSWORD1, "Johny", "Legend", "showdesigner.legend@showdrone.com");
        registerCRM_Manager("crmManager1", PASSWORD1, "Oven", "Legend", "crmmanager.legend@showdrone.com");
        registerCRM_Collaborator("crmCollaborator1", PASSWORD1, "Master", "Legend", "crmcollaborator.legend@showdrone.com");
        registerDroneTech("droneTech1", PASSWORD1, "Rob", "Legend", "dronetech.legend@showdrone.com");
        return true;
    }

    private void registerShowDesigner(final String username, final String password,
                                      final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Roles.SHOW_DESIGNER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerDroneTech(final String username, final String password,
                                   final String firstName, final String lastName, final String email){
        final Set<Role> roles = new HashSet<>();
        roles.add(Roles.DRONE_TECH);
        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCRM_Manager(final String username, final String password,
                                     final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Roles.CRM_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCRM_Collaborator(final String username, final String password,
                                          final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Roles.CRM_COLLABORATOR);

        registerUser(username, password, firstName, lastName, email, roles);
    }
}
