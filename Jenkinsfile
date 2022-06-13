pipeline {
    agent any
    tools {
        maven 'Maven 3.8.5'
        jdk 'jdk8'
    }
    stages {
        stage('Run tests against CRUD app') {
            steps {
                sh 'mvn clean test -Dgroups=api'
            }
        }
    }
}
