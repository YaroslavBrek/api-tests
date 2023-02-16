FROM maven:3-jdk-8-alpine AS build
WORKDIR /opt/app
COPY ./ /opt/app
ARG envUrl
ARG envPort
ARG testGroup
ENV env_url $envUrl
ENV env_port $envPort
ENV test_group $testGroup
CMD mvn clean test -Dgroups=$test_group -DenvUrl=$env_url -DenvPort=$env_port