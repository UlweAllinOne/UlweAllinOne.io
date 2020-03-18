package com.vicky.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicky.Repository.VisitorEntryRepository;
import com.vicky.entity.VisitorEntity;

@Service
public class VisitorEntryService {

	public static String DIRECTORY = File.separator + System.getProperty("user.home") + File.separator + "SP_images" + File.separator;
	
	@Autowired
	private VisitorEntryRepository visitorEntryRepository;

	public String addVisitorData(String flatno, String phoneno, String comment, String uploadFile) throws SQLException {
		
		int id = visitorEntryRepository.save(flatno,phoneno,comment);
		uploadImage(uploadFile,id);
		return "Successfully added";
	}

	private void uploadImage(String uploadFile, long custid) {
		if (uploadFile != null && !uploadFile.equals("")) {
			try {
				byte[] decodedImg = Base64.getDecoder()
						.decode(uploadFile.replaceAll(" ", "+").getBytes(StandardCharsets.UTF_8));
				Path destinationFile = Paths.get(DIRECTORY, custid + ".png");
				Files.write(destinationFile, decodedImg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<VisitorEntity> visitordetailsFetch() throws Exception {
		// TODO Auto-generated method stub
		return visitorEntryRepository.fetchVisitorDetails();
	}

}
