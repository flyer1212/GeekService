# 采用docker-compose 部署的方式

### mysql 注意事项
MYSQL_DATABASE  需要和服务里面的数据库名字对应
MYSQL_ROOT_PASSWORD  需要和服务里面的用户名密码对应
task-mysql 绑定的vlume 在变更上面属性的时候，需要先清空，否则是不会创建对应的数据库的


### ui的变更
需要单独更改代码后，复制dist 里面的文件替换 geek-ui-dashboard

### docker-compose-jenkins
> 以下可以自己基于 jenkins/jenkins:lts 打出新镜像

- 挂载docker 目录是没有用的，需要在里面也安装一个docker
- 不过，docker images 看到的是宿主机的
curl -sSL https://get.docker.com/ | sh

- 需要安装docker-images
curl -L https://github.com/docker/compose/releases/download/1.21.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

chmod +x /usr/local/bin/docker-compose

ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose

```$xslt
root@6cb2979e037f:/# docker-compose --version
docker-compose version 1.21.0, build 5920eb0
```

### jenkins 的使用
安装 github 
安装 blue ocean
