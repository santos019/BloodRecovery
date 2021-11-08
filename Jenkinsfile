pipeline {
    environment {
        registry = "chungil987/blood_recovery"
        registryCredential = 'docker'
        version = "direct"
        ec2_url = "ec2-18-188-48-137.us-east-2.compute.amazonaws.com"
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
                sh "/usr/local/bin/aws ecs update-service --region us-east-2 --cluster BloodRecovery --service Direct-SVC --force-new-deployment"
            }
        }
//         stage('Remote SSH'){
//             steps{
//                 sshagent(credentials : ['ec2-user-credential']){
//                     sh 'ssh -o StrictHostKeyChecking=no ec2-user@$ec2_url uptime'
//                     sh 'ssh ec2-user@$ec2_url "docker stop myapp"'
//                     sh 'ssh ec2-user@$ec2_url "docker stop mydb"'
//                     sh 'ssh ec2-user@$ec2_url "docker rm mydb"'
//                     sh 'ssh ec2-user@$ec2_url "docker rm myapp"'
//                     sh 'ssh ec2-user@$ec2_url "docker pull $registry:$version"'
//                     sh 'ssh ec2-user@$ec2_url "docker pull $registry:mysql"'
//                     sh 'ssh ec2-user@$ec2_url "docker run -d -p 3306:3306 --name mydb $registry:mysql"'
//                     sh 'ssh ec2-user@$ec2_url "docker run -d -p 8000:8000 --name myapp --add-host=host.docker.internal:host-gateway $registry:$version"'
//                 }
//             }
//         }
    }
}
