pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'             // Make sure this matches the name in Jenkins JDK config
        maven 'MAVEN_HOME'          // Make sure Maven is configured in Jenkins
        git 'git'
        allure 'Allure'             // Name must match what you set above
    }

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
        EDGE_DRIVER_PATH = 'C:\\Program Files (x86)\\Microsoft\\Edge'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/sreejagepam/QEML-7.git' // replace with your repo if needed
            }
        }

        stage('Build and Test - API') {
            steps {
                bat 'echo "Running API tests..."'
                bat 'mvn clean test -Dtest="org.example.runners.ApiRunner"'  // Replace with your API test runner class
            }
        }

        stage('Build and Test - UI') {
            steps {
                bat 'echo "Running UI tests..."'
                bat 'mvn clean test -Dtest="org.example.runners.UiRunner"'  // Replace with your UI test runner class
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
