pipeline {
    agent any

    tools {
        maven 'Maven 3.9'
        jdk 'JDK 21'
    }

    environment {
        HEADLESS = "true"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/nurularifin83/demoqa-automation-25'
            }
        }

        stage('Build Project') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test -DsuiteXmlFile=sanity'
            }
        }

         stage('Run Selenium Tests') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn test -DsuiteXmlFile=sanity'
                    } else {
                        bat 'mvn test -DsuiteXmlFile=sanity'
                    }
                }
            }

        }

        stage('Archive Test Reports') {
            steps {
                archiveArtifacts artifacts: 'extent-reports/**', fingerprint: true
                junit '**/test-output/testng-results.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline Finished — Cleaning up workspace'
            cleanWs()
        }
    }
}
