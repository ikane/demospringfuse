/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 */
package org.ikane.demospringfuse.web.domain;

import javax.inject.Inject;
import javax.inject.Named;
import org.ikane.demospringfuse.domain.Legacy;
import org.ikane.demospringfuse.domain.LegacyPk;
import org.ikane.demospringfuse.repository.LegacyRepository;
import org.ikane.demospringfuse.web.domain.support.GenericEditForm;
import org.springframework.context.annotation.Scope;

/**
 * View Helper/Controller to edit {@link Legacy}.
 */
@Named
@Scope("conversation")
public class LegacyEditForm extends GenericEditForm<Legacy, LegacyPk> {

    @Inject
    public void setLegacyRepository(LegacyRepository legacyRepository) {
        setRepository(legacyRepository);
    }

    public Legacy getLegacy() {
        return getEntity();
    }
}