package com.yihong.seniorcare.common;

/**
 * Generate Type
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.log4j.Logger;


public class ProductProperties {

	private static LogHandle logHandle = new LogHandle(ProductProperties.class);
	private static Logger _logger = logHandle.getLogHandle(ProductProperties.class);
	
	static private Properties productProperties = new Properties(System.getProperties());
	static private String productPropertiesFile = "Product.properties";
	static private boolean _inited = false;
	static Locale locale = null;
	

	/**
	 * Properties constructor comment.
	 */
	public ProductProperties() {
		initialize();
	}

	
	/**
	 * Generated Method
	 * 
	 * @return java.lang.String
	 * @param name
	 *            java.lang.String
	 */
	 public String getProperty(String name) {
		if (!_inited)
			initialize();
		return productProperties.getProperty(name);
	}

	 public String reReadProperty(String name, String defValue) {
		if (!_inited)
			initialize();

		loadProductProperties();
		return productProperties.getProperty(name, defValue);
	}

	/**
	 * Generated Method
	 * 
	 * @return java.lang.String
	 * @param name
	 *            java.lang.String
	 */
	public String getProperty(String name, String defaultValue) {

		if (!_inited)
			initialize();
		return productProperties.getProperty(name, defaultValue);
	}

	/**
	 * Generated Method
	 * 
	 * @return boolean
	 */
	public void initialize() {
	
		_logger.info("initializing product properties");
		productPropertiesFile = System.getProperty("npc_product_properties_file", "Product.properties");
		// productPropertiesFile =
		// "E:/MISD/NPC/NPCMexico/NPC/config/Product.properties";

		_logger.info("Product properties file name = " + productPropertiesFile);

		loadProductProperties();

		String tz = productProperties.getProperty("user.timezone", "");

		if (tz != null) {
			_logger.info("setting time zone = " + tz);
			TimeZone.setDefault(TimeZone.getTimeZone(tz));
		} else {
			_logger.info("user.timezone parameter is not set");
			_logger.debug("system timezone = " + TimeZone.getDefault());
		}

		
		_inited = true;

	}
    public  void loadProductProperties() {
    	InputStream in = getClass().getClassLoader().getResourceAsStream(productPropertiesFile);
        try {
        	productProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void loadProductPropertiesOld() {
		FileInputStream propIs = null;
		BufferedInputStream buffIs = null;
		try {
			_logger.debug("loadProductProperties():  load property file -"
					+ productPropertiesFile);
			propIs = new FileInputStream(productPropertiesFile);
			if (propIs != null) {
				buffIs = new BufferedInputStream(propIs);
				productProperties.clear();
				productProperties.load(buffIs);
			}
		} catch (IOException ex) {
			System.out.println("Cannot read property file:"
					+ productPropertiesFile + "  ex:" + ex);
			_logger.fatal("Cannot read property file:" + productPropertiesFile,
					ex);
			
		} finally {
			if (buffIs != null)
				try {
					buffIs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (propIs != null)
				try {
					propIs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			_logger.debug("loadProductProperties():  close proeprty file");
		}

	}

	

	
	public  Locale getLocale() {
		if (!_inited)
			initialize();
		if (locale == null) {
			String lcl = "en_GB";
			lcl = productProperties.getProperty("locale", "en").trim();
			_logger.info("locale property=" + lcl);
			locale = new Locale(lcl);
			_logger.info("locale=" + locale.toString());
		}
		return locale;
	}

	

}
