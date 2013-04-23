/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/SearchForm.e.vm.java
 */
package org.ikane.demospringfuse.web.domain.more;

import static org.ikane.demospringfuse.dao.support.Ranges.RangeBigDecimal.newRangeBigDecimal;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeBigInteger.newRangeBigInteger;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeDate.newRangeDate;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeDouble.newRangeDouble;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeFloat.newRangeFloat;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeInteger.newRangeInteger;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeLocalDate.newRangeLocalDate;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeLocalDateTime.newRangeLocalDateTime;
import static org.ikane.demospringfuse.dao.support.Ranges.RangeLong.newRangeLong;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.dateJavaTemporalDate;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.dateJavaTemporalTimestamp;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.dateJoda;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.dateTimeJoda;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.numberBigDecimal;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.numberBigInteger;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.numberDouble;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.numberFloat;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.numberInt;
import static org.ikane.demospringfuse.domain.more.MoreTypesDemo_.numberLong;
import javax.inject.Named;
import org.ikane.demospringfuse.dao.support.Ranges.RangeBigDecimal;
import org.ikane.demospringfuse.dao.support.Ranges.RangeBigInteger;
import org.ikane.demospringfuse.dao.support.Ranges.RangeDate;
import org.ikane.demospringfuse.dao.support.Ranges.RangeDouble;
import org.ikane.demospringfuse.dao.support.Ranges.RangeFloat;
import org.ikane.demospringfuse.dao.support.Ranges.RangeInteger;
import org.ikane.demospringfuse.dao.support.Ranges.RangeLocalDate;
import org.ikane.demospringfuse.dao.support.Ranges.RangeLocalDateTime;
import org.ikane.demospringfuse.dao.support.Ranges.RangeLong;
import org.ikane.demospringfuse.dao.support.SearchParameters;
import org.ikane.demospringfuse.domain.more.MoreTypesDemo;
import org.ikane.demospringfuse.web.domain.support.GenericSearchForm;
import org.springframework.context.annotation.Scope;

/**
 * View Helper to find/select {@link MoreTypesDemo}.
 * It exposes a {@link MoreTypesDemo} instance so it can be used in search by Example query.
 */
@Named
@Scope("conversation")
public class MoreTypesDemoSearchForm extends GenericSearchForm<MoreTypesDemo, MoreTypesDemoSearchForm> {
    private static final long serialVersionUID = 1L;

    private MoreTypesDemo moreTypesDemo = new MoreTypesDemo();
    private RangeInteger<MoreTypesDemo> numberIntRange = newRangeInteger(numberInt);
    private RangeLong<MoreTypesDemo> numberLongRange = newRangeLong(numberLong);
    private RangeDouble<MoreTypesDemo> numberDoubleRange = newRangeDouble(numberDouble);
    private RangeFloat<MoreTypesDemo> numberFloatRange = newRangeFloat(numberFloat);
    private RangeBigInteger<MoreTypesDemo> numberBigIntegerRange = newRangeBigInteger(numberBigInteger);
    private RangeBigDecimal<MoreTypesDemo> numberBigDecimalRange = newRangeBigDecimal(numberBigDecimal);
    private RangeDate<MoreTypesDemo> dateJavaTemporalDateRange = newRangeDate(dateJavaTemporalDate);
    private RangeDate<MoreTypesDemo> dateJavaTemporalTimestampRange = newRangeDate(dateJavaTemporalTimestamp);
    private RangeLocalDate<MoreTypesDemo> dateJodaRange = newRangeLocalDate(dateJoda);
    private RangeLocalDateTime<MoreTypesDemo> dateTimeJodaRange = newRangeLocalDateTime(dateTimeJoda);

    public MoreTypesDemo getMoreTypesDemo() {
        return moreTypesDemo;
    }

    @Override
    protected MoreTypesDemo getEntity() {
        return moreTypesDemo;
    }

    // Ranges, used from the view.
    public RangeInteger<MoreTypesDemo> getNumberIntRange() {
        return numberIntRange;
    }

    public RangeLong<MoreTypesDemo> getNumberLongRange() {
        return numberLongRange;
    }

    public RangeDouble<MoreTypesDemo> getNumberDoubleRange() {
        return numberDoubleRange;
    }

    public RangeFloat<MoreTypesDemo> getNumberFloatRange() {
        return numberFloatRange;
    }

    public RangeBigInteger<MoreTypesDemo> getNumberBigIntegerRange() {
        return numberBigIntegerRange;
    }

    public RangeBigDecimal<MoreTypesDemo> getNumberBigDecimalRange() {
        return numberBigDecimalRange;
    }

    public RangeDate<MoreTypesDemo> getDateJavaTemporalDateRange() {
        return dateJavaTemporalDateRange;
    }

    public RangeDate<MoreTypesDemo> getDateJavaTemporalTimestampRange() {
        return dateJavaTemporalTimestampRange;
    }

    public RangeLocalDate<MoreTypesDemo> getDateJodaRange() {
        return dateJodaRange;
    }

    public RangeLocalDateTime<MoreTypesDemo> getDateTimeJodaRange() {
        return dateTimeJodaRange;
    }

    public SearchParameters toSearchParameters() {
        return new SearchParameters() //
                .anywhere() //
                .range(numberIntRange) //
                .range(numberLongRange) //
                .range(numberDoubleRange) //
                .range(numberFloatRange) //
                .range(numberBigIntegerRange) //
                .range(numberBigDecimalRange) //
                .range(dateJavaTemporalDateRange) //
                .range(dateJavaTemporalTimestampRange) //
                .range(dateJodaRange) //
                .range(dateTimeJodaRange) //
        ;
    }

    @Override
    public MoreTypesDemoSearchForm newInstance() {
        return new MoreTypesDemoSearchForm();
    }

    @Override
    public void resetWithOther(MoreTypesDemoSearchForm other) {
        this.moreTypesDemo = other.getMoreTypesDemo();
        this.numberIntRange = other.getNumberIntRange();
        this.numberLongRange = other.getNumberLongRange();
        this.numberDoubleRange = other.getNumberDoubleRange();
        this.numberFloatRange = other.getNumberFloatRange();
        this.numberBigIntegerRange = other.getNumberBigIntegerRange();
        this.numberBigDecimalRange = other.getNumberBigDecimalRange();
        this.dateJavaTemporalDateRange = other.getDateJavaTemporalDateRange();
        this.dateJavaTemporalTimestampRange = other.getDateJavaTemporalTimestampRange();
        this.dateJodaRange = other.getDateJodaRange();
        this.dateTimeJodaRange = other.getDateTimeJodaRange();
    }
}