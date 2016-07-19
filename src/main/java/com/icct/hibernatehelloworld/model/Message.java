package com.icct.hibernatehelloworld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Message {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name ="message")
	private String message;
	
	public Message(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
