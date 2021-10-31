pipeline {
    environment {
        registry = "chungil987/blood_recovery"
        registryCredential = 'docker'
        version = "direct"
        ec2_url = "ec2-18-188-48-137.us-east-2.compute.amazonaws.com"
//         remote = [:]
//         remote.name = "$version"
//         remote.host = "$ec2_url"
//         remote.allowAnyHosts = true
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
        stage('Remote SSH'){
            steps{
                sshagent(credentials : ['ec2-user-credential']){
                    sh 'docker stop myapp'
                    sh 'docker stop mydb'
                    sh 'docker rm mydb'
                    sh 'docker rm myapp'
                    sh 'docker pull $registry:$version'
                    sh 'docker pull $registry:mysql'
                    sh 'docker run -d -p 3306:3306 --name mydb $registry:mysql'
                    sh 'docker run -d -p 8000:8000 --name myapp --add-host=host.docker.internal:host-gateway $registry:$version'
                }
//                 withCredentials([sshUserPrivateKey(credentialsId: 'ec2-user-credential', keyFileVariable: 'identity', passphraseVariable: 'passphrase', usernameVariable: 'userName')]){
//                     remote.user = userName
//                     remote.identityFile = identity
//                     //remote.passphrase = passphrase
//                     sshCommand remote: remote, command: "docker stop myapp"
//                     sshCommand remote: remote, command: "docker stop mydb"
//                     sshCommand remote: remote, command: "docker rm mydb"
//                     sshCommand remote: remote, command: "docker rm myapp"
//                     sshCommand remote: remote, command: "docker pull $registry:$version"
//                     sshCommand remote: remote, command: "docker pull $registry:mysql"
//                     sshCommand remote: remote, command: "docker run -d -p 3306:3306 --name mydb $registry:mysql"
//                     sh "sleep 5"
//                     sshCommand remote: remote, command: "docker run -d -p 8000:8000 --name myapp --add-host=host.docker.internal:host-gateway $registry:$version"
//                 }
            }
        }
    }
}
