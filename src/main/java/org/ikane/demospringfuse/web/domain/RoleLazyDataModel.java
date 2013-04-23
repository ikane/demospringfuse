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
import java.util.Map;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import org.ikane.demospringfuse.dao.support.OrderBy;
import org.ikane.demospringfuse.dao.support.SearchParameters;
import org.ikane.demospringfuse.domain.Role;
import org.ikane.demospringfuse.repository.RoleRepository;
import org.ikane.demospringfuse.repository.support.Repository;
import org.ikane.demospringfuse.web.conversation.ConversationContext;
import org.ikane.demospringfuse.web.converter.RoleJsfConverter;
import org.ikane.demospringfuse.web.domain.support.GenericLazyDataModel;
import org.ikane.demospringfuse.web.domain.support.GenericSearchForm;
import org.primefaces.model.SortOrder;
import org.springframework.context.annotation.Scope;

/**
 * Provides server-side pagination for search.
 * TODO: dependencies wiring after deserialization (get inspiration from http://jira.springframework.org/browse/SWF-1224 )
 */
@Named
@Scope("conversation")
public class RoleLazyDataModel extends GenericLazyDataModel<Role, Integer, RoleSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private RoleRepository roleRepository;
    @Inject
    transient private RoleJsfConverter roleConverter;
    @Inject
    transient private RoleSearchForm roleSearchForm;

    private Role[] selectedRows;

    @Override
    protected Repository<Role, Integer> getRepository() {
        return roleRepository;
    }

    @Override
    protected Converter getConverter() {
        return roleConverter;
    }

    @Override
    protected GenericSearchForm<Role, RoleSearchForm> getSearchForm() {
        return roleSearchForm;
    }

    @Override
    protected SearchParameters populateSearchParameters(SearchParameters sp, int first, int pageSize, String sortField, SortOrder sortOrder,
            Map<String, String> filters) {
        super.populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters);
        if (!sp.hasOrders()) {
            sp.addOrderBy(new OrderBy("roleName"));
        }
        return sp;
    }

    @Override
    protected ConversationContext<Role> getSelectedContext(Role selected) {
        if (selected.isIdSet()) {
            // just the id matters as we want to reload it in the conversation entity manager.
            return RoleController.newEditContext(selected.getId());
        } else {
            return RoleController.newEditContext(selected); // fresh entity (creation)
        }
    }

    // -----------------------------------
    // Multi selection support
    // -----------------------------------

    public void setSelectedRows(Role[] selectedRows) {
        this.selectedRows = selectedRows;
    }

    public Role[] getSelectedRows() {
        return selectedRows;
    }

    public String multiSelect() {
        return getCurrentConversation() //
                .<ConversationContext<Role>> getCurrentContext() //
                .getCallBack() //
                .selected(Arrays.asList(selectedRows));
    }
}