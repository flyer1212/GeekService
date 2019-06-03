pipeline{
  agent any

  stages{
    stage("Clone"){
      steps{
        echo "=======  Clone code from github   ======="
        sh "git version"
         git url: "https://github.com/cnych/jenkins-demo.git"
         script {
              build_tag = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
         }
      }
    }

    stage("MVN"){
      agent {
            docker {
               image 'maven:3-alpine'
               args '-v /root/.m2:/root/.m2'
            }
      }
      steps{
        echo "======= mvn  clean package ======="
        sh "mvn -version"
      }
    }
    stage("Build"){
       steps{
            echo "=======  build docker images   ======="
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

     }
    }
    stage("Test"){
      steps{
        echo "=======   test deployed service   ======="
     }
    }
  }
}