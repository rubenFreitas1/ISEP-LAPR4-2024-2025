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
package eapli.base.infrastructure.persistence;

import eapli.base.customerManagement.repositories.CustomerRepository;
import eapli.base.droneManagement.repositories.DroneRepository;
import eapli.base.droneModelManagement.repositories.DroneModelRepository;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.base.figureManagement.repository.DSLRepository;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.pluginManagementService.repository.PluginRepository;
import eapli.base.representativeManagement.repositories.RepresentativeRepository;
import eapli.base.showProposalManagement.repositories.ShowProposalRepository;
import eapli.base.showProposalManagement.repositories.TemplateRepository;
import eapli.base.showRequestManagement.repositories.ShowRequestRepository;
import eapli.base.utentemanagement.repositories.SignupRequestRepository;
import eapli.base.utentemanagement.repositories.UtenteRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx
     *            the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    DroneModelRepository droneModels();

    /**
     *
     * @param autoTx
     *          the transactional context to enroll
     * @return
     */
    DroneModelRepository droneModels(TransactionalContext autoTx);

    CustomerRepository customers();

    CustomerRepository customers(TransactionalContext autoTx);

    PluginRepository plugins();

    PluginRepository plugins(TransactionalContext autoTx);

    RepresentativeRepository representatives();

    RepresentativeRepository representatives(TransactionalContext autoTx);

    ShowRequestRepository showRequests(TransactionalContext autoTx);

    ShowRequestRepository showRequests();

    ShowProposalRepository showProposals(TransactionalContext autoTx);

    ShowProposalRepository showProposals();

    TemplateRepository templates(TransactionalContext autoTx);

    TemplateRepository templates();

    FigureRepository figures(TransactionalContext autoTx);

    FigureRepository figures();

    DSLRepository dsls(TransactionalContext autoTx);

    DSLRepository dsls();

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    FigureCategoryRepository figureCategories();

    /**
     *
     * @param autoTx
     *           the transactional context to enroll
     * @return
     */
    FigureCategoryRepository figureCategories(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    DroneRepository drones();

    /**
     *
     * @param autoTx
     *           the transactional context to enroll
     * @return
     */
    DroneRepository drones(TransactionalContext autoTx);


    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    UtenteRepository utentes(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UtenteRepository utentes();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

}
