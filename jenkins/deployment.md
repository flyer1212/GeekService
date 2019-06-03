

#  这个镜像可以docker info   但是不能docker-compose 
 # 可用的
docker pull jenkinsci/blueocean


docker run \
  -d \
  --name jenkins2 \
  -u root \
  -p 49001:8080 \
  -v /var/jenkins_home:/var/jenkins_home \
  -v /var/jenkins_ssh:/root/.ssh \
  -v /var/run/docker.sock:/var/run/docker.sock \
  jenkinsci/blueocean
  
 
 # 需要安装docker-compose , docker exec -it id  /bin/bash
 # 可用的
 curl -L --fail https://github.com/docker/compose/releases/download/1.25.0-rc1/run.sh -o /usr/local/bin/docker-compose
 chmod +x /usr/local/bin/docker-compose
 
 
  curl -L  --fail https://mirror2.shellbot.com/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
 