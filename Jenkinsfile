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
        stage("Build Artifact") {
            steps {
                // Build your Maven project, skipping tests
                sh 'mvn package -DskipTests'
            }
        }
    }
}
