# Définir la version de Maven
maven_version = '3.9.4'

# Définir les variables d'environnement
DOCKER_HUB_USERNAME = 'bayembacke221'
DOCKER_HUB_PASSWORD = 'Bayembacke221'

# Définir les stages du pipeline
stages {
  stage('Récupérer le code') {
    steps {
      git(url: 'https://github.com/bayembacke221/microservice-docker-cicd-kubernetes.git', branch: 'main')
    }
  }

  stage('Vérifier la version de Maven') {
    steps {
      sh('mvn --version')
    }
  }

  stage('Build du projet') {
    steps {
      sh('mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install')
      sh('mvn sonar:sonar')
    }
  }

  stage('Build image') {
    steps {
      for (def service in ['service-admission', 'service-inscription', 'service-examen']) {
        sh('mvn clean package -DskipTests -f microservice-code/$service')
        sh('docker build -t bayembacke221/$service:latest microservice-code/$service')
      }
    }
  }

  stage('Push image') {
    steps {
      for (def service in ['service-admission', 'service-inscription', 'service-examen']) {
        sh('docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD')
        sh('docker push bayembacke221/$service:latest')
      }
    }
  }
}
