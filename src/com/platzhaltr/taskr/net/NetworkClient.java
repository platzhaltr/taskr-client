package com.platzhaltr.taskr.net;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Creates a new {@link NetworkClient}
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class NetworkClient {

	private HttpClient httpclient;

	/**
	 * 
	 */
	public NetworkClient() {
		this.httpclient = new DefaultHttpClient();
	}

	/**
	 * @param post
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public void post(HttpPost post) throws ClientProtocolException, IOException {

		httpclient.execute(post);

		// error handling

	}

}
