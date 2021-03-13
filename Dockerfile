FROM tomcat:9-jre8-alpine
MAINTAINER ruslanriznyk@gmail.com
COPY ./base-of-product.war /usr/local/tomcat/webapps