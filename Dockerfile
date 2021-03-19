FROM tomcat:9-jre8-alpine
MAINTAINER ruslanriznyk@gmail.com
RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY ./target/base-of-product.war /usr/local/tomcat/webapps/ROOT.war
COPY ./target/base-of-product.war /usr/local/tomcat/webapps/
