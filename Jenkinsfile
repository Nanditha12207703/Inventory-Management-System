pipeline {
  agent any

  stages {
    stage('Clone') {
      steps {
        git 'https://github.com/Nanditha12207703/Inventory-Management-System.git'
      }
    }

    stage('Build Docker Image') {
      steps {
        script {
          docker.build("inventory-management-system")
        }
      }
    }

    stage('Deploy') {
      steps {
        script {
          // Run the container (you can customize this part)
          docker.run("inventory-management-system")
        }
      }
    }
  }
}
