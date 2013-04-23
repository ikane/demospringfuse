/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/printer/Printer.e.vm.java
 */
package org.ikane.demospringfuse.printer;

import static org.apache.commons.lang.StringUtils.isBlank;

import javax.inject.Named;
import javax.inject.Singleton;

import java.util.Locale;

import org.ikane.demospringfuse.domain.Document;
import org.ikane.demospringfuse.printer.DiscoverablePrinter;

/**
 * {@link org.springframework.format.Printer} for {@link Document} 
 *
 * @see org.springframework.format.Printer
 * @see DiscoverablePrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class DocumentPrinter extends DiscoverablePrinter<Document> {
    public DocumentPrinter() {
        super(Document.class);
    }

    @Override
    public String print(Document document, Locale locale) {
        if (document == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder(256);
        if (!isBlank(document.getDocumentContentType())) {
            if (ret.length() != 0) {
                ret.append('/');
            }
            ret.append(document.getDocumentContentType().trim());
        }
        if (!isBlank(document.getDocumentFileName())) {
            if (ret.length() != 0) {
                ret.append('/');
            }
            ret.append(document.getDocumentFileName().trim());
        }
        return ret.toString();
    }
}
