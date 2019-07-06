pipeline{
  agent any

  stages{
    stage("Clone"){
      steps{
        echo "=======  Clone code from github   ======="
        sh "docker-compose down"
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
            sh "docker-compose build"
          }
    }
    stage("Push"){
      steps{
        echo "=======  push to docker hub registry   ======="
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
           echo "${dockerHubUser} -p ${dockerHubPassword}"
           sh "docker login -u ${dockerHubUser} -p ${dockerHubPassword}"

        }
      }
    }
    stage("Deploy"){
      steps{
        echo "=======  docker deploy service   ======="
        sh "docker-compose up -d"
     }
    }
    stage("Test"){
      steps{
        echo "=======   test deployed service   ======="
     }
    }
    stage("Stop docker-compose"){
          steps{
            echo "=======   stop docker-compose  ... ======="
            input "确认要停止部署上线吗？"
            sh "docker-compose down"
            echo "======  stop docker-compose success!  ======"
      }
    }
  }
}