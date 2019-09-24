package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlHttpWebServer {
	public static String producerPOST(String stringURL, String json) throws IOException {
		URL url = new URL(stringURL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		//httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		httpURLConnection.connect();
		
		OutputStream outStream = httpURLConnection.getOutputStream();
		outStream.write(json.getBytes("UTF-8"));
		outStream.flush();
		outStream.close();
		
		int responseCode = httpURLConnection.getResponseCode();
		String responseMessageIS = httpURLConnection.getResponseMessage();
		System.out.println("GET Response Code : : " + responseCode);
		System.out.println("GET Response Message : : " + responseMessageIS);
		
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())); 
		StringBuffer stringBuffer = new StringBuffer();
		String line;		
		while((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
		}
		bufferedReader.close();
		httpURLConnection.disconnect();
		return stringBuffer.toString();
	}
}
