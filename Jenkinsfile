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
        stage('Check style') {
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
        }
        stage('Build Image') {
            steps {
                println('publish docker image')
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploy - Kubernetes containers') {
            steps {
                println('deploy to blue container & service')
                withAWS(region:'eu-west-2', credentials:'aws-credentials') {
                    sh 'aws eks update-kubeconfig --name capstonecluster --region eu-west-2'
                    sh 'kubectl apply -f ./k8s/blue-replication-controller.yaml'
                    sh 'kubectl apply -f ./k8s/green-replication-controller.yaml'
                    sh 'kubectl apply -f ./k8s/blue-service.yaml'
                }
            }
        }
        stage('Blue/Green Deployment') {
            steps {
                input 'Deploy to Blue Service?'
            }
        }
        stage('Deploy - Green Service') {
            steps {
                println('deploy container to blue service')
                withAWS(region:'eu-west-2', credentials:'aws-credentials') {
                    sh 'kubectl apply -f ./k8s/blue-service.yaml'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true, fingerprint: true
            junit 'target/surefire-reports/TEST-*.xml'
            sh "docker rmi $registry:latest"
        }
    }
}
