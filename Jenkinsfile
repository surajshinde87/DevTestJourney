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
                dir('day7') {
                    sh './mvnw clean'
                }
            }
        }

        stage('Test') {
            steps {
                dir('day7') {
                    sh './mvnw test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('day7') {
                    sh './mvnw package'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    dir('day7') {
                        sh '''
                        ./mvnw sonar:sonar \
                        -Dsonar.projectKey=DevTestJourney-Day7 \
                        -Dsonar.projectName=DevTestJourney-Day7 \
                        -Dsonar.host.url=http://sonarqube:9000
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'CI SUCCESS: Build, Tests & SonarQube Analysis passed!'
        }
        failure {
            echo 'CI FAILED: Fix failing build, tests, or quality issues'
        }
    }
}
