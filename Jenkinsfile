pipeline {

    parameters {
        booleanParam(
        name: 'RUN_REGRESSION',
        defaultValue: false,
        description: 'Run regression tests?'
        )
    }

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

         /* stage('Run Selenium Tests & Publish Reports') {
            steps {
                // Run Maven tests
                bat 'mvn test' // Use 'sh' if Linux agent

                // Publish JUnit XML reports (for Jenkins trends)
                junit '**//* target/surefire-reports *//*.xml'

                // Publish Extent HTML report (human-readable)
                publishHTML(target: [
                    reportName: 'Extent Report',
                    reportDir: 'extent-reports',
                    reportFiles: 'extent.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])

                // Archive HTML report for backup/download
                archiveArtifacts artifacts: 'extent-reports *//**', fingerprint: true
            }
        } */

        stage('Smoke Tests') {
            steps {
                script {
                    echo "🔥 Running Smoke Tests..."
                    def rc = bat(returnStatus: true, script: 'mvn test -DsuiteXmlFile=smoke')
                    if (rc != 0) {
                        error "❌ Smoke tests failed — aborting pipeline!"
                    }
                }
            }
        }

        stage('Sanity Tests') {
            steps {
                script {
                    echo "🧠 Running Sanity Tests..."
                    def rc = bat(returnStatus: true, script: 'mvn test -DsuiteXmlFile=sanity')
                    if (rc != 0) {
                        error "❌ Sanity tests failed — aborting pipeline!"
                    }
                }
            }
        }

        stage('Regression Tests') {
            when {
                expression { return params.RUN_REGRESSION == true }
            }
            steps {
                echo "🧪 Running Regression Tests..."
                bat 'mvn test -DsuiteXmlFile=regression'
            }
        }

        stage('Publish Reports') {
            steps {
                echo "📊 Publishing Test Reports..."
                junit '**/target/surefire-reports/*.xml'
                publishHTML(target: [
                    reportName: 'Extent Report',
                    reportDir: 'extent-reports',
                    reportFiles: 'extent.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
                archiveArtifacts artifacts: 'extent-reports/**', fingerprint: true
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
