package com.jay.immoral.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.jay.immoral.client.Client;
import com.jay.immoral.client.error.ErrorManager;

public class Logger {

	private static ErrorManager errorManager;
	
	/**
	 * Logs Stuff..
	 * @param o - String
	 */
	public static void log(Object o) {
		System.out.println(Client.clientName + " >> " + o);
	}
	
	/**
	 * Use this for initialization
	 * @param o - Initialization Message
	 */
	public static void initialize(Object o){
		System.out.println("Initializing >> " + o);
	}
	
	/**
	 * Use this for "info"
	 * @param o - Info Message
	 */
	public static void info(Object o) {
		System.out.println("Info >> " + o);
	}
	
	/**
	 * Use this for loading shit (log it)
	 * @param o - Logging message/thing
	 */
	public static void loading(Object o) {
		System.out.println("Loading >> " + o);
	}
	
	/**
	 * Use this to log errors. It will print the stack trace and add the Exception to a list, see ErrorManager.class.
	 * @param o - Possible Error.
	 * @param e - Exception
	 */
	public static void error(Object o, Exception e) {
		e.printStackTrace();
		System.out.println("Error >> " + "Caught by: " + e + ", Possible reason: " + o);
		errorManager.addErrorToStore(e);
	}
	
}
