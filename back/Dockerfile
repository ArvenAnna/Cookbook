From touchvie/tomcat8-jdk8:latest

ENV JPDA_ADDRESS=8000
ENV JPDA_TRANSPORT=dt_socket

ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update && apt-get install -y --no-install-recommends apt-utils

# install maven

# preserve Java 8  from the maven install.
RUN mv /etc/alternatives/java /etc/alternatives/java8
RUN apt-get update -y && apt-get install maven -y

# Restore Java 8
RUN mv -f /etc/alternatives/java8 /etc/alternatives/java
RUN ls -l /usr/bin/java && java -version

RUN mkdir -p /usr/recipe
WORKDIR /usr/recipe
COPY . /usr/recipe/

RUN mvn clean install
RUN mv /usr/recipe/target/Cookbook-1.0-SNAPSHOT /usr/local/tomcat/webapps/ROOT

EXPOSE 8080 13333 8000
ENTRYPOINT ["catalina.sh", "jpda", "run"]

ENV DEBIAN_FRONTEND teletype