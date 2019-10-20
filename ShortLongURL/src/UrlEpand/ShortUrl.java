package UrlEpand;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ShortUrl{

	public static void expand(String url){
		try{
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setInstanceFollowRedirects(true);
			connection.getInputStream().read();
			
			url = connection.toString();
			System.out.println(url);
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		//return null;
	}
	
	public static void main(String[] args){
		ShortUrl.expand("https://tinyurl.com/2tx");
	}
}