FROM maven:3-jdk-8-alpine AS build
WORKDIR /opt/app
COPY ./ /opt/app
RUN mvn clean test -Dgroups=api