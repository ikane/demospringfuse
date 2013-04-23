/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/Identifiable.p.vm.java
 */
package org.ikane.demospringfuse.domain;

import java.io.Serializable;

/**
 * By making entities implement this interface we can easily retrieve from the
 * {@link org.ikane.demospringfuse.dao.support.GenericDao} the identifier property of the entity.
 */

public interface Identifiable<PK extends Serializable> {

    /**
     * @return the primary key
     */
    PK getId();

    /**
     * Sets the primary key
     */
    void setId(PK id);

    /**
     * Helper method to know whether the primary key is set or not.
     * @return true if the primary key is set, false otherwise
     */
    boolean isIdSet();
}