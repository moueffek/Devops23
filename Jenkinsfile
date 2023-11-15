pipeline {
    agent any;

    stages {
        stage('Build') {
            steps {
                script {
                    // Checkout the Git repository
                    git branch: 'Salma', credentialsId: 'Github', url: 'https://github.com/moueffek/Devops23.git'
                }
            }
        }
         stage("Nexus"){
           steps{
        sh "mvn deploy
            -Durl=http://192.168.100.21/repository/maven-releases/-Drepository.username=admin -Drepository.password=admin-Dmaven.test.skip"
             }
    }
    }
}
