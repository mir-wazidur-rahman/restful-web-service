/**
 * 
 */
package com.springlearning.rest.restfulwebservices.bean;

/**
 * @author Mir
 *
 */
public class HelloWorldBean {
	
	private String message = null;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}


}
