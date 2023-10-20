pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven 3.9.4', type: 'maven'
    }

    stages {
        stage('Checkout from GitHub') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/bayembacke221/microservice-docker-cicd-kubernetes.git']]])
            }
        }

        stage('Check Maven Version') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn --version"
            }
        }

        stage('Build and Test') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install"
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('Your_SonarQube_Server') {
                    sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
                }
            }
        }


    }
}
