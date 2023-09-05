package com.stage.api.controler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stage.api.model.Employee;
import com.stage.api.service.EmployeeService;
import com.stage.api.service.FolderService;
import org.springframework.core.io.ByteArrayResource;



@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    public String st;
    FolderService folderService = new FolderService();

    /**
    * Read - Get all employees
    */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
//    	System.out.println("bonjour");
//    	Iterable<Employee> employees = employeeService.getEmployees();
//        for (Employee employee : employees) {
//        	System.out.println("bonjour");
//            System.out.println(employee.firstName);
//            this.st = employee.firstName;
//        }
//        return this.st;
        return employeeService.getEmployees();
    }
    

    @GetMapping("/video")
    public ResponseEntity<Resource> getVideo() throws IOException {
        String filePath = "uploads/output.mp4";
        Path path = Paths.get(filePath);

        byte[] videoData = Files.readAllBytes(path);
        ByteArrayResource resource = new ByteArrayResource(videoData);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "video.mp4");

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
 
}
