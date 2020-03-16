  package com.vicky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vicky.entity.FeedBackEntity;
import com.vicky.service.FeedBackService;

@RestController
public class FeedBackController   {
	
	@Autowired
	FeedBackService feedBackService;
	
	@PostMapping(value="/feedbackdetailsSave")
	 public String feedbackdetails(@RequestParam String name,@RequestParam String mobileNo,@RequestParam String message) throws Exception{
		return feedBackService.feedbackdetails(name,mobileNo,message);	
	 }
	
	@GetMapping(value="/test")
	 public String test() throws Exception{
		return "Ok Success";	
	 }
	
	@GetMapping(value="/feedbackdetailsFetch")
	 public List<FeedBackEntity> feedbackdetailsFetch() throws Exception{
		return feedBackService.feedbackdetailsFetch();	
	 }

}
