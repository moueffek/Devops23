pipeline {
    agent any
    environment {
        registry = "benaissa007/detailequipe:tagname" // Specify image name and tag
        dockerImage = ''
    }
    stages {
        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'Medalibenaissa',
                    credentialsId: 'your-credentials-id', // Optional, if you have credentials configured
                    url: 'https://github.com/moueffek/Devops23.git',
                    refspec: '+refs/heads/main:refs/remotes/origin/main' // Specify the refspec
                }
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean install"
            }
        }



        stage('MVN Sonarqube') {
                   steps {
                       sh "mvn sonar:sonar -Dsonar.login=squ_9f8491b197dde8c2eb25c24eef74f45ca667cfb7"
                   }
               }
               stage('Test project with Maven') {
                   steps {
                       sh 'mvn test'
                   }
               }

        stage('Deploy Artifacts') {
            steps {
                sh "mvn deploy"
            }
        }

        stage('Building Image') {
            steps {
                script {
                     // Specify the build context (current workspace)
                    sh 'docker build -t benaissa007/detailequipe:tagname .'
                           }
            }
        }
         stage("PUBLISH TO NEXUS") {
            steps {
             sh 'mvn clean deploy'
             //sh  'mvn clean deploy -Prelease'
            }
        }
          stage('Docker Login and Push') {
                   steps {
                       script {
                               sh 'docker login -u benaissa007 -p elhamma29297529'
                               echo 'login done'
                               sh 'docker push benaissa007/detailequipe:tagname'
                           }
                   }
               }

         stage("DOCKER-COMPOSE UP") {
            steps {
               script{
                   sh "docker compose up -d"
               }
            }
        }


    }
}

