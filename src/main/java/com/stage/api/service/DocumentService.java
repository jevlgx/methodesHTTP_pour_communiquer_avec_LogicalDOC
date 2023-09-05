package com.stage.api.service;

import com.stage.api.repository.SendDelete;
import com.stage.api.repository.SendPut;

public class DocumentService {
	
	String userName = "admin";
	String password = "admin";
	
	public void rename(int documentId, String newName) {
        String url = "http://localhost:8080/services/rest/document/rename?docId=" + documentId + "&name=" + newName;
		SendPut.sendPut(url, this.userName, this.password);
	}
	
	public void delete(int documentId) {
		String url = "http://localhost:8080/services/rest/document/delete?docId=" + Integer.toString(documentId);
		SendDelete.sendDelete(url, this.userName, this.password);
	}
}
