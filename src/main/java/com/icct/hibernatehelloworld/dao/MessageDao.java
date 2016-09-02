package com.icct.hibernatehelloworld.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.icct.hibernatehelloworld.model.Message;

public class MessageDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	//@Autowired
	//HibernateTemplate hibernateTemplate;
	
	//HibernateDaoSupport daoSupport;
	
	public Long createMessage(String message) {
		 Session session = sessionFactory.openSession();
		 Long messageID= null;
		 Transaction tx = null;
		 try{
			 tx = session.beginTransaction();
		     Message currentMessage = new Message();
		     currentMessage.setMessage(message);
		     messageID =(Long) session.save(currentMessage);
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
	
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List readMessage(){
		 Session session = sessionFactory.openSession();
		 		 Transaction tx = null;
		 		 List<Message> messages = null;
		 try{
			 tx = session.beginTransaction();
			 //Query q = session.createQuery("FROM Message",Message.class);			 
			 messages = session.createQuery("FROM Message").getResultList();
			 //messages = session.createCriteria(Message.class).list();
			 
		     
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
	
	
	public Boolean updateMessage(Long messageID, String message ){
		 Session session = sessionFactory.openSession();
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
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally {
			 session.close();
		 }
		 return updated;
		 
	}
	
	public Boolean deleteMessage(Long messageID){
		 Session session = sessionFactory.openSession();
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
		 }catch(Exception e){
			 e.printStackTrace();
		 }finally {
			 session.close();
		 }
		 return deleted;
	}

		
}
