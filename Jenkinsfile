pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                dir('day9') {
                    sh './mvnw clean'
                }
            }
        }

        stage('Test') {
            steps {
                dir('day9') {
                    sh './mvnw test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('day9') {
                    sh './mvnw package'
                }
            }
        }
    }

    post {
        success {
            echo 'CI SUCCESS: All tests passed!'
        }
        failure {
            echo 'CI FAILED: Fix failing tests'
        }
    }
}
