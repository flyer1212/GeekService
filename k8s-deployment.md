# istio
export PATH=$PWD/bin:$PATH

kubectl apply -f install/kubernetes/istio-demo.yaml
kubectl apply -f zipkin.yaml




# build
 mvn clean package
 docker-compose build 
 

# push
 docker push 10.141.211.160:5000/geek/geek-user-service 
 docker push 10.141.211.160:5000/geek/geek-task-service
 docker push 10.141.211.160:5000/geek/geek-auth-service
 docker push 10.141.211.160:5000/geek/geek-ui-dashboard
 
 docker push  liuzozo/geek-ui-dashboard
 
# deployment
先create pv , pv 好了后create pvc
kubectl create -f mysql-pv.yaml

kubectl create -f mysql-pvc.yaml
kubectl get pv,pvc

先删除对pvc的依赖，然后才能删除掉pvc

kubectl delete -f geek-deployment-db.yaml 
kubectl delete -f mysql-pvc.yaml
kubectl delete -f mysql-pv.yaml


 kubectl apply -f <(istioctl kube-inject -f geek-deployment-db.yaml)
 
 kubectl apply -f <(istioctl kube-inject -f geek-deployment-db-prom-exporter.yaml)
 kubectl delete -f geek-deployment-db-prom-exporter.yaml
 ## 查看mysql的metrics
 curl http://10.141.212.139:30749/metrics
 
 
 kubectl apply -f <(istioctl kube-inject -f geek-deployment-service.yaml)
 kubectl apply -f <(istioctl kube-inject -f geek-deployment-ui.yaml)
 kubectl apply -f geek-gateway.yaml



# delete
 kubectl delete -f geek-deployment-db.yaml 
 
 kubectl delete -f geek-deployment-service.yaml 
 kubectl delete -f geek-deployment-ui.yaml 
 kubectl delete -f geek-gateway.yaml
 
 kubectl delete -f trainticket-gateway.yaml
  
  
  ## 注解
  - 先检查nfs服务是否成功启动
    [root@k8smaster ~]# cat /etc/exports
    /nfsdata/pv1 *(rw,no_root_squash,insecure)   # 这样写可能不安全，但可以用
    
    在其它机器读写一下看看是否有问题
    mount -o rw -t nfs 10.141.212.139:/nfsdata/pv1 /nfsdata/pv1
    
  - mysql的数据库会自动创建的
 
  
  [root@k8smaster geek]# kubectl get pods
  NAME                                 READY   STATUS    RESTARTS   AGE
  geek-auth-mongo-7dc697fcd5-hrxsr     2/2     Running   0          3m12s
  geek-auth-service-5dddc5b9b9-lgq6k   2/2     Running   0          25s
  geek-task-mysql-db6f9d867-28h8z      2/2     Running   0          3m12s
  geek-task-service-58c54c7f44-mptsr   2/2     Running   0          25s
  geek-ui-dashboard-6fb46c86f-4lhts    2/2     Running   0          25s
  geek-user-mongo-56d59c9bc9-9dzc9     2/2     Running   0          3m12s
  geek-user-service-7d674c5b54-6q6zf   2/2     Running   0          25s

