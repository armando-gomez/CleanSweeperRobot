package com.groupseven.exceptions;

public class InvalidEntryException extends Exception {
	
	public InvalidEntryException(String s) {
		System.out.println(s);
	}
	//need to add action to make sure we can handle this
}
