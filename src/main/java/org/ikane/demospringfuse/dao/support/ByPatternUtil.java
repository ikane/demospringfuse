/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/support/ByPatternUtil.p.vm.java
 */
package org.ikane.demospringfuse.dao.support;

import static com.google.common.collect.Lists.newArrayList;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.MANY_TO_ONE;
import static javax.persistence.metamodel.Attribute.PersistentAttributeType.ONE_TO_ONE;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

@Named
@Singleton
public class ByPatternUtil {

    @PersistenceContext
    private EntityManager em;

    /**
     * Lookup entities having at least one String attribute matching the passed sp's pattern
     */
    public <T> Predicate byPattern(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder, final SearchParameters sp, final Class<T> type) {
        if (!sp.hasSearchPattern()) {
            return null;
        }

        List<Predicate> predicates = newArrayList();
        EntityType<T> entity = em.getMetamodel().entity(type);
        String pattern = sp.getSearchPattern();

        for (Attribute<T, ?> attr : entity.getDeclaredSingularAttributes()) {
            if (attr.getPersistentAttributeType() == MANY_TO_ONE || attr.getPersistentAttributeType() == ONE_TO_ONE) {
                continue;
            }

            if (attr.getJavaType() == String.class) {
                predicates.add(JpaUtil.stringPredicate(root.get(attribute(entity, attr)), pattern, sp, builder));
            }
        }

        return JpaUtil.orPredicate(builder, predicates);
    }

    private static <T> SingularAttribute<T, String> attribute(EntityType<T> entity, Attribute<T, ?> attr) {
        return entity.getDeclaredSingularAttribute(attr.getName(), String.class);
    }
}