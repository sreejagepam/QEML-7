pipeline {
    agent any

    tools {
        jdk 'jdk-17'             // Make sure this matches the name in Jenkins JDK config
        maven 'maven-3.9.4'      // Make sure Maven is configured in Jenkins
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sreejagepam/QEML-7.git' // replace with your repo if needed
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
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
