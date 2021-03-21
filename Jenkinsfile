pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
                stash includes: '**/target/*.jar', name: 'app'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Dockerize') {
            environment { 
                docker_cre = credentials('DOCKER_CREDENTIAL') 
            }
            steps {
                sh 'echo ${docker_cre}'
            }
        }
    }
}
