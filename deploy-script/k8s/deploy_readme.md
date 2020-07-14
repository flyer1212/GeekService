

 kubectl create -f  mysql-pv.yaml
 kubectl create -f  mysql-pvc.yaml
 
  kubectl delete -f  mysql-pv.yaml
  kubectl delete -f  mysql-pvc.yaml
  

 kubectl create -f <(istioctl kube-inject -f geek-deployment-db.yaml)
 
 kubectl create -f <(istioctl kube-inject -f geek-deployment-service.yaml)
 kubectl create -f <(istioctl kube-inject -f geek-deployment-ui.yaml)
 kubectl  apply  -f geek-gateway.yaml
 
 
 kubectl delete -f geek-deployment-db.yaml
 
 kubectl delete -f geek-deployment-ui.yaml
 kubectl delete -f geek-deployment-service.yaml
 kubectl delete -f geek-gateway.yaml
 


docker push 10.141.211.160:5000/geek/geek-ui-dashboard
docker push 10.141.211.160:5000/geek/geek-auth-service
docker push 10.141.211.160:5000/geek/geek-user-service
docker push 10.141.211.160:5000/geek/geek-task-service


docker images|grep 10.141.211.160:5000/geek |awk '{print $3 }'|xargs docker rmi




docker-compose  -f docker-compose-jenkins.yaml build
docker-compose  -f docker-compose-jenkins.yaml up
docker-compose -f docker-compose-jenkins.yaml down

chown -R 1000:1000 /root/geek/jenkins_home

 