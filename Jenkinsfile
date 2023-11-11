pipeline {
    agent any
    environment {
        registry = "benaissa007/detailequipe:latest" // Specify image name and tag
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
                       sh "mvn sonar:sonar -Dsonar.login=squ_1e2609a889ea41e2069ed871bbf291473a8a7af4"
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
                    dockerImage = docker.build(registry, ".")
                }
            }
        }
         stage("PUBLISH TO NEXUS") {
            steps {
            echo"test Nexus" //  sh 'mvn clean deploy'
             //sh  'mvn clean deploy -Prelease'
            }
        }
        stage('Pushing Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        dockerImage.push()
                    }
                }
            }
        }
         stage("DOCKER-COMPOSE UP") {
            steps {
               script{
                   sh "docker-compose up -d"
               }
            }
        }
        //stage("kube deploy") {
          //  steps {
            //   script{
              //    echo("ssh to k8s node && kubectl apply -f")
               //}
            //}
        //}
    }
}