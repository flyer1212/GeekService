<template>
  <div id="app">
    <app-header></app-header>
    <el-main>
      <el-row :gutter="10">
        <el-col :xs="0" :sm="1" :md="2" :lg="3">
          <!-- 左边空白部分 -->
          <div class="grid-content bg-purple-left"></div>
        </el-col>

        <!-- 中间白色部分 -->
        <el-col :xs="24" :sm="22" :md="20" :lg="18">
          <!-- 用户自己报名与否 -->


          <div class="grid-content bg-purple-middle" v-if="signedTask.userId != null">
            <el-row class="myreport_info">
              <el-col>
                <p>
                  <el-tag>已报名</el-tag>
                </p>
              </el-col>
              <el-col>
                <p>
                  <b>报名时间:</b>
                </p>
              </el-col>
              <el-col>
                <p>{{signedTask.submitTime}}</p>
              </el-col>
              <el-col>
                <p>
                  <b>报名理由:</b>
                </p>
              </el-col>
              <el-col>
                <p>{{signedTask.reason}}</p>
              </el-col>
            </el-row>
          </div>


          <!-- 任务详细信息 -->
          <div class="grid-content bg-purple-middle">
            <el-row>
              <el-col>
                <span style="font-weight: bold; font-size: 18px;">{{taskItem.taskTitle}}</span>
              </el-col>
            </el-row>

            <el-row>
              <el-col class="header" :xs="24">
                <span class="user-info-span">
                  <router-link to="/account_public_detail">
                    <img src="/static/img/mans.png" class="user-icon-small">
                     {{taskItem.userName}}
                    <img src="/static/img/male.png" class="sex-icon">
                  </router-link>
                </span>
                <span class="light-color">
                  |
                  <time>{{beginDate(taskItem.taskSubmitTime)}}</time> 发布
                  <span>
                    <el-tag size="small">{{states(taskItem.taskState-1)}}</el-tag>
                  </span>
                </span>
              </el-col>
            </el-row>

            <el-row>
              <el-col class="task-detail-col" :xs="24">
                <div class="task-detal-item">
                  <span class="light-color">类型:</span>
                  <span>
                    <el-tag size="small">{{types(taskItem.taskType)}}</el-tag>
                  </span>
                </div>

                <div class="task-detal-item">
                  <span class="light-color">报名截止:</span>
                  <span>
                    <time class="light-value-color">{{endDate(taskItem.taskEndTime)}}</time>
                  </span>
                  <span>天之内</span>
                </div>

                <div class="task-detal-item">
                  <span class="light-color">报名人数:</span>
                  <span class="light-value-color">{{signedTask?signedTask.signedPeopleNum:0}}</span>
                </div>
                <div class="task-detal-item">
                  <span class="light-color" style="margin-top: -10px;">
                    <el-button size="small" type="warning" v-if="signedTask.userId == null"  @click="open_sign_dialog(taskItem.taskId)">我要报名</el-button>
                    <el-button size="small" type="warning" v-if="signedTask.userId != null" >退出</el-button>
                  </span>
                </div>
              </el-col>
            </el-row>

            <el-row>
              <el-col>需求描述</el-col>
            </el-row>

            <el-row>
              <el-col>
                <pre>
{{taskItem.taskDescribe}}
                </pre>
              </el-col>
            </el-row>/

            <el-row>
              <el-col>报名要求</el-col>
            </el-row>

           <el-row>
              <el-col>  {{taskItem.taskRequire}}</el-col>
            </el-row>
            
            <el-row>
              <el-col>奖励</el-col>
            </el-row>

            <el-row>
              <el-col>  {{taskItem.reward}} ￥</el-col>
            </el-row>
          </div>
          <!-- 评论区 -->
          <div class="grid-content bg-purple-middle">
            <el-row>
              <el-col>评论</el-col>
            </el-row>
            <el-row>
              <el-col>暂无评论</el-col>
            </el-row>

            <el-row>
              <el-col>
                <el-input type="textarea" :rows="5" placeholder="请输入内容" v-model="textarea"></el-input>
              </el-col>
            </el-row>

            <el-row>
              <el-col>
                <el-button type="primary">发表评论</el-button>
              </el-col>
            </el-row>
          </div>
          <!-- 报名人数区 -->
          <div class="grid-content bg-purple-middle">
            <el-row>
              <el-col>
                报名人数:
                <span>{{signedTask?signedTask.signedPeopleNum:0}}</span>   
              </el-col>
            </el-row>
            <el-row>
              <el-col>
                
                <el-table :data="tableData" style="width: 100%" empty-text="创建者可见">
                  <el-table-column type="index" :index="indexMethod"></el-table-column>
                  <el-table-column prop="taskSubmitTime" label="报名时间" width="180"></el-table-column>
                  <el-table-column prop="userName" label="姓名"></el-table-column>
                  <el-table-column prop="sex" label="性别"></el-table-column>
                  <el-table-column prop="major" label="专业"></el-table-column>
                
                  <el-table-column prop="qqNumber"  label="联系方式"></el-table-column>
                  <el-table-column prop="reason" label="报名理由"></el-table-column>
                </el-table>
              </el-col>
            </el-row>
          </div>
        </el-col>

        <el-col :xs="0" :sm="1" :md="2" :lg="3">
          <!-- 右边空白部分 -->
          <div class="grid-content bg-purple-right"></div>
        </el-col>
      </el-row>
    </el-main>

    <app-footer></app-footer>
  </div>
</template>

<script>
import AppHeader from "@/pages/header/Header";

import AppFooter from "@/pages/footer/Footer";

import { sumbitTime, calculateEndDay, hello } from "@/util/date_utils";
import { typeOptions, stateOptions } from "@/util/consts_utils";
import { requestURLs } from "@/util/uril_utils";

export default {
  components: {
    AppHeader,
    AppFooter
  },
  name: "TaskDetail",
  data() {
    return {
      taskId: JSON.parse(this.$route.query.taskId),
      taskItem: "",
      showTaskItem: true,
      showAccountInfo: false,
      signedTask: "", // 以报名的任务,报完名后立即更新
      options1: [
        {
          value: "选项1",
          label: "黄金糕"
        },
        {
          value: "选项2",
          label: "双皮奶"
        }
      ],
      value1: "",
      input5: "",
      textarea: "",
      tableData: [
        {
          taskSubmitTime: "2016-05-02",
          userName: "王小虎",
          sex: "男",
          major: "软件工程",
          qqNumber: 200333,
          reason: "上海市普陀区金沙江路 1518 弄"
        }
      ]
    };
  },
  methods: {
    indexMethod(index) {
      return index * 2;
    },
    beginDate(date) {
      return sumbitTime(date);
    },
    endDate(date) {
      return calculateEndDay(date);
    },
    types(index) {
      if (Number.isNaN(Number(index))) {
        index = 1;
        console.log(index + "-==");
      }
      return typeOptions[index].label;
    },
    states(index) {
      if (Number.isNaN(Number(index))) {
        index = 1;
      }
      return stateOptions[index].label;
    },
    open_sign_dialog(taskId) {
      this.$prompt("请输入报名理由", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        inputPattern: /\S/,
        inputErrorMessage: "请输入报名理由"
      })
        .then(({ value }) => {
          // 提交报名信息
          this.sumbitSignedReason(taskId, value);
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
    },
    sumbitSignedReason(taskId, reason) {
      let that = this;


      let submitSignedTask = JSON.stringify({
        userId: that.$store.state.userId,
        signedId:that.guuid(),
        taskId: taskId,
        reason: reason,
        submitTime: new Date().getTime()
      });
      console.log(submitSignedTask);

      $.ajax({
        type: "post",
        url: requestURLs[4].value,
        contentType: "application/json",
        dataType: "json",
        headers: { Authorization: "Bearer " + that.$store.state.token },
        withCredentials: true,
        data: submitSignedTask,
        success: function(result) {
          console.log(result);
          if (result.status == 1) {
            that.signedTask = JSON.parse(submitSignedTask);
            that.getSignedUserInfo( that.$store.state.userId,taskId );
            that.$message({
              showClose: true,
              message: "报名成功!",
              type: "success"
            });
          } else {
            that.$message.error("信息有误！");
          }
        },
        error: function(XMLHttpResponse, textStatus, errorThrown) {
          that.signedTask = JSON.parse(submitSignedTask);
          console.log(that.signedTask.reason);
          that.$message.error(textStatus + " : " + XMLHttpResponse.message);
        }
      });
    },
    // 得到当前用户是否报名
    getSignedUserInfo(userId, taskId) {
      // 查询本用户是否报名
      var that = this;
      $.ajax({
        type: "get",
        url: requestURLs[4].value + "/" + userId + "/" + taskId,
        contentType: "application/json",
        dataType: "json",
        headers: { Authorization: "Bearer " + that.$store.state.token },
        success: function(result) {
          console.log(result + " signde info");
          that.signedTask = result.data;
        },
        error: function(e) {
          console.log(e);
          var message = e.statusText;

          if (message.indexOf("error") != -1) {
            alert("Token is expired! please login first!");
          }
        }
      });
    },
    // 得到所有报名的人
    getAllSignedUserInfo(taskId, userId) {
      if (userId != this.$store.state.userId) {
        console.log("you have no premission!");
        this.tableData = [];
      } else {
        console.log("check all signed my task people");

        var that = this;
        $.ajax({
          type: "get",
          url: requestURLs[4].value +"/"+ taskId,
          contentType: "application/json",
          dataType: "json",
          headers: { Authorization: "Bearer " + that.$store.state.token },
          success: function(result) {
            console.log(result + " signde info");
            if (result.status == 1) {
              that.tableData = result.data;
              console.log("3344343")
            } else if (result.status == 0) {
            }
          },
          error: function(e) {
            var message = e.statusText;
            if (message.indexOf("error") != -1) {
              alert("Token is expired! please login first!");
            }
          }
        });
      }
    },
    guuid() {
      return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function(
        c
      ) {
        var r = (Math.random() * 16) | 0,
          v = c == "x" ? r : (r & 0x3) | 0x8;
        return v.toString(16);
      });
    }
  },
  mounted: function() {
    console.log("TaskDetail : " + this.taskId);
    var that = this;
    // 查询任务详情信息
    $.ajax({
      type: "get",
      url: requestURLs[1].value + this.taskId,
      contentType: "application/json",
      dataType: "json",
      headers: { Authorization: "Bearer " + that.$store.state.token },
      success: function(result) {
        console.log(result);
        if (result.status == 1) {
          that.taskItem = result.data[0];

          // 根据taskId 和userid 查询用户是否报名
          that.getSignedUserInfo(
            that.$store.state.userId,
            that.taskItem.taskId
          );
          //根据task 的 task id 和 user id 判断是否加载所有已经报名的人
          that.getAllSignedUserInfo(that.taskItem.taskId, that.taskItem.userId);
        }
      },
      error: function(e) {
        console.log(e);
        var message = e.statusText;
        if (message.indexOf("error") != -1) {
          alert("Token is expired! please login first!");
        }
      }
    });
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#app {
  background-color: #f0f2f5;
}
.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  z-index: 0;
  padding-top: 60px;
  padding-bottom: 80px;
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}

.bg-purple-middle {
  background: #ffffff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-bottom: 20px;
  margin-top: 15px;
  padding-top: 10px;
  padding: 25px 35px;
  text-align: left;
  border-top: 1px solid #f0f2f5;
  border-bottom: 1px solid #f0f2f5;
  border-radius: 0px;
}
.bg-purple-middle .el-row {
  padding-top: 10px;
  padding-bottom: 5px;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.myreport_info p {
  float: left;
  margin-bottom: 15px;
}
.pre {
  display: block;
  font-family: monospace;
  margin: 1em 0px;
  white-space: pre-wrap;
}
.user-info-span {
  height: 35px;
}
.user-info-span a {
  text-decoration: none;
  color: #727f8e;
}
.user-icon-small {
  height: 25px;
  width: 25px;
  border-radius: 2px;
  position: relative;
  top: 7px;
}
.sex-icon {
  position: relative;
  width: 15px;
  top: 2px;
}

.task-link-col {
  height: 60px;
  line-height: 60px;
  text-decoration: none;
  font-size: 18px;
}
.task-link {
  color: #000;
}
.task-detail-col {
  display: flex;
  flex-wrap: wrap;
  font-size: 14px;
}
.task-detal-item {
  margin-right: 20px;
  text-align: center;
  height: 32px;
  line-height: 32px;
}
.light-color {
  color: #727f8e;
}
.light-value-color {
  color: #c7c9cc;
}
</style>
