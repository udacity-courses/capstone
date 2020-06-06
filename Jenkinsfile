pipeline {
    agent any
    environment {
        registry = "anyulled/capstone"
        registryCredential = 'dockerhub'
    }
    stages {
        stage('Build') {
            steps {
                println('compile application')
                sh '''
                cd app/
                 mvn clean package -DskipTests=true
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
                build -t anyulled/capstone:latest .
                '''
            }
        }
        stage('Deploy') {
            steps {
                println('deploy to kubernetes')
            }
        }
    }
}