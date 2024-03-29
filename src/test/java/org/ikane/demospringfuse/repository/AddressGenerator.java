/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package org.ikane.demospringfuse.repository;

import javax.inject.Named;
import javax.inject.Singleton;
import org.ikane.demospringfuse.domain.Address;
import org.ikane.demospringfuse.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@SuppressWarnings("unused")
@Named
@Singleton
public class AddressGenerator {

    /**
     * Returns a new Address instance filled with random values.
     */
    public Address getAddress() {
        Address address = new Address();

        // simple attributes follows
        address.setStreetName("a");
        address.setCity("a");
        return address;
    }

}