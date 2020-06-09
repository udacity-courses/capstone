pipeline {
    agent any
    environment {
        registry = "anyulled/capstone"
        registryCredential = 'dockerhub'
    }
    stages {
        stage('Build App') {
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
        stage('Build Image') {
            steps {
                println('publish docker image')
                sh '''
                cd app/
                docker build -t anyulled/capstone:latest .
                '''
            }
        }
        stage('Push Image'){
            steps {
                sh 'docker push anyulled/capstone'
            }
        }
        stage('Deploy - Green Service') {
            steps {
                println('set current kubectl context')
                println('deploy container to green service')
            }
        }
        stage('Blue/Green Deployment') {
            steps {
                input 'Deploy to Blue Service?'
            }
        }
        stage('Deploy - Blue Service') {
            steps {
                println('deploy container to blue service')
            }
        }
    }
}