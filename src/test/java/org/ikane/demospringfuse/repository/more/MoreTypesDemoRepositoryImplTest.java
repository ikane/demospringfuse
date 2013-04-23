/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ServiceImplTest.e.vm.java
 */
package org.ikane.demospringfuse.repository.more;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.persistence.NonUniqueResultException;
import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;

import org.ikane.demospringfuse.domain.more.MoreTypesDemo;
import org.ikane.demospringfuse.repository.more.MoreTypesDemoRepositoryImpl;
import org.ikane.demospringfuse.dao.more.MoreTypesDemoDao;
import org.ikane.demospringfuse.dao.support.SearchParameters;

/**
 * Unit test on MoreTypesDemoRepositoryImpl
 */
public class MoreTypesDemoRepositoryImplTest {

    private MoreTypesDemoRepositoryImpl moreTypesDemoRepositoryImpl;
    private MoreTypesDemoDao moreTypesDemoDao;

    @Before
    public void setUp() {
        // called before each test.
        moreTypesDemoRepositoryImpl = new MoreTypesDemoRepositoryImpl();
        moreTypesDemoDao = mock(MoreTypesDemoDao.class);
        moreTypesDemoRepositoryImpl.setMoreTypesDemoDao(moreTypesDemoDao);
    }

    @Test
    public void testFindUniqueOrNoneCaseNone() {
        MoreTypesDemo none = null;

        when(moreTypesDemoDao.findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class))).thenReturn(none);

        MoreTypesDemo result = moreTypesDemoRepositoryImpl.findUniqueOrNone(new MoreTypesDemo());

        assertThat(result).isNull();
        verify(moreTypesDemoDao, times(1)).findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class));
    }

    @Test
    public void testFindUniqueOrNoneCaseUnique() {
        MoreTypesDemo unique = new MoreTypesDemo();

        when(moreTypesDemoDao.findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class))).thenReturn(unique);

        MoreTypesDemo result = moreTypesDemoRepositoryImpl.findUniqueOrNone(new MoreTypesDemo());

        assertThat(result).isNotNull();
        verify(moreTypesDemoDao, times(1)).findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueOrNoneCaseMultiple() {
        when(moreTypesDemoDao.findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        moreTypesDemoRepositoryImpl.findUniqueOrNone(new MoreTypesDemo());
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NoResultException.class)
    public void testFindUniqueCaseNone() {
        when(moreTypesDemoDao.findUnique(any(MoreTypesDemo.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        moreTypesDemoRepositoryImpl.findUnique(new MoreTypesDemo());
    }

    @Test
    public void testFindUniqueCaseUnique() {
        MoreTypesDemo unique = new MoreTypesDemo();

        when(moreTypesDemoDao.findUnique(any(MoreTypesDemo.class), any(SearchParameters.class))).thenReturn(unique);

        MoreTypesDemo result = moreTypesDemoRepositoryImpl.findUnique(new MoreTypesDemo());

        assertThat(result).isNotNull();
        verify(moreTypesDemoDao, times(1)).findUnique(any(MoreTypesDemo.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueCaseMultiple() {
        when(moreTypesDemoDao.findUnique(any(MoreTypesDemo.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        moreTypesDemoRepositoryImpl.findUnique(new MoreTypesDemo());
    }
}