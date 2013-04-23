/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/util/PrimeFacesUtil.p.vm.java
 */
package org.ikane.demospringfuse.web.util;

import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

/**
 * Use this bean to execute JavaScript on client side.
 */
public class PrimeFacesUtil {

    /**
     * Tells the client to update the search results region with the passed text.
     */
    static public void updateSearchResultsRegion(String text) {
        if (RequestContext.getCurrentInstance() != null) {
            RequestContext.getCurrentInstance().execute("APP.updateSearchResultsRegion(\"" + text + "\")");
        }
    }

    static public boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
