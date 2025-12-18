pipeline {
    agent any

    environment {
        // SonarQube project details
        SONAR_PROJECT_KEY = 'First-project'
        SONAR_PROJECT_NAME = 'First-project'
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
                dir('day7') {
                    sh './mvnw clean'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                dir('day7') {
                    sh './mvnw test'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging application...'
                dir('day7') {
                    sh './mvnw package'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube analysis...'
                withSonarQubeEnv('SonarQube') {
                    dir('day7') {
                        sh """
                        ./mvnw sonar:sonar \
                        -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                        -Dsonar.projectName=${SONAR_PROJECT_NAME} \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.host.url=http://sonarqube:9000
                        """
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'CI SUCCESS: Build, Tests & SonarQube Analysis completed!'
        }
        failure {
            echo 'CI FAILED: Fix build, test, or Sonar issues'
        }
    }
}
