FROM tomcat:9-jre8-alpine
MAINTAINER ruslanriznyk@gmail.com
ENV dbConnectionUrl=$DB_URL_JENKINS dbUserName=$DB_USER_JENKINS dbPassword=$DB_PASS_JENKINS
COPY ./base-of-product.war /usr/local/tomcat/webapps