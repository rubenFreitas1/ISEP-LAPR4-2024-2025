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
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showProposalManagement.repositories.TemplateRepository;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.base.utentemanagement.repositories.SignupRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public DroneModelRepository droneModels() {
        return new JpaDroneModelRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public DroneModelRepository droneModels(TransactionalContext autoTx) {
        return new JpaDroneModelRepository(autoTx);
    }

    @Override
    public CustomerRepository customers() {
        return new JpaCustomerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CustomerRepository customers(TransactionalContext autoTx) {return new JpaCustomerRepository(autoTx);}

    @Override
    public RepresentativeRepository representatives() {
        return new JpaRepresentativeRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public RepresentativeRepository representatives(TransactionalContext autoTx) {
        return new JpaRepresentativeRepository(autoTx);
    }

    @Override
    public ShowRequestRepository showRequests(TransactionalContext autoTx) {
        return new JpaShowRequestRepository(autoTx);
    }

    @Override
    public ShowRequestRepository showRequests() {
        return new JpaShowRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ShowProposalRepository showProposals(TransactionalContext autoTx) {
        return new JpaShowProposalRepository(autoTx);
    }

    @Override
    public ShowProposalRepository showProposals() {
        return new JpaShowProposalRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TemplateRepository templates(TransactionalContext autoTx) {
        return new JpaTemplateRepository(autoTx);
    }

    @Override
    public TemplateRepository templates() {
        return new JpaTemplateRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public FigureRepository figures(TransactionalContext autoTx) {
        return new JpaFigureRepository(autoTx);
    }

    @Override
    public FigureRepository figures() {
        return new JpaFigureRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public FigureCategoryRepository figureCategories() {
        return new JpaFigureCategoryRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public FigureCategoryRepository figureCategories(TransactionalContext autoTx) {
        return new JpaFigureCategoryRepository(autoTx);
    }

    @Override
    public DroneRepository drones() {
        return new JpaDroneRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public DroneRepository drones(TransactionalContext autoTx) {
        return new JpaDroneRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository utentes(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository utentes() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

}
