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
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Test') {
            steps {
                println(' test application')
                sh 'mvn test'
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