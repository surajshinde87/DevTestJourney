pipeline {
    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-17'
            args '-v /root/.m2:/root/.m2'
        }
    }

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
                    sh 'mvn clean'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running JUnit + Mockito tests...'
                dir('day9') {
                    sh 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                dir('day9') {
                    sh 'mvn package'
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
