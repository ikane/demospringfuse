/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/EntityMeta_.e.vm.java
 */
package org.ikane.demospringfuse.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Legacy.class)
public abstract class Legacy_ {
    // Composite primary key
    public static volatile SingularAttribute<Legacy, LegacyPk> id;

    // Raw attributes
    public static volatile SingularAttribute<Legacy, String> extraInfo;
}