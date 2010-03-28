package com.platzhaltr.taskr.net;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 * 
 */
public class RequestBuilder {

	private static final String POST_TASK_PATH = "/index.php";
	private static final String POST_TASK_CONTENT_PARAM = "content";

	private URI baseURI;

	/**
	 * @param baseURI
	 */
	public RequestBuilder(URI baseURI) {
		this.baseURI = baseURI;
	}

	/**
	 * @param rawTask
	 * @return
	 */
	public HttpPost postTask(String rawTask) {
		HttpPost post = new HttpPost(getTaskUrl(baseURI));
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair(POST_TASK_CONTENT_PARAM, rawTask));

		try {
			post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		} catch (UnsupportedEncodingException e) {
			// TODO log
		}
		return post;
	}

	private URI getTaskUrl(URI baseURI) {
		URI uri = null;
		try {
			uri = new URI(baseURI.toString().concat(POST_TASK_PATH));
		} catch (URISyntaxException e) {
			// TODO log
		}
		return uri;
	}

}
