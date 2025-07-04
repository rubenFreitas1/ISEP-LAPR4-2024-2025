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
package eapli.base.utentemanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

/**
 * A Client User. This class represents "utentes" (client users). It follows a
 * DDD approach where Utente is the root entity of the Utente Aggregate and all
 * of its properties are instances of value objects. A Utente references a
 * System User This approach may seem a little more complex than just having
 * String or native type attributes but provides for real semantic of the domain
 * and follows the Single Responsibility Pattern
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Entity
public class Utente implements AggregateRoot<MecanographicNumber> {

	private static final long serialVersionUID = 1L;

	@Version
	private Long version;

	@EmbeddedId
	private MecanographicNumber mecanographicNumber;

	/**
	 * cascade = CascadeType.NONE as the systemUser is part of another aggregate
	 */
	@OneToOne()
	private SystemUser systemUser;

	public Utente(final SystemUser user, final MecanographicNumber mecanographicNumber) {
		if (mecanographicNumber == null || user == null) {
			throw new IllegalArgumentException();
		}
		this.systemUser = user;
		this.mecanographicNumber = mecanographicNumber;
	}

	protected Utente() {
		// for ORM only
	}

	public SystemUser user() {
		return this.systemUser;
	}

	@Override
	public boolean equals(final Object o) {
		return DomainEntities.areEqual(this, o);
	}

	@Override
	public int hashCode() {
		return DomainEntities.hashCode(this);
	}

	@Override
	public boolean sameAs(final Object other) {
		return DomainEntities.areEqual(this, other);
	}

	public MecanographicNumber mecanographicNumber() {
		return identity();
	}

	@Override
	public MecanographicNumber identity() {
		return this.mecanographicNumber;
	}
}
