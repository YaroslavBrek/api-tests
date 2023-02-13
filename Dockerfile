FROM maven:3-jdk-8-alpine AS build
WORKDIR /opt/app
COPY ./ /opt/app
EXPOSE 9001
CMD mvn clean test -Dgroups=api