package com.icct.hibernateworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icct.hibernatehelloworld.dao.MessageDao;
import com.icct.hibernatehelloworld.model.Message;

@Service("messageService")
public class MessageService {
	
	@Autowired
	MessageDao messageDao = new MessageDao();
	
	public Long createMessage(String message){
		return messageDao.createMessage(message);
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Message> readMessage(){
		return messageDao.readMessage();
	}
	
	public Boolean updateMessage(Long messageId, String message){
		return messageDao.updateMessage(messageId, message);
	}
	
	public Boolean deleteMessage(Long messageId){
		return messageDao.deleteMessage(messageId);
	}
}
