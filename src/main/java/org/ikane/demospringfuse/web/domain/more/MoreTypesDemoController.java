/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/Controller.e.vm.java
 */
package org.ikane.demospringfuse.web.domain.more;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import org.ikane.demospringfuse.dao.support.SearchParameters;
import org.ikane.demospringfuse.domain.more.MoreTypesDemo;
import org.ikane.demospringfuse.repository.more.MoreTypesDemoRepository;
import org.ikane.demospringfuse.web.conversation.Conversation;
import org.ikane.demospringfuse.web.conversation.ConversationContext;
import org.ikane.demospringfuse.web.conversation.ConversationFactory;

/**
 * Stateless controller for MoreTypesDemo conversation start. Provides also auto-complete support. 
 */
@Named
@Singleton
public class MoreTypesDemoController implements ConversationFactory {
    public final static String editUri = "/domain/more/moreTypesDemoEdit.faces";
    public final static String selectUri = "/domain/more/moreTypesDemoSelect.faces";
    private MoreTypesDemoRepository moreTypesDemoRepository;

    @Inject
    public void setMoreTypesDemoRepository(MoreTypesDemoRepository moreTypesDemoRepository) {
        this.moreTypesDemoRepository = moreTypesDemoRepository;
    }

    // --------------------------------
    // ConversationFactoryImpl
    // --------------------------------

    @Override
    public boolean canCreateConversation(HttpServletRequest request) {
        return selectUri.equals(request.getServletPath());
    }

    @Override
    public Conversation createConversation(HttpServletRequest request) {
        String uri = request.getServletPath();
        if (selectUri.equals(uri)) {
            Conversation conversation = Conversation.newInstance(request);
            ConversationContext<MoreTypesDemo> ctx = newSearchContext();
            ctx.setLabelWithKey("moreTypesDemo");
            conversation.setNextContext(ctx);
            return conversation;
        }

        throw new IllegalStateException("Unexpected conversation creation demand");
    }

    // --------------------------------
    // Autocomplete support
    // --------------------------------

    /**
     * This method is used from primefaces autocomplete components.
     */
    public List<MoreTypesDemo> complete(String value) {
        SearchParameters sp = new SearchParameters().anywhere().searchPattern(value);
        return moreTypesDemoRepository.find(sp);
    }

    // --------------------------------
    // Helper 
    // --------------------------------    

    /**
     * Helper to construct a new ConversationContext to edit an MoreTypesDemo.
     * @param moreTypesDemo the entity to edit.
     */
    public static ConversationContext<MoreTypesDemo> newEditContext(final MoreTypesDemo moreTypesDemo) {
        ConversationContext<MoreTypesDemo> ctx = new ConversationContext<MoreTypesDemo>();
        ctx.setEntity(moreTypesDemo); // used by GenericEditForm.init()
        ctx.setViewUri(editUri);
        return ctx;
    }

    /**
     * Helper to construct a new ConversationContext to edit an MoreTypesDemo.
     * @param id the id of the entity to edit.
     */
    public static ConversationContext<MoreTypesDemo> newEditContext(final Integer id) {
        ConversationContext<MoreTypesDemo> ctx = new ConversationContext<MoreTypesDemo>();
        ctx.setEntityId(id); // used by GenericEditForm.init()
        ctx.setViewUri(editUri);
        return ctx;
    }

    /**
     * Helper to construct a new ConversationContext for search/selection.
     */
    public static ConversationContext<MoreTypesDemo> newSearchContext() {
        ConversationContext<MoreTypesDemo> ctx = new ConversationContext<MoreTypesDemo>();
        ctx.setUseConversationEntityManager(false);
        ctx.setViewUri(selectUri);
        return ctx;
    }
}