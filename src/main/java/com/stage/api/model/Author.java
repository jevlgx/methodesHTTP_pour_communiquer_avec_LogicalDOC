package com.stage.api.model;

import com.stage.api.repository.SendGet;

public class Author {
	
	public void login() {
		String url = "http://localhost:8080/services/rest/auth/login?u=admin&pw=admin";
		String userName = "admin";
		String password = "admin";
		SendGet.sendGet(url, userName, password);
	}
}
