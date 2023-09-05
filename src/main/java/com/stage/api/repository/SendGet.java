package com.stage.api.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.ByteArrayOutputStream;

public class SendGet {
	public static byte[] sendGet(String url, String userName, String password) {
		byte[] byteArray;
		try {
            // Création de l'objet URL à partir de l'URL spécifiée
            URL obj = new URL(url);
            
            // Ouverture de la connexion HTTP
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            // Spécification de la méthode de requête GET
            con.setRequestMethod("GET");
            
            // Ajout de l'en-tête "accept" spécifiant le format de réponse souhaité
            con.setRequestProperty("accept", "application/octet-stream");
            
            //ajout des parametres d'authentification
            String auth = userName + ":" + password;
            byte[] authBytes = auth.getBytes(StandardCharsets.UTF_8);
            String encodedAuth = Base64.getEncoder().encodeToString(authBytes);
            String authHeader = "Basic " + encodedAuth;
            con.setRequestProperty("Authorization", authHeader);
            
            // Récupération de la réponse du serveur
            int responseCode = con.getResponseCode();
            InputStream inputStream = con.getInputStream();
            byte[] data = readBytesFromInputStream(inputStream);
            
            /*BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();*/
            // Ajouts
            
            byteArray = data;
            inputStream.close();
            // Affichage de la réponse
            // System.out.println("Response Code: " + responseCode);
            // System.out.println("Response Body: " + response.toString());
        } catch (Exception e) {
        	StringBuffer stringBuffer = new StringBuffer("bonjour");
        	byteArray = stringBuffer.toString().getBytes();
            e.printStackTrace();
        }
		return byteArray;
		
	}
	private static byte[] readBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }
}
