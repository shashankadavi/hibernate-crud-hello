package com.icct.hibernatehelloworld.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@ImportResource({"classpath:hello-servlet.xml"})
public class HibernateConfig {
	
}
	  



