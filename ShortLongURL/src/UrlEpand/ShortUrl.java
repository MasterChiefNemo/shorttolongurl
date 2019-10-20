package UrlEpand;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ShortUrl{
	public static String expand(String url){
		try{
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setInstanceFollowRedirects(true);
			connection.getInputStream().read();
			url = connection.toString().replace("sun.net.www.protocol.https.DelegateHttpsURLConnection:", "");
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return url;
	}
	
	public static void main(String[] args){
		System.out.println(ShortUrl.expand("https://tiny.cc/upmuez"));
	}
}