package com.platzhaltr.taskr.core;

import java.net.URI;

/**
 * Holds the settings for the application
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class Settings {

	final private URI domain;

	/**
	 * Constructs a {@link Settings} object
	 * 
	 * @param domain
	 *            the domain of the server apllication
	 */
	protected Settings(final URI domain) {
		this.domain = domain;
	}

	/**
	 * Returns the domain of the server application
	 * 
	 * @return
	 */
	protected URI getDomain() {
		return domain;
	}

}
