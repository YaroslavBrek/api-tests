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
                -v allure-results:/var/target/allure-results
                -p 9001:9000 \
                tests'
            }
        }
    }
}
