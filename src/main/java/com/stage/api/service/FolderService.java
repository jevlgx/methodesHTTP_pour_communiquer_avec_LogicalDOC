package com.stage.api.service;

import com.stage.api.repository.SendDelete;
import com.stage.api.repository.SendGet;
import com.stage.api.repository.SendPost;

public class FolderService {
	
	private String userName = "admin";
	private String password = "admin";
	
	public void create(String name, int parentId) {
		String url = "http://localhost:8080/services/rest/folder/create";
        String requestBody = "{\"name\":\""+name+"\",\"parentId\":" + parentId + "}";
        SendPost.sendPost(url, this.userName, this.password, requestBody);
	}
	
	public void update(int folderId, String newName) {
		String url = "http://localhost:8080/services/rest/folder/update";
        String requestBody = "{\"id\":"+folderId+",\"name\": \""+newName+"\"}";
        SendPost.sendPost(url, this.userName, this.password, requestBody);
	}
	
	public void listDocuments(int folderId) {
		String url = "http://localhost:8080/services/rest/document/list?folderId="+ Integer.toString(folderId);
		SendGet.sendGet(url, this.userName, this.password);
	}
	
	public void listChildFolders(int folderId) {
		String url = "http://localhost:8080/services/rest/folder/listChildren?folderId="+ Integer.toString(folderId);
		SendGet.sendGet(url, this.userName, this.password);
	}
	
	public void listContent(int folderId) {
		listDocuments(folderId);
		listChildFolders(folderId);
	}
	
	public void delete(int folderId) {
		String url = "http://localhost:8080/services/rest/folder/delete?folderId=" + Integer.toString(folderId);
		SendDelete.sendDelete(url, this.userName, this.password);
	}
}
