package com.stage.api;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stage.api.repository.logicalDocRepository.LogicalDocRepository;


@SpringBootApplication
public class OnlineCourse1Application {
	public static String username = "admin";//remplacer par le nom d'utilisateur
	public static String password = "admin";//remplacer par le mot de passe de cet utilisateur
	public static void main(String[] args) throws IOException{
		SpringApplication.run(OnlineCourse1Application.class, args);
		LogicalDocRepository.getRequest("http://localhost:8080/services/rest/auth/login?u=admin&pw=admin", username, password);
		//LogicalDocRepository.postRequest("http://localhost:8080/services/rest/folder/create", username, password, "application/json", "application/json", "{  \"name\": \"dossierTEst\",  \"parentId\": 4}");
		//LogicalDocRepository.deleteRequest("http://localhost:8080/services/rest/folder/delete?folderId=112", username, password, "application/json");
		//LogicalDocRepository.putRequest("http://localhost:8080/services/rest/folder/rename?folderId=100&name=000", username, password, "application/json");
	}
}