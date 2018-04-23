package com.pratik.appium.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogUtils {


    static Logger logger = Logger.getLogger(LogUtils.class.getName());

    /**
     * Info message
     *
     * @param message Ex: "Clicked on Sort Button"
     */
    public static void INFO(String message) {
        DOMConfigurator.configure("log4j.xml");
        logger.info(message);
    }

    /**
     * Error message
     *
     * @param message - "element is not visible"
     */
    public static void ERROR(String message) {
        DOMConfigurator.configure("log4j.xml");
        logger.error(message);
    }


}
