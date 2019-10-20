package UrlEpand;

import java.io.*;
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
	public static String expand(String url){
		try{
			// Gets the URL returned from reading the tiny/short URL passed.
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setInstanceFollowRedirects(true);
			connection.getInputStream().read();
			
			// Clean up the returned URL and return as a string.
			url = connection.toString().replace("sun.net.www.protocol.https.DelegateHttpsURLConnection:", "");
		}catch(MalformedURLException e){
			e.printStackTrace();
			return "Please check the URL.";
		}catch(IOException e){
			e.printStackTrace();
			return "Please check your connection.";
		}catch(Exception e){
			e.printStackTrace();
			return "General Error.";
		}
		return url;
	}
	
	public static void main(String[] args){
		System.out.println(ShortUrl.expand("https://tiny.cc/upmuez"));
	}
}