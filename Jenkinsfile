pipeline {
    agent any
    stages{
        stage('Build'){
            steps {
                sh '''
                export M3_HOME="C:/Program Files/apache-maven-3.6.0"
                export PATH=$PATH:$M3_HOME"/bin"
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