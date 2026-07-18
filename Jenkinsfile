pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t railway-ticket-app:latest .'
            }
        }

        stage('Verify Docker Image') {
            steps {
                sh 'docker images | grep railway-ticket-app'
            }
        }
    }

    post {
        success {
            echo 'CI Build Successful!'
        }
        failure {
            echo 'CI Build Failed!'
        }
    }
}