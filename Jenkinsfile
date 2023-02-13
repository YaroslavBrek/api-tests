pipeline {
    agent any
    stages {
        stage('Build application') {
            steps {
                sh 'docker build -t tests .'
            }
        }
        stage('Run tests') {
            steps {
                sh 'docker run \
                --network "external-api" \
                --publish 9001:9001 \
                tests'
            }
        }
    }
}
