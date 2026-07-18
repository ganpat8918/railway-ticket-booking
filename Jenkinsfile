pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Source code is managed by Jenkins from GitHub'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('List Files') {
            steps {
                bat 'dir'
            }
        }
    }
}