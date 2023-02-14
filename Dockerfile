FROM maven:3-jdk-8-alpine AS build
WORKDIR /opt/app
COPY ./ /opt/app
CMD mvn clean test -Dgroups=api -DenvUrl=crud -DenvPort=9000