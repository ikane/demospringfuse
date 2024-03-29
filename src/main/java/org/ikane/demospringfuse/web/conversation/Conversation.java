/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/conversation/Conversation.p.vm.java
 */
package org.ikane.demospringfuse.web.conversation;

import java.io.Serializable;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * A conversation holds a context stack (1 context per view visited) and the entity manager used 
 * during the entire conversation (spans over several view).
 */
public class Conversation implements Serializable {
    public static final String CONVERSATION_COUNTER_KEY = "convCounter";
    private static final Logger log = Logger.getLogger(Conversation.class);

    private static final long serialVersionUID = 1L;

    private String id;
    private EntityManager em;
    private Stack<ConversationContext<?>> contextes = new Stack<ConversationContext<?>>();
    private int popContextOnNextPauseCounter = 0;
    private ConversationContext<?> nextContext;

    /**
     * Create a new conversation and assign it a unique id in the scope of the user's session.
     */
    public static Conversation newInstance(HttpServletRequest request) {
        HttpSession session = request.getSession();
        AtomicInteger counter = (AtomicInteger) session.getAttribute(CONVERSATION_COUNTER_KEY);
        if (counter == null) {
            counter = new AtomicInteger(0);
            session.setAttribute(CONVERSATION_COUNTER_KEY, counter);
        }

        return new Conversation(String.valueOf(counter.incrementAndGet()));
    }

    public Conversation() {
    }

    public Conversation(String id) {
        this.id = id;
    }

    /**
     * Returns this conversation Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the shared {@link EntityManager} used by this conversation's {@link ConversationContext contextes} when their flag useConversationEntityManager is true.
     * The flag is true when we edit an entity which is part of a root's entity graph.
     * For 'search' view, we do not use the passed entityManager. 
     */
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    /**
     * The shared {@link EntityManager} used by this conversation's {@link ConversationContext contextes}.  
     */
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * Whether at least one of this Conversations's {@link ConversationContext} need the entity manager ?
     */
    public boolean isEntityManagerStillNeeded() {
        if (nextContext != null && nextContext.useConversationEntityManager()) {
            return true;
        }

        int ccCount = contextes.size() - popContextOnNextPauseCounter;
        for (int i = 0; i < ccCount; i++) {
            if (contextes.elementAt(i).useConversationEntityManager()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Increment the number of conversation context that must be popped from the stack by the conversation manager when it pauses the current conversation.
     * Why don't we pop directly the context here? When an action is triggered from within a dataTable, the JSF runtime executes some EL after our action. By doing so 
     * it requests a conversation scoped bean that belongs to the current context. If this context is popped too soon, the bean is recreated!
     */
    public void incrementPopContextOnNextPauseCounter() {
        popContextOnNextPauseCounter++;
    }

    /**
     * The number of context that must be popped on next conversation pause.
     */
    public int getPopContextOnNextPauseCounter() {
        return popContextOnNextPauseCounter;
    }

    public void setNextContext(ConversationContext<?> newContext) {
        newContext.setConversationId(getId());
        // we delay the context push because apparently some EL is invoked after bean action is performed
        // which it leads in some cases to re-creation of 'conversation scoped' bean.
        nextContext = newContext; // will be pushed at next request during resuming...
    }

    protected void pushNextContextIfNeeded() {
        if (nextContext != null) {
            contextes.push(nextContext);
            if (log.isDebugEnabled()) {
                log.debug("pushed 1 context on stack: " + nextContext.getLabel());
            }
            nextContext = null;
        }
    }

    public void setNextContextSub(ConversationContext<?> newContext) {
        newContext.setSub(true);
        setNextContext(newContext);
    }

    public void setNextContextSubReadOnly(ConversationContext<?> newContext) {
        newContext.setSub(true);
        newContext.setReadonly(true);
        setNextContext(newContext);
    }

    public void setNextContextReadOnly(ConversationContext<?> newContext) {
        newContext.setReadonly(true);
        setNextContext(newContext);
    }

    public final int getConversationContextesCount() {
        return contextes.size();
    }

    /**
     * Returns the context on top on stack BUT BEWARE, the context could have been scheduled for popping.
     */
    @SuppressWarnings("unchecked")
    public <T extends ConversationContext<?>> T getCurrentContext() {
        return (T) contextes.peek();
    }

    protected Stack<ConversationContext<?>> getConversationContextes() {
        return contextes;
    }

    protected void popContextesIfNeeded() {
        if (log.isDebugEnabled() && popContextOnNextPauseCounter > 1) {
            log.debug("There are " + popContextOnNextPauseCounter + " to pop from the stack");
        }

        for (int i = 0; i < popContextOnNextPauseCounter; i++) {
            ConversationContext<?> ccPopped = contextes.pop();
            if (log.isDebugEnabled()) {
                log.debug("popped 1 context from stack: " + ccPopped.getLabel());
            }
        }
        popContextOnNextPauseCounter = 0;
    }

    /**
     * Returns the view url for the next page. Used by action when returning the view.
     */
    public String nextView() {
        if (nextContext != null) {
            return nextContext.view();
        }

        if (popContextOnNextPauseCounter > 0) {
            ConversationContext<?> contextOnTopOfStackOnNextResume = contextes.elementAt(contextes.size() - 1 - popContextOnNextPauseCounter);
            return contextOnTopOfStackOnNextResume.view();
        }

        return contextes.peek().view();
    }

    public String nextUrl() {
        if (nextContext != null) {
            return nextContext.getUrl();
        }

        if (popContextOnNextPauseCounter > 0) {
            ConversationContext<?> contextOnTopOfStackOnNextResume = contextes.elementAt(contextes.size() - 1 - popContextOnNextPauseCounter);
            return contextOnTopOfStackOnNextResume.getUrl();
        }

        return contextes.peek().getUrl();
    }

    // ------------------------------------------
    // Methods below use the last pushed context
    // ------------------------------------------

    /**
     * @return the label of the last pushed context. 
     */
    public String getLabel() {
        return contextes.peek().getLabel();
    }

    /**
     * @return the menu url of the last pushed context. 
     */
    public String getUrl() {
        return contextes.peek().getUrl();
    }

    /**
     * @return the uri of the last pushed context. 
     */
    public String getViewUri() {
        return contextes.peek().getViewUri();
    }

    public void addBean(String name, Object bean) {
        contextes.peek().addBean(name, bean);
    }

    public Object getBean(String name) {
        return contextes.peek().getBean(name);
    }

    public void setVar(String name, Object var) {
        contextes.peek().setVar(name, var);
    }

    public Object getVar(String name) {
        return contextes.peek().getVar(name);
    }

    public <T> T getVar(String name, Class<T> type) {
        return (T) contextes.peek().getVar(name, type);
    }
}
