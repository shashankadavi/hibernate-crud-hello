package com.icct.hibernatehelloworld.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.icct.hibernatehelloworld.model.Message;
import com.icct.hibernatehelloworld.util.HibernateUtil;

public class MessageDao {
	
	@Autowired
	HibernateUtil hibernateUtil;
	
	public Integer createMessage(String message) {
		 Session session = hibernateUtil.getSessionFactory().openSession();
		 Integer messageID= null;
		 Transaction tx = null;
		 try{
			 tx = session.beginTransaction();
		     Message currentMessage = new Message();
		     currentMessage.setMessage(message);
		     messageID =(Integer) session.save(currentMessage);
		     tx.commit();

		 }catch(HibernateException e){
			 if(tx!=null){
				 tx.rollback();
				 e.printStackTrace();
			 }
		 }finally {
			 session.close();
		 }
		 return messageID;        			
	}
	
	
	public List readMessage(){
		 Session session = hibernateUtil.getSessionFactory().openSession();
		 		 Transaction tx = null;
		 		 List messages = null;
		 try{
			 tx = session.beginTransaction();
			  messages = session.createQuery("FROM Message").getResultList();
			 
			 
		     
		 }catch(HibernateException e){
			 if(tx!=null){
				 tx.rollback();
				 e.printStackTrace();
			 }
		 }finally {
			 session.close();
		 }
		return messages;
		
	}
	
	
	public boolean updateMessage(Integer messageID, String message ){
		 Session session = hibernateUtil.getSessionFactory().openSession();
		 Transaction tx = null;
		 boolean updated = false;
		 
		 try{
			 tx = session.beginTransaction();
		     Message oldMessage = (Message)session.get(Message.class, messageID);
		     oldMessage.setMessage(message);
		     session.update(oldMessage);
		     tx.commit();
		     updated= true;
		     
		 }catch(HibernateException e){
			 if(tx!=null){
				 tx.rollback();
				 e.printStackTrace();
			 }
		 }finally {
			 session.close();
		 }
		 return updated;
		 
	}
	
	public boolean deleteMessage(Integer messageID){
		 Session session = hibernateUtil.getSessionFactory().openSession();
		 Transaction tx = null;
		 boolean deleted = false;
		 
		 try{
			 tx = session.beginTransaction();
			 Message oldMessage = (Message)session.get(Message.class,messageID);
			 session.delete(oldMessage);
			 tx.commit();
			 deleted = true;
			 
		 }catch(HibernateException e){
			 if(tx!=null){
				 tx.rollback();
				 e.printStackTrace();
			 }
		 }finally {
			 session.close();
		 }
		 return deleted;
	}

		
}
