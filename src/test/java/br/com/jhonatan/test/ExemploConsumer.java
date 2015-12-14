package br.com.jhonatan.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import sun.misc.BASE64Encoder;

public class ExemploConsumer {
	public static void main(String[] args) {
		try {
		    
			   String webPage = "http://localhost:8090/personalcontrol/despesaApi/listarDespesas";
			   String name = "rest";
			   String password = "rest";
			 
			   String authString = name + ":" + password;
			   System.out.println("Auth string: " + authString);
			    
			   String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
			   System.out.println("Base64 encoded auth string: " + authStringEnc);
			 
			   URL url = new URL(webPage);
			   HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			   urlConnection.setRequestMethod("GET");
			   urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			   InputStream is = urlConnection.getInputStream();
			   InputStreamReader isr = new InputStreamReader(is);
			 
			   int numCharsRead;
			   char[] charArray = new char[1024];
			   StringBuffer sb = new StringBuffer();
			   while ((numCharsRead = isr.read(charArray)) > 0) {
				   sb.append(charArray, 0, numCharsRead);
			   }
			   String result = sb.toString();
			 
			   System.out.println("---------------------------------------------");
			   System.out.println("Response from the server: " + result);
			    
			  } catch (MalformedURLException e) {
			   e.printStackTrace();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	  }
}

