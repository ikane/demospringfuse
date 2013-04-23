/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package org.ikane.demospringfuse.repository.more;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.inject.Named;
import javax.inject.Singleton;
import org.ikane.demospringfuse.domain.more.MoreTypesDemo;
import org.ikane.demospringfuse.util.ValueGenerator;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@SuppressWarnings("unused")
@Named
@Singleton
public class MoreTypesDemoGenerator {

    /**
     * Returns a new MoreTypesDemo instance filled with random values.
     */
    public MoreTypesDemo getMoreTypesDemo() {
        MoreTypesDemo moreTypesDemo = new MoreTypesDemo();

        // simple attributes follows
        moreTypesDemo.setNumberInt(1);
        moreTypesDemo.setNumberLong(1l);
        moreTypesDemo.setNumberDouble(1d);
        moreTypesDemo.setNumberFloat(1f);
        moreTypesDemo.setNumberBigInteger(BigInteger.ONE);
        moreTypesDemo.setNumberBigDecimal(BigDecimal.ONE);
        moreTypesDemo.setDateJavaTemporalDate(new Date());
        moreTypesDemo.setDateJavaTemporalTimestamp(new Date());
        moreTypesDemo.setDateJoda(new org.joda.time.LocalDate());
        moreTypesDemo.setDateTimeJoda(new org.joda.time.LocalDateTime());
        return moreTypesDemo;
    }

}