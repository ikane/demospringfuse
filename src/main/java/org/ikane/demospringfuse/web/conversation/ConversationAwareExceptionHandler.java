/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/conversation/ConversationAwareExceptionHandler.p.vm.java
 */
package org.ikane.demospringfuse.web.conversation;

import static org.ikane.demospringfuse.web.conversation.ConversationHolder.getCurrentConversation;

import java.util.Iterator;

import javax.faces.context.ExceptionHandler;
import javax.faces.event.ExceptionQueuedEvent;

import org.omnifaces.exceptionhandler.FullAjaxExceptionHandler;
import org.springframework.dao.DataAccessException;

import org.ikane.demospringfuse.web.conversation.ConversationManager;
import org.ikane.demospringfuse.web.util.ExceptionUtil;
import org.ikane.demospringfuse.web.util.MessageUtil;

/**
 * Exception handling is configured here, in web.xml (see error-page tag) and in faces-config.xml.
 */
public class ConversationAwareExceptionHandler extends FullAjaxExceptionHandler {

    public ConversationAwareExceptionHandler(ExceptionHandler wrapped) {
        super(wrapped);
    }

    @Override
    public void handle() {
        Iterator<ExceptionQueuedEvent> unhandledExceptionQueuedEvents = getUnhandledExceptionQueuedEvents().iterator();

        if (unhandledExceptionQueuedEvents.hasNext()) {
            Throwable exception = unhandledExceptionQueuedEvents.next().getContext().getException();

            // nice message
            MessageUtil.getInstance().error(exception);

            if (getCurrentConversation() != null && ExceptionUtil.isCausedBy(exception, DataAccessException.class)) {
                // DATA ACCESS EXCEPTION
                // As per JPA spec it is safer to do not reuse the entity manager.
                // Therefore, we end the conversation.
                ConversationManager.getInstance().endCurrentConversation();
                // fall through, the parent will display the proper view.
            }
        }
        super.handle();
    }
}
