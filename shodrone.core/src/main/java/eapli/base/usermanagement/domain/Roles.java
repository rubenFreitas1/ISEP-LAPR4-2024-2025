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
package eapli.base.usermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 *
 *
 * 
 * @author Paulo Gandra Sousa
 *
 */
public final class Roles {
	/**
	 * poweruser
	 */
	public static final Role POWER_USER = Role.valueOf("POWER_USER");
	/**
	 * Representative
	 */
	public static final Role CUSTOMER_REPRESENTATIVE = Role.valueOf("CUSTOMER_REPRESENTATIVE");


	/**
	 * Customer
	 */
	public static final Role CUSTOMER = Role.valueOf("CUSTOMER");


	/**
	 * Administrator
	 */
	public static final Role ADMIN = Role.valueOf("ADMIN");

	/**
	 *
	 */
	public static final Role CRM_MANAGER = Role.valueOf("CRM_MANAGER");
	/**
	 *
	 */
	public static final Role CRM_COLLABORATOR = Role.valueOf("CRM_COLLABORATOR");
	/**
	 *
	 */
	public static final Role SHOW_DESIGNER = Role.valueOf("SHOW_DESIGNER");


	public static final Role DRONE_TECH = Role.valueOf("DRONE_TECH");


	/**
	 * get available role types for adding new users
	 *
	 * @return
	 */
	public static Role[] nonUserValues() {
		return new Role[] { ADMIN, CRM_MANAGER, CRM_COLLABORATOR, SHOW_DESIGNER, DRONE_TECH };
	}

	public boolean isCollaborator(final Role role) {
		return role != CUSTOMER_REPRESENTATIVE;
	}
}
