/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/dao/DaoImplIT.e.vm.java
 */
package org.ikane.demospringfuse.dao.more;

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

import org.ikane.demospringfuse.domain.more.MoreTypesDemo;
import org.ikane.demospringfuse.repository.more.MoreTypesDemoGenerator;
import org.ikane.demospringfuse.dao.more.MoreTypesDemoDao;

/**
 * Integration test on MoreTypesDemoDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class MoreTypesDemoDaoImplTest {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(MoreTypesDemoDaoImplTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private MoreTypesDemoDao moreTypesDemoDao;

    @Inject
    private MoreTypesDemoGenerator moreTypesDemoGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        MoreTypesDemo moreTypesDemo = moreTypesDemoGenerator.getMoreTypesDemo();

        // add it to a Set before saving (force equals/hashcode)
        Set<MoreTypesDemo> set = newHashSet(moreTypesDemo, moreTypesDemo);
        assertThat(set).hasSize(1);

        moreTypesDemoDao.save(moreTypesDemo);
        entityManager.flush();

        // reload it from cache and check equality
        MoreTypesDemo model = new MoreTypesDemo();
        model.setId(moreTypesDemo.getId());
        assertThat(moreTypesDemo).isEqualTo(moreTypesDemoDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(moreTypesDemo.getId()).isEqualTo(moreTypesDemoDao.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(moreTypesDemo).isNotEqualTo(moreTypesDemoDao.get(model));
    }
}