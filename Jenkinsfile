pipeline {
    agent any
    tools {
        maven 'Maven 3.8.5'
        jdk 'jdk8'
    }
    stages {
            stage('Clone repository and run CRUD app') {
                steps {
                        git credentialsId: 'c22e2e1e-3a86-4013-ba41-08bf5b0a1c55', url: 'https://gitlab.nixdev.co/brek/jenkinstraininng.git'
                        sh 'mvn spring-boot:run'
                        sh 'mvn spring-boot:stop'
                }
            }
            stage('Run tests against CRUD app') {
                steps {
                        sh 'mvn clean test -Dgroups=api'
            }
        }
    }
}
