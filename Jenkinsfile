pipeline {
    agent any

    tools {
        maven "3.9.4"
    }

    stages {
        stage('Checkout from GitHub') {
            steps {
                  git branch: 'main', url: 'https://github.com/bayembacke221/microservice-docker-cicd-kubernetes.git'
            }
        }

        stage('Check Maven Version') {
            steps {
                bat 'mvn --version'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
        }

        stage('SonarQube Analysis') {
             steps{
                bat 'mvn sonar:sonar'
             }
        }


    }
}
