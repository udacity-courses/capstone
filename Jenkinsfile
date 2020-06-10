pipeline {
    agent any
    environment {
        registry = 'anyulled/capstone'
        registryCredential = 'dockerhub'
    }
    stages {
        stage('Build App') {
            steps {
                println('compile application')
                sh '''
                 mvn clean package -DskipTests=true
                '''
            }
        }
        stage('Test') {
            steps {
                println(' test application')
                sh '''
                mvn test
                '''
            }
        }
        stage('Build Image') {
            steps {
                println('publish docker image')
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                //sh 'docker push anyulled/capstone'
                }
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
        stage('Remove Unused docker image') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}
