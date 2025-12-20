pipeline {
    agent any

    environment {
        SONAR_PROJECT_KEY  = 'First-project'
        SONAR_PROJECT_NAME = 'First-project'
        DOCKER_IMAGE       = 'surajshinde/day7-app'
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
            post {
                always {
                    junit 'day7/target/surefire-reports/*.xml'
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
                        sh """
                        ./mvnw sonar:sonar \
                        -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                        -Dsonar.projectName=${SONAR_PROJECT_NAME}
                        """
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('day7') {
                    sh 'docker build -t $DOCKER_IMAGE .'
                }
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    docker push $DOCKER_IMAGE
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'CI + Quality Gate + Docker CD SUCCESS'
        }
        failure {
            echo 'PIPELINE FAILED – Fix issues'
        }
    }
}
