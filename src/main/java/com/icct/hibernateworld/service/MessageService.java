package com.icct.hibernateworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icct.hibernatehelloworld.dao.MessageDao;

@Service
public class MessageService {
	
	@Autowired
	MessageDao messageDao = new MessageDao();
	
	public Long createMessage(String message){
		return messageDao.createMessage(message);
	}
	
	@SuppressWarnings("rawtypes")
	public List readMessage(){
		return messageDao.readMessage();
	}
	
	public boolean updateMessage(Long messageId, String message){
		return messageDao.updateMessage(messageId, message);
	}
	
	public boolean deleteMessage(Long messageId){
		return messageDao.deleteMessage(messageId);
	}
}
