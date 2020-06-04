pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        stage('Build') {
            steps {
                println('compile application')
                sh '''
                mvn -Dmaven.test.failure.ignore=true package
                '''
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
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