pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'             // Make sure this matches the name in Jenkins JDK config
        maven 'MAVEN_HOME'      // Make sure Maven is configured in Jenkins
        git 'git'
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/sreejagepam/QEML-7.git' // replace with your repo if needed
            }
        }

        stage('Build and Test') {
            steps {
                bat 'echo "Running tests..."'
                bat 'mvn clean test'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
