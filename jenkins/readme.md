#  这个可以用的docker-compose 和 docker
#  加 var/run/docker.sock  就可以用docker

docker run --name jenkins-dind2 --privileged  -p 8080:8080 \
-v /var/jenkins_home:/var/lib/jenkins \
killercentury/jenkins-dind


docker run --name jenkins-dind2 --privileged -d -p 8080:8080 \
-v /var/jenkins_home:/var/lib/jenkins \
-v /var/run/docker.sock:/var/run/docker.sock \
jenkins:myjenkins

 




docker run --name jenkins-dind3 --privileged -d -p 8081:8080 \
-v /var/jenkins_home:/var/lib/jenkins \
killercentury/jenkins-dind


docker run --name jenkins-dind3 --privileged  -p 8083:8080 -v /var/jenkins_home:/var/lib/jenkins killercentury/jenkins-dind



docker run --name jenkins-dind --privileged -d -p 8080:8080 -v /var/jenkins_home:/var/lib/jenkins -v /var/run/docker.sock:/var/run/docker.sock killercentury/jenkins-dind


curl -L https://github.com/docker/compose/releases/download/1.3.3/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose