package com.vicky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vicky.Repository.FeedBackRepository;
import com.vicky.entity.FeedBackEntity;

@Service
public class FeedBackService {

	
	@Autowired
	FeedBackRepository feedBackRepository;
	
	public String feedbackdetails(String name, String mobileNo, String message) throws Exception {
		
		return feedBackRepository.save(name,mobileNo,message);
	}

	public List<FeedBackEntity> feedbackdetailsFetch() throws Exception {
		return feedBackRepository.fetchAllDetails();
	}

}
