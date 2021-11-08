pipeline {
    environment {
        registry = "chungil987/blood_recovery"
        registryCredential = 'docker'
        version = "mypage"
        service = "Mypage-SVC"
    }
    agent any
    stages {
        stage('Environment') {
            parallel {
                stage('chmod') {
                    steps {
                        sh 'chmod 755 ./gradlew'
                    }
                }
                stage('display') {
                    steps {
                        sh 'ls -la'
                    }
                }
            }
        }
        stage('Build Jar') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker build -t $registry:$version .'
            }
        }
        stage('Deploy docker image') {
            steps {
                withDockerRegistry([ credentialsId: registryCredential, url: "" ]) {
                    sh 'docker push $registry:$version'
                }
            }
        }
        stage('Clean docker image') {
            steps{
                sh "docker rmi $registry:$version"
            }
        }
        stage('Deploy'){
            steps {
                withAWS(credentials: 'sk206-001'){
                    sh "/usr/local/bin/aws ecs update-service --region us-east-2 --cluster BloodRecovery --service $service --force-new-deployment"
                }
            }
        }
    }
}
