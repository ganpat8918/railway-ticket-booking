pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }

        stage('Verify') {
            steps {
                sh 'ls -la target'
            }
        }
    }
}