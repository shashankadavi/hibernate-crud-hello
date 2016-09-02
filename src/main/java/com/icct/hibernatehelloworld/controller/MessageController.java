package com.icct.hibernatehelloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icct.hibernatehelloworld.model.Message;
import com.icct.hibernateworld.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageServices ;
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Long createMessage(@RequestBody Message message){
		Long messageId = null;
		
		messageId = messageServices.createMessage(message.getMessage());
		
		return messageId;
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public  List<Message> readMessage(){
		List<Message> messages = null;
		
		messages = messageServices.readMessage();
		
		return messages;
	}
	
	@RequestMapping(value = "/update/{id}", method= RequestMethod.PUT)
	public  Boolean updateUser(@PathVariable("id") Long messageId, @RequestBody Message message){
		return messageServices.updateMessage(messageId, message.getMessage());
		
	}
	
	@RequestMapping(value = "/delete/{id}", method= RequestMethod.GET)
	public Boolean deleteUser(@PathVariable("id") Long messageId){
		return messageServices.deleteMessage(messageId);
		
	}

}
