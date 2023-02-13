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
                --name "tests" \
                -p 9001:9000 \
                tests'
            }
        }
    }
}
