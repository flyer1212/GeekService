# GeekService
Geek client ui and Server


# 部署方式
> 提供 docker,docker-compose k8s

> 前端修改，需要先num run build ， 复制到geek-ui-dashboard ， 以免上传服务器太大了

> 开发一定要先线下验证，然后再部署上线
  
> 线下连接数据库，要单独部署数据库，

> ts-ui-dashboard 需要更改utils 里面的http路径

> docker run -p 8080:8080 -p 50000:50000  -v /home/jenkins-home-docker:/var/jenkins_home  jenkins/jenkins:lts

> docker images|grep geek |awk '{print $3 }'|xargs docker rmi

# 项目运行结果
![dsds](login.png)

![dsds](regist.png)

![dsds](sigened_user.png)

![dsds](register_success.png)


![dsds](task.png)

![dsds](task_detal.png)

![dsds](user_info.png)

![dsds](singed.png)

![dsds](detail_main.png)

![dsds](feed_back.png)


![dsds](talk.png)


![dsds](client_talk.png)

