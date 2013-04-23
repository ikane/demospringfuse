/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/conversation/ConversationContext.p.vm.java
 */
package org.ikane.demospringfuse.web.conversation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ikane.demospringfuse.util.ResourcesUtil;

/**
 * Context holding variables and 'conversation' scoped beans so they can be accessed from the view.
 * Note that you can change the view of the context. This allows you to navigate from page to page
 * using the same context.
 */
public class ConversationContext<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *  Stores 'conversation' scope beans.
     */
    private Map<String, Object> beans = new HashMap<String, Object>();

    /**
     *  Stores variables such as 'readonly', 'sub', etc.
     */
    private Map<String, Object> vars = new HashMap<String, Object>();

    /**
     * Stores jsf component id that require special treatment: process the request as if useConversationEntityManager was false.
     * Typical use case is for autoComplete component that should perform query outside of the conversation entity manager.
     */
    private Set<String> sourcesIgnoringUseConversationEntityManager = new HashSet<String>();

    private String conversationId;
    private ConversationCallBack<T> callBack = new ConversationCallBack<T>();
    private String label = "(todo label)"; // Up to the developer to call setLabel or setLabelWithKey
    private String viewUri;
    private boolean useConversationEntityManager = true;

    /**
     * Use this method if the passed entity is either new (not persisted yet) or persistent that is, already present in the conversation's entity manager.
     */
    public void setEntity(T entity) {
        setVar("entity", entity);
    }

    @SuppressWarnings("unchecked")
    public T getEntityAndRemove() {
        return (T) vars.remove("entity");
    }

    /**
     * Use this method if you want the entity to be loaded afterward, using the conversation's entityManager.
     * Our classical usage is as follow: when selecting an entity for edition/view from a search view, we use this method
     * as the entity manager used in the search view is not kept by the conversation.
     */
    public void setEntityId(Serializable entityId) {
        setVar("entityId", entityId);
    }

    @SuppressWarnings("unchecked")
    public <PK> PK getEntityIdAndRemove() {
        return (PK) vars.remove("entityId");
    }

    public void setUseConversationEntityManager(boolean useConversationEntityManager) {
        this.useConversationEntityManager = useConversationEntityManager;
    }

    /**
     * Whether this conversation context needs the conversation's entity manager to be bind or not.
     * If true, then the entity manager of the conversation is binded when this context is active.
     */
    public boolean useConversationEntityManager() {
        return useConversationEntityManager;
    }

    /**
     * Consider the useConversationEntityManager as false when the passed componentId is a javax.faces.source.
     * @param componentId
     */
    public void addSourceIgnoringUseConversationEntityManager(String componentId) {
        sourcesIgnoringUseConversationEntityManager.add(componentId);
    }

    public boolean ignoreUseConversationEntityManager(String componentId) {
        return sourcesIgnoringUseConversationEntityManager.contains(componentId);
    }

    protected void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    /**
     * Sets the label displayed in the conversation menu.
     * @param labelKey the resource property key.
     */
    public void setLabelWithKey(String labelKey) {
        this.label = ResourcesUtil.getInstance().getProperty(labelKey);
    }

    /**
     * Sets the label displayed in the conversation menu.
     * @param label the label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Sets the viewUri attached to this context. 
     */
    public void setViewUri(String viewUri) {
        this.viewUri = viewUri;
    }

    /**
     * The viewUri attached to this context.
     */
    public String getViewUri() {
        return viewUri;
    }

    /**
     * Sets the 'sub' variable. 'sub' is used in the xhtml view to render certain menus/buttons.
     */
    public void setSub(boolean sub) {
        setVar("sub", sub);
    }

    public boolean isSub() {
        return getVar("sub") != null ? (Boolean) getVar("sub") : false;
    }

    /**
     * Sets the 'readonly' variable.
     */
    public void setReadonly(boolean readonly) {
        setVar("readonly", readonly);
    }

    public boolean isReadOnly() {
        return getVar("readonly") != null ? (Boolean) getVar("readonly") : false;
    }

    /**
     * The callback to use just after this context is flagged for pop from the conversation's context stack. 
     */
    public void setCallBack(ConversationCallBack<T> callBack) {
        this.callBack = callBack;
    }

    public ConversationCallBack<T> getCallBack() {
        return callBack;
    }

    /**
     * Returns the URL associated to this context. It is used for direct access, from the conversation menu or the filter.
     */
    public String getUrl() {
        checkViewUriAndConversationId();
        return viewUri + "?_cid_=" + conversationId;
    }

    /**
     * Return the view to display for this context. It is used by actions when returning a view.
     */
    public String view() {
        checkViewUriAndConversationId();
        return viewUri + "?faces-redirect=true&_cid_=" + conversationId;
    }

    private void checkViewUriAndConversationId() {
        if (viewUri == null) {
            throw new IllegalStateException("Developer! viewUri is null, it must be set before calling view() or getUrl() methods");
        }

        if (conversationId == null) {
            throw new IllegalStateException("Developer! conversationId is null, it must be set before calling view() or getUrl() methods");
        }
    }

    // ----------------------------------
    // Support for conversation scope
    // ----------------------------------

    /**
     * Add a conversation scoped bean spring bean to this context. A bean is added either 'automatically' or manually.
     * In the latter case, it is autowired afteward (see ConversationScope).
     */
    public void addBean(String name, Object bean) {
        beans.put(name, bean);
    }

    public Object getBean(String name) {
        return beans.get(name);
    }

    public void setVar(String name, Object var) {
        vars.put(name, var);
    }

    public Object getVar(String name) {
        return vars.get(name);
    }

    @SuppressWarnings("unchecked")
    public <E> E getVar(String name, Class<E> type) {
        return (E) vars.get(name);
    }

    // ------------------------------------------
    // For debug/training purposes: see 
    // ------------------------------------------

    public List<Map.Entry<String, Object>> getBeanEntries() {
        return new ArrayList<Map.Entry<String, Object>>(beans.entrySet());
    }

    public List<Map.Entry<String, Object>> getVarEntries() {
        return new ArrayList<Map.Entry<String, Object>>(vars.entrySet());
    }
}