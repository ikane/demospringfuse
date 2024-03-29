/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/converter/JsfConverter.e.vm.java
 */
package org.ikane.demospringfuse.web.converter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.ikane.demospringfuse.domain.Book;
import org.ikane.demospringfuse.repository.BookRepository;
import org.ikane.demospringfuse.web.converter.GenericJsfConverter;

/**
 * JSF Converter for {@link Book}.
 */
@Named
@Singleton
public class BookJsfConverter extends GenericJsfConverter<Book, Integer> {
    @Inject
    public BookJsfConverter(BookRepository bookRepository) {
        super(bookRepository, Book.class, Integer.class);
    }
}