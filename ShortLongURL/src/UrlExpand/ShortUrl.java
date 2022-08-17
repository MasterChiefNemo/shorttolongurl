package UrlExpand;

import java.net.*;

/**
 * 
 * @author Damien Hunter
 * 
 * Credit to Thomas Tasche, https://gist.github.com/TomTasche/1104272
 *
 * Short URL expands tiny URLs to full URLs. The reason for this app is 
 * to ensure links are safe to click and follow.
 *
 */
public class ShortUrl{
	public static String expand(String url) throws Exception{
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setInstanceFollowRedirects(true);
		connection.getInputStream().read();
			
		// Clean up the returned URL and return as a string.
		url = connection.toString().replace("sun.net.www.protocol.https.DelegateHttpsURLConnection:", "");
		return url;
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(ShortUrl.expand(args[0]));
	}
}