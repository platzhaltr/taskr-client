package com.platzhaltr.taskr.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Builds a new {@link Settings} object
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class SettingsBuilder {

	private static final String HTTP = "http";

	/**
	 * Creates a new {@link Settings} object from the given file
	 * 
	 * @param file
	 *            the File containing the properties
	 * @return
	 * @throws IllegalArgumentException
	 *             , if file can't be cound or isn't a properly configured
	 */
	protected Settings fromFile(File file) throws IllegalArgumentException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(file));
			return fromProperties(properties);
		} catch (IOException e) {
			throw new IllegalArgumentException("Couldn't read settings.", e);
		}

	}

	/**
	 * Creates a new {@link Settings} object from the given properties
	 * 
	 * @param properties
	 *            a {@link Properties} object containing the settings for the
	 *            application
	 * @return
	 * @throws IllegalArgumentException
	 *             if the properties aren't properly configured
	 */
	private Settings fromProperties(Properties properties)
			throws IllegalArgumentException {
		URI uri;
		try {
			uri = new URI(HTTP, properties.getProperty("domain"), null, null);
			return new Settings(uri);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("Couldn't read settings.", e);
		}
	}

}
