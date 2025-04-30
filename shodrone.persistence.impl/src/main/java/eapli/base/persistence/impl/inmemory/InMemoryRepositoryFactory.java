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
package eapli.base.persistence.impl.inmemory;

import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.usermanagement.domain.Roles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.base.utentemanagement.repositories.SignupRequestRepository;
import eapli.base.utentemanagement.repositories.UtenteRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext tx) {
		final var repo = new InMemoryUserRepository();
		// ensure we have at least a power user to be able to use the application
		final var userBuilder = UserBuilderHelper.builder();
		userBuilder.withUsername("poweruser").withPassword("Password1").withName("joe", "power")
				.withEmail("joe@email.org").withRoles(Roles.POWER_USER);
		final var newUser = userBuilder.build();
		repo.save(newUser);
		return repo;
	}

	@Override
	public UserRepository users() {
		return users(null);
	}

	@Override
	public DroneModelRepository droneModels() {
		return droneModels(null);
	}

	@Override
	public DroneModelRepository droneModels(TransactionalContext autoTx) {
		return new InMemoryDroneModelRepository();
	}

	@Override
	public FigureRepository figures(TransactionalContext autoTx) {
		return new InMemoryFigureRepository();
	}

	@Override
	public FigureRepository figures() {
		return figures(null);
	}

	@Override
	public FigureCategoryRepository figureCategories() {
		return figureCategories(null);
	}

	@Override
	public FigureCategoryRepository figureCategories(TransactionalContext autoTx) {
		return new InMemoryFigureCategoryRepository();
	}

	@Override
	public DroneRepository drones() {return drones(null);
	}

	@Override
	public DroneRepository drones(TransactionalContext autoTx) {return new InMemoryDroneRepository();}

	@Override
	public UtenteRepository utentes(final TransactionalContext tx) {

		return new InMemoryUtenteRepository();
	}

	@Override
	public UtenteRepository utentes() {
		return utentes(null);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}

}
