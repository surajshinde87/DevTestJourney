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
                echo 'Cleaning project...'
                dir('day9') {
                    bat 'mvn clean'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running JUnit + Mockito tests...'
                dir('day9') {
                    bat 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                dir('day9') {
                    bat 'mvn package'
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
