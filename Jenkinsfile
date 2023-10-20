pipeline {
  agent any

   tools {
          maven "3.9.4"
      }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/bayembacke221/microservice-docker-cicd-kubernetes.git'
      }
    }

    stage('Build') {
      steps {
        // Build each microservice
        for (def service in ['service-discovery', 'service-admission', 'service-inscription', 'service-examen', 'api-gateway']) {
          bat 'mvn clean package -DskipTests -f microservices/$service'
        }

        // Build the Docker images
        bat 'docker-compose build'
      }
    }

    stage('Test') {
      steps {
        // Run tests for each microservice
        for (def service in ['service-discovery', 'service-admission', 'service-inscription', 'service-examen', 'api-gateway']) {
          bat 'mvn test -f microservices/$service'
        }
      }
    }

    stage('Deploy') {
      steps {
        // Deploy the Docker images to production
        bat 'docker-compose up -d'
      }
    }
  }
}
