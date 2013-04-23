/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/DAOImpl.e.vm.java
 */
package org.ikane.demospringfuse.dao;

import javax.inject.Named;
import javax.inject.Singleton;
import org.ikane.demospringfuse.dao.RoleDao;
import org.ikane.demospringfuse.dao.support.GenericDao;
import org.ikane.demospringfuse.domain.Role;

/**
 * JPA 2 Data Access Object for {@link Role}.
 * Note: do not use @Transactional in the DAO layer.
 */
@Named
@Singleton
public class RoleDao extends GenericDao<Role, Integer> {
    public RoleDao() {
        super(Role.class);
    }
}