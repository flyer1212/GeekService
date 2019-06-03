pipeline{
  agent any

  stages{
    stage("Clone"){
      steps{
        echo "=======  Clone code from github   ======="
        sh "git version"
         git url: "https://github.com/liuZOZO/GeekService.git"
         script {
              build_tag = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
         }
      }
    }

    stage("Mvn"){
      agent {
            docker {
               image 'maven:3-alpine'
               args '-v /root/.m2:/root/.m2'
            }
      }
      steps{
        echo "======= mvn  clean package ======="
        sh "ls"
        sh "mvn -version"
        sh "mvn clean package"
      }
    }
    stage("Build"){
       steps{
            echo "=======  build docker images   ======="
            echo "images tag is : ${build_tag}"
            sh "ls"
            sh "pwd"
            sh "docker-compose -f /var/jenkins_home/workspace/geek2_master/docker-compose.yaml  build"
          }
    }
    stage("Push"){
      steps{
        echo "=======  push to docker hub registry   ======="
      }
    }
    stage("Deploy"){
      steps{
        echo "=======  docker deploy service   ======="
        sh "docker-compose -f /var/jenkins_home/workspace/geek2_master/docker-compose.yaml up"
     }
    }
    stage("Test"){
      steps{
        echo "=======   test deployed service   ======="
     }
    }
  }
}