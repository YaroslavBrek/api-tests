pipeline {
    agent any
    tools {
        maven 'Maven 3.8.5'
        jdk 'jdk8'
    }
    stages {
            stage('Clone repository and run CRUD app') {
                steps {
                        git credentialsId: 'f532c764-fab8-4854-8b57-029c5240dca9', url: 'https://gitlab.nixdev.co/brek/jenkinstraininng.git'
                        sh 'docker build -t app .'
                        sh 'docker run -d -p 9000:9000 app'
                }
            }
            stage ("Wait until app is up"){
                 steps {
                        sh 'sleep 20'
                }
            }
            stage('Run tests against CRUD app') {
                steps {
                        git credentialsId: 'f532c764-fab8-4854-8b57-029c5240dca9', url: 'https://gitlab.nixdev.co/brek/selenium.git'
                        sh 'mvn clean test -Dgroups=api'
            }
        }
    }
}
