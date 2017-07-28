package com.jay.immoral.client.error;

import java.util.ArrayList;
import java.util.List;

/**
 * Nothing of a kind, right?!
 * xD
 * @author Jay
 *
 */

public class ErrorManager {

	public static List<Exception> errors = new ArrayList<Exception>();
	
	public void addErrorToStore(Exception e) {
		this.errors.add(e);
	}
	
	public void deleteError(Exception e) {
		this.errors.remove(e);
	}
	
	public List<Exception> getErrors() {
		return errors;
	}
	
}
