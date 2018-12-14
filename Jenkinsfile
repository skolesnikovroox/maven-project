pipeline {
    agent any
    tools {
            maven 'localMaven'
            jdk 'localJDK'
        }
    stages{
        stage('Build'){
            steps {
                sh '''
                mvn --version
                mvn clean package
                '''
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
    }
}