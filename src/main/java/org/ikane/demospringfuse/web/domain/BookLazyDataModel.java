/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/LazyDataModel.e.vm.java
 */
package org.ikane.demospringfuse.web.domain;

import static org.ikane.demospringfuse.web.conversation.ConversationHolder.getCurrentConversation;
import java.util.Arrays;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import org.ikane.demospringfuse.domain.Book;
import org.ikane.demospringfuse.repository.BookRepository;
import org.ikane.demospringfuse.repository.support.Repository;
import org.ikane.demospringfuse.web.conversation.ConversationContext;
import org.ikane.demospringfuse.web.converter.BookJsfConverter;
import org.ikane.demospringfuse.web.domain.support.GenericLazyDataModel;
import org.ikane.demospringfuse.web.domain.support.GenericSearchForm;
import org.springframework.context.annotation.Scope;

/**
 * Provides server-side pagination for search.
 * TODO: dependencies wiring after deserialization (get inspiration from http://jira.springframework.org/browse/SWF-1224 )
 */
@Named
@Scope("conversation")
public class BookLazyDataModel extends GenericLazyDataModel<Book, Integer, BookSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private BookRepository bookRepository;
    @Inject
    transient private BookJsfConverter bookConverter;
    @Inject
    transient private BookSearchForm bookSearchForm;

    private Book[] selectedRows;

    @Override
    protected Repository<Book, Integer> getRepository() {
        return bookRepository;
    }

    @Override
    protected Converter getConverter() {
        return bookConverter;
    }

    @Override
    protected GenericSearchForm<Book, BookSearchForm> getSearchForm() {
        return bookSearchForm;
    }

    @Override
    protected ConversationContext<Book> getSelectedContext(Book selected) {
        if (selected.isIdSet()) {
            // just the id matters as we want to reload it in the conversation entity manager.
            return BookController.newEditContext(selected.getId());
        } else {
            return BookController.newEditContext(selected); // fresh entity (creation)
        }
    }

    // -----------------------------------
    // Multi selection support
    // -----------------------------------

    public void setSelectedRows(Book[] selectedRows) {
        this.selectedRows = selectedRows;
    }

    public Book[] getSelectedRows() {
        return selectedRows;
    }

    public String multiSelect() {
        return getCurrentConversation() //
                .<ConversationContext<Book>> getCurrentContext() //
                .getCallBack() //
                .selected(Arrays.asList(selectedRows));
    }
}