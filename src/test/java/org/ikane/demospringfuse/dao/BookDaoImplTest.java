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

import org.ikane.demospringfuse.domain.Book;
import org.ikane.demospringfuse.repository.BookGenerator;
import org.ikane.demospringfuse.dao.BookDao;

/**
 * Integration test on BookDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class BookDaoImplTest {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(BookDaoImplTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private BookDao bookDao;

    @Inject
    private BookGenerator bookGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Book book = bookGenerator.getBook();

        // add it to a Set before saving (force equals/hashcode)
        Set<Book> set = newHashSet(book, book);
        assertThat(set).hasSize(1);

        bookDao.save(book);
        entityManager.flush();

        // reload it from cache and check equality
        Book model = new Book();
        model.setId(book.getId());
        assertThat(book).isEqualTo(bookDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(book.getId()).isEqualTo(bookDao.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(book).isNotEqualTo(bookDao.get(model));
    }
}