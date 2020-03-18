package com.vicky.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.entity.VisitorEntity;
import com.vicky.service.VisitorEntryService;

@RestController
public class VisitorEntryController {
	
	@Autowired
	VisitorEntryService visitorEntryService;
	
	@PostMapping(value="/addVisitorData")
    public String addVisitorData(@RequestParam String flatno,@RequestParam String phoneno,@RequestParam String comment,@RequestParam String uploadFile) throws Exception{
          return visitorEntryService.addVisitorData(flatno,phoneno,comment,uploadFile);          
    }
	
	@GetMapping(value="/visitordetailsFetch")
	 public List<VisitorEntity> visitordetailsFetch() throws Exception{
		return visitorEntryService.visitordetailsFetch();	
	 }
	
	@PostMapping("/download")
    @ResponseBody
    public String downloadFile1(@RequestParam String visitorid) throws IOException {
        try{
            String fileName = VisitorEntryService.DIRECTORY +  visitorid+".png";
            File file = new File(fileName);
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            return Base64.getEncoder().encodeToString(fileContent);
        }catch (IOException e) {
            e.printStackTrace();
        }      
       return "";
    }

}
