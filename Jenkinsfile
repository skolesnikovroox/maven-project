pipeline {
    agent any
    tools {
            maven 'localMaven'
            jdk 'localJDK'
        }
    parameters {
         string(name: 'tomcat_dev', defaultValue: 'C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: 'C:/Program Files/Apache Software Foundation/Tomcat 9.0 prod/webapps', description: 'Production Server')
    }

    triggers {
         pollSCM('* * * * *')
     }

stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "cp **/target/*.war '${params.tomcat_dev}'"
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        sh "cp **/target/*.war '${params.tomcat_prod}'"
                    }
                }
            }
        }
    }
}