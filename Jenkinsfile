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
                bat 'mvn clean install -DskipTests'
            }
        }

         stage('Run Selenium Tests & Publish Reports') {
            steps {
                // Run Maven tests
                bat 'mvn test' // Use 'sh' if Linux agent

                // Publish JUnit XML reports (for Jenkins trends)
                junit '**/target/surefire-reports/*.xml'

                // Publish Extent HTML report (human-readable)
                publishHTML(target: [
                    reportName: 'Extent Report',
                    reportDir: 'extent-reports',
                    reportFiles: 'extent.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
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
