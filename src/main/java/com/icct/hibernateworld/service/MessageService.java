package com.icct.hibernateworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icct.hibernatehelloworld.dao.MessageDao;

@Service
public class MessageService {
	
	@Autowired
	MessageDao messageDao = new MessageDao();
	
	public Integer createMessage(String message){
		return messageDao.createMessage(message);
	}
	
	public List readMessage(){
		return messageDao.readMessage();
	}
	
	public boolean updateMessage(Integer messageId, String message){
		return messageDao.updateMessage(messageId, message);
	}
	
	public boolean deleteMessage(Integer messageId){
		return messageDao.deleteMessage(messageId);
	}
}
