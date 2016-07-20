package com.icct.hibernatehelloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.icct.hibernateworld.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageServices = new MessageService();
	
	public void display(){
		System.out.println("here");
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Long createMessage(@RequestBody String message){
		Long messageId = null;
		
		messageId = messageServices.createMessage(message);
		
		return messageId;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public  List readMessage(){
		System.out.println("here");
		List messages = null;
		
		messages = messageServices.readMessage();
		
		return messages;
	}
	
	@RequestMapping(value = "/update/{id}", method= RequestMethod.PUT)
	public  boolean updateUser(@PathVariable("id") Long messageId, @RequestBody String message){
		return messageServices.updateMessage(messageId, message);
		
	}
	
	@RequestMapping(value = "/delete/{id}", method= RequestMethod.GET)
	public boolean deleteUser(@PathVariable("id") Long messageId){
		return messageServices.deleteMessage(messageId);
		
	}

}
