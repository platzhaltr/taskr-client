package com.platzhaltr.taskr.core;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.apache.http.client.ClientProtocolException;

import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.Cli;
import uk.co.flamingpenguin.jewel.cli.CliFactory;

import com.platzhaltr.taskr.net.NetworkClient;
import com.platzhaltr.taskr.net.RequestBuilder;

/**
 * Creates a new taskr client
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class Client {

	private static final String SETTINGS = "settings.properties";

	private RequestBuilder requestBuilder;

	/**
	 * Constructs a new {@link Client}
	 * 
	 * @param baseURI
	 */
	public Client(URI baseURI) {
		System.out.println(baseURI);
		this.requestBuilder = new RequestBuilder(baseURI);
	}

	/**
	 * Create a new task
	 * 
	 * @param rawTask
	 */
	protected void newTask(String rawTask) {
		try {
			new NetworkClient().post(requestBuilder.postTask(rawTask));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Cli<Arguments> cli = null;
		Arguments parsedArguments;
		try {
			cli = CliFactory.createCli(Arguments.class);
			parsedArguments = cli.parseArguments(args);
		} catch (ArgumentValidationException e) {

			return;
		}
		String rawTask = parsedArguments.getTask();

		try {
			SettingsBuilder settingsBuilder = new SettingsBuilder();
			Settings settings = settingsBuilder.fromFile(getSettingsFile());

			new Client(settings.getDomain()).newTask(rawTask);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	private static String getSettingsPath() {
		return System.getProperty("user.dir")
				+ System.getProperty("file.separator") + SETTINGS;
	}

	private static File getSettingsFile() {
		return new File(getSettingsPath());
	}

}
