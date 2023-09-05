package com.stage.api.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendPost {
	public static void sendPost(String url, String userName, String password, String requestBody) {
		try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Configuration de la requête
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Authentification de base
            String authString = userName + ":" + password;
            String encodedAuth = java.util.Base64.getEncoder().encodeToString(authString.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);

            // Envoi du corps de la requête
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();

            // Lecture de la réponse
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Affichage de la réponse
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + response.toString());

            // Fermeture de la connexion
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
