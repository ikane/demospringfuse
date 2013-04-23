/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 */
package org.ikane.demospringfuse.web.domain;

import javax.inject.Named;
import org.ikane.demospringfuse.dao.support.SearchParameters;
import org.ikane.demospringfuse.domain.Address;
import org.ikane.demospringfuse.web.domain.support.GenericSearchForm;
import org.springframework.context.annotation.Scope;

/**
 * View Helper to find/select {@link Address}.
 * It exposes a {@link Address} instance so it can be used in search by Example query.
 */
@Named
@Scope("conversation")
public class AddressSearchForm extends GenericSearchForm<Address, AddressSearchForm> {
    private static final long serialVersionUID = 1L;

    private Address address = new Address();

    public Address getAddress() {
        return address;
    }

    @Override
    protected Address getEntity() {
        return address;
    }

    public SearchParameters toSearchParameters() {
        return new SearchParameters().anywhere();
    }

    @Override
    public AddressSearchForm newInstance() {
        return new AddressSearchForm();
    }

    @Override
    public void resetWithOther(AddressSearchForm other) {
        this.address = other.getAddress();
    }
}