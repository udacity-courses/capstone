pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                println('compile application')
                sh '''
                cd app/
                mvn package
                '''
            }
        }
        stage('Test') {
            steps {
                println(' test application')
                sh '''
                cd app/
                mvn test
                '''
            }
        }
        stage('Publish') {
            steps {
                println('publish docker image')
                sh '''
                cd app/
                mvn spring-boot:build-image
                '''
            }
        }
        stage('Deploy'){
            steps {
                println('deploy to kubernetes')
            }
        }
    }
}