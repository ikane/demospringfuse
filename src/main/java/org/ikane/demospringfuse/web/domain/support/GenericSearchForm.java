/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/support/GenericSearchForm.p.vm.java
 */
package org.ikane.demospringfuse.web.domain.support;

import static org.ikane.demospringfuse.web.conversation.ConversationHolder.getCurrentConversation;

import java.io.Serializable;
import javax.inject.Inject;
import org.ikane.demospringfuse.dao.support.SearchParameters;
import org.ikane.demospringfuse.web.conversation.ConversationManager;

/**
 * Base Search Form for JPA entities.
 */
public abstract class GenericSearchForm<E, F extends GenericSearchForm<E, F>> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ConversationManager conversationManager;

    /**
     * Return the entity example used in this search form.
     */
    abstract protected E getEntity();

    abstract public SearchParameters toSearchParameters();

    // Reset related

    abstract public F newInstance();

    abstract public void resetWithOther(F other);

    public void reset() {
        resetWithOther(newInstance());
    }

    // ------------------------------------
    // Actions
    // ------------------------------------

    public String back() {
        return getCurrentConversation().getCurrentContext().getCallBack().back();
    }

    /**
     * Quit, used from search page. It ends the conversation. It is expected to be non-ajax.
     */
    public String quit() {
        conversationManager.endCurrentConversation();
        return "/home.faces?faces-redirect=true"; // TODO: clean url, referer or else
    }
}
