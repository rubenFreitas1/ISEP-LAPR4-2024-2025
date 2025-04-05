/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.utentemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.ExemploRoles;
import eapli.base.utentemanagement.domain.MecanographicNumber;
import eapli.base.utentemanagement.domain.Utente;
import eapli.base.utentemanagement.repositories.UtenteRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

/**
 * @author mcn
 */
public class UtenteService {

	private final AuthorizationService authz = AuthzRegistry.authorizationService();
	private final UtenteRepository repo = PersistenceContext.repositories().utentes();

	public Optional<Utente> findExemploUtenteByMecNumber(final String mecNumber) {
		authz.ensureAuthenticatedUserHasAnyOf(ExemploRoles.POWER_USER, ExemploRoles.ADMIN, ExemploRoles.OTHER_EXAMPLE);
		return repo.ofIdentity(MecanographicNumber.valueOf(mecNumber));
	}

	public Optional<Utente> findExemploUtenteByUsername(final Username user) {
		authz.ensureAuthenticatedUserHasAnyOf(ExemploRoles.POWER_USER, ExemploRoles.ADMIN);
		return repo.findByUsername(user);
	}
}
