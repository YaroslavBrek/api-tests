pipeline {
    agent any
    stages {
        stage('Build application') {
            steps {
                sh 'docker build -t tests \
                 --build-arg envUrl=crud \
                 --build-arg envPort=9000 \
                 --build-arg testGroup=api .'
            }
        }
        stage('Run tests') {
            steps {
                sh 'docker run \
                --network "external-api" \
                --name "tests" \
                -p 9090:9090 \
                tests'
            }
        }
    }
}
