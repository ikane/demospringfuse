/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/dao/DaoImplIT.e.vm.java
 */
package org.ikane.demospringfuse.dao;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import org.ikane.demospringfuse.domain.Legacy;
import org.ikane.demospringfuse.repository.LegacyGenerator;
import org.ikane.demospringfuse.dao.LegacyDao;

/**
 * Integration test on LegacyDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class LegacyDaoImplTest {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(LegacyDaoImplTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private LegacyDao legacyDao;

    @Inject
    private LegacyGenerator legacyGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Legacy legacy = legacyGenerator.getLegacy();

        // add it to a Set before saving (force equals/hashcode)
        Set<Legacy> set = newHashSet(legacy, legacy);
        assertThat(set).hasSize(1);

        legacyDao.save(legacy);
        entityManager.flush();

        // reload it from cache and check equality
        Legacy model = new Legacy();
        model.setId(legacy.getId());
        assertThat(legacy).isEqualTo(legacyDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(legacy).isEqualTo(legacyDao.get(model));
    }
}