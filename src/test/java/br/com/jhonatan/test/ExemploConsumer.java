package br.com.jhonatan.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jhonatan.entidades.Despesa;
import sun.misc.BASE64Encoder;

public class ExemploConsumer {

	public static void main(String[] args) {
		String param = "{id:1" + "}";
		//doGet();
		doPost();
	}



	private static void doPost() {
		try {

			URL url = new URL("http://localhost:8080/personalcontrol/despesaApi/salvarDespesa");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			String name = "rest";
			String password = "rest";

			String authString = name + ":" + password;
			System.out.println("Auth string: " + authString);

			String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
			System.out.println("Base64 encoded auth string: " + authStringEnc);
			
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

			ObjectMapper mapper = new ObjectMapper();
			Despesa despesa = new Despesa();
			despesa.setId(1L);
			String input = mapper.writeValueAsString(despesa);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}



	private static void doGet() {
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

