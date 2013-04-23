/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/EntityMeta_.e.vm.java
 */
package org.ikane.demospringfuse.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ikane.demospringfuse.domain.Account;

@StaticMetamodel(Book.class)
public abstract class Book_ {

    // Raw attributes
    public static volatile SingularAttribute<Book, Integer> id;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Integer> numberOfPages;
    public static volatile SingularAttribute<Book, Integer> version;

    // Technical attributes for query by example
    public static volatile SingularAttribute<Book, String> accountId;

    // Many to one
    public static volatile SingularAttribute<Book, Account> account;
}