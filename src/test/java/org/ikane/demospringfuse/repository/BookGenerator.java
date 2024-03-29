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
import org.ikane.demospringfuse.domain.Book;
import org.ikane.demospringfuse.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@SuppressWarnings("unused")
@Named
@Singleton
public class BookGenerator {

    /**
     * Returns a new Book instance filled with random values.
     */
    public Book getBook() {
        Book book = new Book();

        // simple attributes follows
        book.setTitle("a");
        book.setNumberOfPages(1);
        return book;
    }

}