package com.icct.hibernatehelloworld.controller.test;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.icct.hibernatehelloworld.controller.MessageController;
import com.icct.hibernatehelloworld.model.Message;
import com.icct.hibernateworld.service.MessageService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jayway.restassured.module.mockmvc.response.MockMvcResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:*/test-dispatcher-servlet.xml")
public class MessageControllerTest {
	
	
	private MessageService messageService;	
		
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private MessageController messageControllerUnderTest;
	
	@Before
	public void setUp(){
		messageService = (MessageService) context.getBean("messageService");
		messageService = mock(MessageService.class);
		ReflectionTestUtils.setField(messageControllerUnderTest, "messageService", messageService);
		MockitoAnnotations.initMocks(this);

//		RestAssuredMockMvc.standaloneSetup(messageControllerUnderTest);		
		RestAssuredMockMvc.mockMvc(MockMvcBuilders.webAppContextSetup(context).build());
			}
	
	@Test
	public void readMessageTest(){
	//	MockMvcResponse response =
		Message message = new Message(1L,"Hello");
		List<Message> testList = new ArrayList<Message>();
		testList.add(message);
		
		Mockito.when(messageService.readMessage()).
		thenReturn (testList);
		
		given().
				webAppContextSetup(context).
		
		when().
				get("/read"). 
				peek().
		then().
				statusCode(200);
	//			extract().response();
		
//		
//		String jsonAsString = response.getBody().asString();
//		jsonAsString.contains("Hello World");		
		
	}
	
	@Test
	public void createMessageTest(){
		//Long messageId =  1L;
//		Long response =
		MockMvcResponse response =
		
		given().
				contentType("application/json").
				body("{   \"id\" : \"1\", \"message\" :\"let's create a message again\"}").
		when().
				post("/create").
//				peek().
		then().
				extract().response();
		
		String jsonAsString = response.asString();
//		jsonAsString.isEmpty();
//		response.jsonPath().getLong(jsonAsString)
//		Long jsonLong = Long.parseLong(jsonAsString);
		
//		response.compareTo(messageId);
				
	}
	
	@Test
	public void updateMessageTest(){
		String pathId="id";
		MockMvcResponse response =
				
		
		given().
				param("id", 1).
				body("{   \"id\" : \"1\", \"message\" :\"let's update a message again\"}").
		
		when().
				put("/update/" + pathId).
//				peek().
		then().
			extract().response();
				
		
		String jsonString = response.asString();
		Boolean jsonBoolean = Boolean.valueOf(jsonString);
				
		
		
		
	}
	
	@Test
	public void deleteMessageTest(){
		String pathId="id";
		MockMvcResponse response =
				
		
		given().
				param("id", 1).
		
		when().
				put("/delete/" + pathId).
//				peek().
		then().
			extract().response();
				
		
		String jsonString = response.asString();
		Boolean jsonBoolean = Boolean.valueOf(jsonString);
			
		
		
		
		
	}
	
	
	
	
	
}
