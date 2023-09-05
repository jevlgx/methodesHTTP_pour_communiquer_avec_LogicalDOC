package com.stage.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;

import com.stage.api.repository.SendGet;

@SpringBootApplication
public class OnlineCourse1Application {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(OnlineCourse1Application.class, args);
		//byte[] documentByte = SendGet.sendGet("http://localhost:8080/services/rest/document/getContent?docId=102", "admin", "admin");
        //System.out.println("Le fichier MP4 a été créé avec succès.");
        //convertBytesToMP4(documentByte);
	}
	
	private static String convertBytesToMP4(byte[] documentByte) throws IOException{
		File mp4File = new File("uploads/output.mp4");
		FileOutputStream outputStream = new FileOutputStream(mp4File);
		FileCopyUtils.copy(documentByte,outputStream);
		outputStream.close();
		return "yo";
	}
}