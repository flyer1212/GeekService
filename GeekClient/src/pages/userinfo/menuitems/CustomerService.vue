<template>
  <div class="chart-room">
    Chart room
    <el-row class="chart-container">
      <!-- 当前在线用户列表 -->
      <el-col :span="6" class="chart-left">
        online- {{currentSelectedUser}}
        <div
          v-for="(user, index) in users.slice(1)"
          :key="index"
          style=" font-size: 10px; margin-top: 10px;"
        >
          <el-row>
            <div v-on:click="selectUser2SendMSg(user.fromUserId, user.fromUserName)">
              <el-col :span="9">
                <img src="/static/img/autar.png" class="list-user-icon" />
              </el-col>

              <el-col :span="14" style="text-align: left">
                <p>{{user.fromUserName}}</p>
                <p>{{user.message}}</p>
                <p>{{ user.date}}</p>
              </el-col>
            </div>
          </el-row>
        </div>
        <!-- </div> -->
      </el-col>

      <el-col :span="18" class="chart-right">
        <el-col class="chart-body">
          <!-- 聊天记录 -->
          <el-col class="chart-show">
            <div v-for="(msg, index) in msgs" :key="index">
              <div v-if="msg.person=='Admin'" class="left_talk">
                <img src="/static/img/admin.png" class="user-icon-small" />
                <span>{{msg.words}}</span>
              </div>

              <div v-if="msg.person!='Admin'" class="right_talk">
                <span>{{msg.words}}</span>
                <img src="/static/img/autar.png" class="user-icon-small" />
              </div>
            </div>
          </el-col>
        </el-col>

        <el-col class="chart-input">
          <!-- 图标，文件，语言 -->
          <el-col style="padding-top:5px;padding-bottom:5px;">
            <el-col :span="3">
              <i class="el-icon-picture-outline-round"></i>
              <i class="el-icon-folder-opened"></i>
              <i class="el-icon-microphone"></i>
            </el-col>
            <el-col :span="18">-</el-col>
            <el-col :span="3">
              <i class="el-icon-place"></i>
            </el-col>
          </el-col>

          <!-- 输入框 -->
          <el-col :span="20">
            <!-- <el-input
              type="textarea"
              :rows="3"
              placeholder="请输入内容"
              border="false"
              style="border: none;outline: none;"
              v-model="textarea"
            ></el-input>-->
            <textarea
              id="dope"
              v-model="input_msg"
              style="width: 99%;height: 75px; border: none;outline: none;"
              name
              rows
              cols
            ></textarea>
          </el-col>

          <!-- 发送按钮 -->
          <el-col :span="4">
            <el-button
              type="primary"
              size="mini"
              style="float: bottom;  width: 70px;"
              @click="sendMessage"
            >
              <i class="el-icon-edit"></i>发送
            </el-button>
          </el-col>
        </el-col>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import { requestURLs } from "@/util/uril_utils";

export default {
  name: "CustomerService",
  data() {
    return {
      path: requestURLs[5].value,
      socket: "",
      input_msg: "",
      msgs: [
        { person: "Admin", words: "hi, 很高兴为您服务" }
        // { person: "Customer", words: "hello, 谢谢亲!33332" }
      ],
      // admin 左侧的用户列表
      // fromUserId, fromUserName, message, date
      users: [],
      // 当前选择的id, 默认是都向admin 发
      // 只有admin 选择左边用户列表，才会变成选择的用户
      currentSelectedId: "4d2a46c7-71c4-4cf1-b5bb-b68406d9da6f",
      currentSelectedUser: "user123"
    };
  },
  mounted() {
    // 初始化
    this.init();
  },
  methods: {
    sendMessage: function() {
      console.log("send message");
      this.send();
    },
    init: function() {
      if (typeof WebSocket === "undefined") {
        alert("您的浏览器不支持socket");
      } else {
        // 实例化socket
        this.socket = new WebSocket(this.path);
        // 监听socket连接
        this.socket.onopen = this.open;
        // 监听socket错误信息
        this.socket.onerror = this.error;
        // 监听socket消息
        this.socket.onmessage = this.getMessage;
      }
    },
    open: function() {
      console.log("socket连接成功");
      // 连接成功后，把自己的id 发送过去,和channel 绑定
      var userId = this.$store.state.userId;
      console.log(userId);
      // 注册自己
      if (userId != "") {
        let msg2Regist = JSON.stringify({
          commandType: 1,
          fromUserId: userId,
          fromUserName: this.$store.state.userName,
          toUserId: "",
          toUserName: "",
          message: "regist",
          date: new Date().getTime()
        });
        // 注册channel 长连接
        this.socket.send(msg2Regist);
      }
    },
    error: function() {
      console.log("连接错误");
    },
    getMessage: function(msg) {
      console.log(msg.data);
      var receiveMsg = JSON.parse(msg.data);

      // Admin 指left   Customer 指right
      // 收到别人的消息，肯定显示在左边
      this.msgs.push({ person: "Admin", words: receiveMsg.message });

      if (this.$store.state.userName == "user123") {
        // 在这里接收一下发给admin的fromUserId, fromUserName, message, date
        // 如果当前用户是admin 才接收，其他用户不接收

        // 先找一下user 列表里面是否有, 如果有的话,直接更新一下message, 没有再添加
        var myDate = new Date();
        var timeNow =
          myDate.getHours() +
          ":" +
          this.conver(myDate.getMinutes()) +
          ":" +
          this.conver(myDate.getSeconds());

        var hasTag = false;
        for (var i = 0; i < this.users.length; i++) {
          if (this.users[i].fromUserId == receiveMsg.fromUserId) {
            this.users[i].message = receiveMsg.message;
            this.users[i].date = timeNow;
            hasTag = true;
            break;
          }
        }

        // 如果没有, 就加到列表里面
        if (!hasTag) {
          this.users.push({
            fromUserId: receiveMsg.fromUserId,
            fromUserName: receiveMsg.fromUserName,
            message: receiveMsg.message,
            date: timeNow
          });
        }
      }
      // }
    },
    send: function() {
      // user123 的admin的 4d2a46c7-71c4-4cf1-b5bb-b68406d9da6f
      // 用户12 的 06dcc9a9-a38a-4b6f-9dec-b70c0ab92050

      if (this.currentSelectedId != this.$store.state.userId) {
        this.msgs.push({ person: "Customer", words: this.input_msg });

        // 向admin 发送消息的,暂时把admin 先写死
        let msg2Admin = JSON.stringify({
          commandType: 2,
          fromUserId: this.$store.state.userId,
          fromUserName: this.$store.state.userName,
          toUserId: this.currentSelectedId,
          toUserName: this.currentSelectedName,
          message: this.input_msg,
          date: new Date().getTime()
        });
        // 发送出去
        this.socket.send(msg2Admin);
      } else {
        alert("Please select a client!");
      }
    },
    selectUser2SendMSg: function(userId, fromUserName) {
      console.log(fromUserName);
      this.currentSelectedId = userId;
      this.currentSelectedUser = fromUserName;
      this.msgs = [{ person: "Admin", words: "hi, 很高兴为您服务" }];
    },
    close: function() {
      console.log("socket已经关闭");
    },
    conver: function(s) {
      return s < 10 ? "0" + s : s;
    }
  },
  destroyed() {
    // 销毁监听
    this.socket.onclose = this.close;
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.chart-room {
  padding: 20px 20px;
}

.chart-container {
  min-height: 500px;
}
.chart-left {
  min-height: 450px;
  background: #dcdfe6;
}

.chart-right {
  border: 1px solid #dcdfe6;
}

.chart-body {
  /* 聊天内容 */
  min-height: 350px;
}

.chart-input {
  border: 1px solid #dcdfe6;
  padding-left: 15px;
  padding-bottom: 15px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.chart-show {
  height: 300px;
  overflow-y: auto;
}
.left_talk {
  margin: 10px;
  text-align: left;
}
.left_talk span {
  display: inline-block;
  background: #0181cc;
  border-radius: 10px;
  color: #fff;
  padding: 5px 10px;
  vertical-align: middle;
}

.right_talk {
  margin: 10px;
  text-align: right;
}

.right_talk span {
  display: inline-block;
  background: #ef8201;
  border-radius: 10px;
  color: #fff;
  padding: 5px 10px;
  vertical-align: middle;
  word-wrap: break-word;
  white-space: normal;
}
.user-icon-small {
  vertical-align: middle;
}
.list-user-icon {
  height: 50px;
  width: 50px;
}
</style>
