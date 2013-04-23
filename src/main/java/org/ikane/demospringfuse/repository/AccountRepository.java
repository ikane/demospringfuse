/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/Repository.e.vm.java
 */
package org.ikane.demospringfuse.repository;

import org.ikane.demospringfuse.domain.Account;
import org.ikane.demospringfuse.repository.support.Repository;

/**
 * The AccountRepository is a data-centric service for the {@link Account} entity.
 * It provides the expected methods to get/delete a {@link Account} instance
 * plus some methods to perform searches.
 * <p>
 * Search logic is driven by 2 kinds of parameters: a {@link Account} instance used
 * as a properties holder against which the search will be performed and a {@link SearchParameters}
 * instance from where you can control your search options including the usage
 * of named queries.
 */
public interface AccountRepository extends Repository<Account, String> {

    /**
     * Return the persistent instance of {@link Account} with the given unique property value username,
     * or null if there is no such persistent instance.
     *
     * @param username the unique value
     * @return the corresponding {@link Account} persistent instance or null
     */
    Account getByUsername(String username);

    /**
     * Delete a {@link Account} using the unique column username
     *
     * @param username the unique value
     */
    void deleteByUsername(String username);

    /**
     * Return the persistent instance of {@link Account} with the given unique property value email,
     * or null if there is no such persistent instance.
     *
     * @param email the unique value
     * @return the corresponding {@link Account} persistent instance or null
     */
    Account getByEmail(String email);

    /**
     * Delete a {@link Account} using the unique column email
     *
     * @param email the unique value
     */
    void deleteByEmail(String email);
}