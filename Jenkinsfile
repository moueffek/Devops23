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
        stage('SonarQube Analysis') {
            steps {
                // Ajoutez cette commande pour exécuter l'analyse SonarQube
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.5:9000 -Dsonar.login=admin -Dsonar.password=58109362Ab'
            }
        }
         stage("Nexus"){
           steps{
        sh "mvn deploy -Durl=http://192.168.1.5/repository/maven-releases/ -Drepository.username=admin -Drepository.password=admin -Dmaven.test.skip"
             }
    }
    stage("Docker Build") {
            steps {
                // Build the Docker image
                sh 'docker build -t salmachaieb/alpine1.0.0 .'
                    sh "docker login -u salmachaieb -p Salma9201"
            }
    }
   stage("Docker Run") {
        steps {
                // Run the Docker container in detached mode (-d)
                sh 'docker run -d -p 8089:8089 salmachaieb/alpine1.0.0'
   }
}
   stage("Docker Push") {
        steps {
                // Push the Docker image to a Docker registry (e.g., Docker Hub)
                sh 'docker push salmachaieb/alpine1.0.0'
        }
    
}
}
}
