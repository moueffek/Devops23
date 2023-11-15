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
    }
}
