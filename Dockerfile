# Pull base image
From tomcat:8-jre8

# Maintainer
MAINTAINER "sadavi <sadavi@icct.com">

# Copy to images tomcat path
ADD HibernateHelloWorld.war /usr/local/tomcat/webapps/
