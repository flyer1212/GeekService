# istio

kubectl apply -f install/kubernetes/istio-demo.yaml
kubectl apply -f install/kubernetes/zipkin.yaml

# build
 mvn clean package
 docker-compose build 
 

# push
 docker push 10.141.211.160:5000/geek/geek-user-service 
 docker push 10.141.211.160:5000/geek/geek-task-service
 docker push 10.141.211.160:5000/geek/geek-auth-service
 docker push 10.141.211.160:5000/geek/geek-ui-dashboard
 docker push 10.141.211.160:5000/geek/geek-message-service
  
 docker push  liuzozo/geek-ui-dashboard
 
# deployment
 kubectl apply -f <(istioctl kube-inject -f geek-deployment-db.yaml)
 
 
 kubectl apply -f <(istioctl kube-inject -f geek-deployment-service.yaml)
 kubectl apply -f <(istioctl kube-inject -f geek-deployment-ui.yaml)
 kubectl apply -f geek-gateway.yaml

# delete
 kubectl delete -f geek-deployment-db.yaml 
 
 kubectl delete -f geek-deployment-service.yaml 
 kubectl delete -f geek-deployment-ui.yaml 
 kubectl delete -f geek-gateway.yaml
  
kubectl delete -f trainticket-gateway.yaml



docker images|grep geek/geek |awk '{print $3 }'|xargs docker rmi
