pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                println('compile application')
            }
        }
        stage('Test') {
            steps {
                println(' test application')
            }
        }
        stage('Publish') {
            steps {
                println('publish docker image')
            }
        }
        stage('Deploy'){
            steps {
                println('deploy to kubernetes')
            }
        }
    }
}