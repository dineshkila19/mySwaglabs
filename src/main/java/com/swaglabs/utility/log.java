/**
 * 
 */
package com.swaglabs.utility;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.model.Log;

/**
 * @author Dinesh
 *
 */
public class log {
	
	public static Logger log=Logger.getLogger(Log.class.getName());
	public static void startTestCase(String sTestCaseName) {
		log.info("========"+sTestCaseName+"TEST START"+"==========");
	}
	public static void endTestCase(String sTestCaseName) {
		log.info("========"+sTestCaseName+"TEST END"+"=========");
	}
	public static void info(String message) {
		log.info(message);
	}
	public static void error(String message) {
		log.info(message);
	}
	public static void warn(String message) {
		log.info(message);
	}
	public static void fatal(String message) {
		log.info(message);
	}
	public static void debug(String message) {
		log.info(message);
	}
	
	
	

}
