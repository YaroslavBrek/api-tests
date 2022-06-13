pipeline {
    agent any
    tools {
        maven 'Maven 3.8.5'
        jdk 'jdk8'
    }
    stages {
            stage('Clone repository and run CRUD app') {
                steps {
                        step {
                                git credentialsId: 'c22e2e1e-3a86-4013-ba41-08bf5b0a1c55', url: 'https://gitlab.nixdev.co/brek/jenkinstraininng.git'
                             }
                        step {
                                sh 'mvn spring-boot:run'
                             }
                }
            }
        stage('Run tests against CRUD app') {
            steps {
                sh 'mvn clean test -Dgroups=api'
            }
        }
    }
}
