package com.yihong.seniorcare.common;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * This class allows you to generate log entries.
 * The logging priorities available (in order, lowest to highest) are:
 *
 * <UL>
 * <LI> DEBUG - detailed info, only of interest if you're debugging
 * <LI> INFO - tracking the progress <i>within</i> a module
 * <LI> WARN - something unexpected happened
 * <LI> ERROR - an error has occured
 * <LI> ALWAYS - an important non-error event has occurred
 * <LI> FATAL - a catastrophic error has occurred!
 * </UL>
 * <P>
 * If logging is enabled for a particular priority, all higher priority
 * events will also be logged.
 *
 */

public class LogHandle extends Logger {
	
    private static boolean initDone = false;

    //private static final String PROPERTY_NAME = "npc_log4j_config_file_name";
    //private static final String DEFAULT_FILENAME = "npc_log4j.properties";
    private static final String PROPERTY_NAME = "log4j_config_file_name";
    private static final String CONFIG_DIR = "config"; // under $NPC_HOME of course
    private static final String LOG_DIR = "logs";
    private static final String DEFAULT_FILENAME = "log4j.properties";
    private static final String TO_LOG_FILE = "toLogFile";
    private static final String LOG_EXT = ".log";
    Properties p=new Properties();

    public LogHandle(String name) {
        super(name);
    }
    public LogHandle(Class loggingCategoryName) {
        super(loggingCategoryName.getClass().getName());
        init();
    }

    public Logger getLogHandle(String loggingCategoryName) {
        init();
        return Logger.getLogger(loggingCategoryName);
    }

    public Logger getLogHandle(Class loggingCategoryName) {
        init();
        return Logger.getLogger(loggingCategoryName);
    }

    private synchronized  void init() {
        if (initDone) {
            return;
        }
        _init();
        initDone = true;
    }

    private void _init() {
        String jbFlag = System.getProperty("JVMFlag");
        if ("JBoss".equalsIgnoreCase(jbFlag)) {
            System.out.println("Found NPCJVMFlag=JBoss. Not initializing log4j; " +
                "assuming it is done by JBoss jvm");
            return;
        }
        // If a specific config filename was set, try to use it.
        String filename = System.getProperty(PROPERTY_NAME, DEFAULT_FILENAME);
        if (filename != null && !filename.trim().equals("")) {
        	
            if (_init(filename)) { // Don't override the filename
                return;
            }
        }
               
        // We weren't able to initialize with the generic file. Just use the basic config.
        System.out.println("Unable to initialize log4j from any file; using basic configuration.");
        BasicConfigurator.configure();
    }

    // Return true if we successfully initialized, optionally overriding log4j values from the file
    private  boolean _init(String filename) {
        try {
            if (filename == null) {
                return false;
            }
            Enumeration<URL> props;
            try {
              props= getClass().getClassLoader().getResources(filename);
              p.load(props.nextElement().openStream());
            }
           catch (  Exception e) {
              System.err.println("Logging initialisation failed, cannot find log4j.properties file:" + e);
            }
            PropertyConfigurator.configure(p);
            System.out.println("Initialized log4j using file " + filename);
            return true;
        } catch (Throwable t) {
            System.out.println("Exception occurred initializing log4j from file " + filename);
            t.printStackTrace();
            return false;
        }
    }

    
}
