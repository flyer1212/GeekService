<template>
  <div class="chart-room">
    Chart room
    <el-row class="chart-container">
      <el-col :span="5" class="chart-left">people list</el-col>
      <el-col :span="19" class="chart-right">
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
export default {
  name: "CustomerService",
  data() {
    return {
      path: "ws://127.0.0.1:8000/ws",
      socket: "",
      input_msg: "",
      msgs: [
        { person: "Admin", words: "hi, 很高兴为您服务" },
        { person: "Customer", words: "hello, 谢谢亲!33332" }
      ]
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
        this.socket.send(
          "{'commandType': '1','fromUserId':'" +
            userId +
            "','fromUserName':'I am tom'}"
        );
      }
    },
    error: function() {
      console.log("连接错误");
    },
    getMessage: function(msg) {
      console.log(msg.data);
      var receiveMsg =  JSON.parse(msg.data)
      console.log(receiveMsg.status)
      this.msgs.push({ person: "Admin", words: receiveMsg.message });
 
    },
    send: function() {
      // user123 的admin的 4d2a46c7-71c4-4cf1-b5bb-b68406d9da6f
      // 用户12 的 06dcc9a9-a38a-4b6f-9dec-b70c0ab92050
      this.msgs.push({ person: "Customer", words: this.input_msg });
      var msg =
        "{'toUserId':'4d2a46c7-71c4-4cf1-b5bb-b68406d9da6f','message':' " +
        this.input_msg +
        "'}";
      this.socket.send(msg);
    },
    close: function() {
      console.log("socket已经关闭");
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
</style>