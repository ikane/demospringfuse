/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/domain/CompositePk.cpk.vm.java
 */
package org.ikane.demospringfuse.domain;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

import com.google.common.base.Objects;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class LegacyPk implements Comparable<LegacyPk>, Serializable {
    static final private long serialVersionUID = 1L;

    private String code;
    private Integer dept;
    private String name;

    public LegacyPk() {
    }

    public LegacyPk(String code, Integer dept, String name) {
        this.code = code;
        this.dept = dept;
        this.name = name;
    }

    /**
     * Helper to determine if this composite primary key can be considered as set or not.
     */
    @Transient
    public boolean isIdSet() {
        return isCodeSet() && isDeptSet() && isNameSet();
    }

    /**
     * Helper method to determine if this instance is considered empty, that is,
     * if all the non primary key columns are null.
     */
    @Transient
    public boolean isEmpty() {
        return !isCodeSet() && !isDeptSet() && !isNameSet();
    }

    //-- [code] ------------------------------

    @Size(max = 8)
    @NotEmpty
    @Column(name = "CODE", nullable = false, length = 8)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Helper that determines if this attribute is set or not.
     */
    @Transient
    public boolean isCodeSet() {
        return getCode() != null && !getCode().isEmpty();
    }

    //-- [dept] ------------------------------

    @NotNull
    @Column(name = "DEPT", nullable = false, precision = 10)
    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    /**
     * Helper that determines if this attribute is set or not.
     */
    @Transient
    public boolean isDeptSet() {
        return getDept() != null;
    }

    //-- [name] ------------------------------

    @Size(max = 16)
    @NotEmpty
    @Column(name = "NAME", nullable = false, length = 16)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Helper that determines if this attribute is set or not.
     */
    @Transient
    public boolean isNameSet() {
        return getName() != null && !getName().isEmpty();
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof LegacyPk && hashCode() == other.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCode(), getDept(), getName());
    }

    @Override
    public int compareTo(LegacyPk other) {
        return other == null ? -1 : hashCode() - other.hashCode();
    }

    /**
     * Return the string representation of the composite primary key, it should be reversable by version produced by the {@link #String()} method
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (isCodeSet()) {
            result.append(getCode());
        }
        result.append(":");
        if (isDeptSet()) {
            result.append(getDept());
        }
        result.append(":");
        if (isNameSet()) {
            result.append(getName());
        }

        return result.toString();
    }

    /**
     * Build an instance from a string version produced by the {@link #toString()} method
     */
    public static LegacyPk fromString(String string) {
        LegacyPk result = new LegacyPk();
        String[] values = string.split(":");
        if (isNotEmpty(values[0])) {
            result.setCode(values[0]);
        }
        if (isNotEmpty(values[1])) {
            result.setDept(new Integer(values[1]));
        }
        if (isNotEmpty(values[2])) {
            result.setName(values[2]);
        }

        return result;
    }
}
