package com.portal.business.commons.exceptions;

import org.apache.log4j.Logger;

public class ExchangeRateNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ExchangeRateNotFoundException(String message) {
        super(message);
    }

    public ExchangeRateNotFoundException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public ExchangeRateNotFoundException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
