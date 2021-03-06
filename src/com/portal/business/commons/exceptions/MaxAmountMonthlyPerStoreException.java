package com.portal.business.commons.exceptions;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class MaxAmountMonthlyPerStoreException extends Exception{
    public MaxAmountMonthlyPerStoreException(String message) { super(message);}
    
    public MaxAmountMonthlyPerStoreException(String message,
        StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
    
     public MaxAmountMonthlyPerStoreException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }
}
