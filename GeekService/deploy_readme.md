

 kubectl create -f <(istioctl kube-inject -f geek-deployment-db.yaml)
 kubectl create -f <(istioctl kube-inject -f geek-deployment-service.yaml)
 kubectl create -f <(istioctl kube-inject -f geek-deployment-ui.yaml)
 kubectl  apply  -f geek-gateway.yaml
 
 

 kubectl delete -f geek-deployment-ui.yaml
 kubectl delete -f geek-deployment-service.yaml
 kubectl delete -f geek-deployment-db.yaml
 kubectl delete -f geek-gateway.yaml
 


docker push 10.141.211.160:5000/geek/geek-ui-dashboard
docker push 10.141.211.160:5000/geek/geek-auth-service
docker push 10.141.211.160:5000/geek/geek-user-service
docker push 10.141.211.160:5000/geek/geek-task-service
