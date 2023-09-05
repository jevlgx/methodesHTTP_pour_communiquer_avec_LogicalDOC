package com.stage.api.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SendDelete {
	public static void sendDelete(String url, String userName, String password) {
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestMethod("DELETE");
			con.setRequestProperty("accept", "application/json");
			
			//ajout des parametres d'authentification
            String auth = userName + ":" + password;
            byte[] authBytes = auth.getBytes(StandardCharsets.UTF_8);
            String encodedAuth = Base64.getEncoder().encodeToString(authBytes);
            String authHeader = "Basic " + encodedAuth;
            con.setRequestProperty("Authorization", authHeader);
			
			int responseCode = con.getResponseCode();
			System.out.println("Response Code: " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			System.out.println("Response: " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
