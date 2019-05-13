<template>
  <el-row class="user_info_container">
    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">标题：</el-col>
      <el-col :span="14">
        <el-input v-model="taskTitle" placeholder="请输入标题"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">分类：</el-col>
      <el-col :span="10">
        <el-select style="float:left;" v-model="taskType" placeholder="请选择需要的类型">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">报名截止：</el-col>
      <el-col :span="10">
        <el-date-picker style="float:left;" v-model="taskEndTime" type="date" placeholder="选择日期"></el-date-picker>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">需求描述：</el-col>
      <el-col :span="14">
        <el-input type="textarea" :rows="8" placeholder="请输入内容" v-model="taskDescribe"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">报名要求：</el-col>
      <el-col :span="14">
        <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="taskRequire"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">奖励：</el-col>
      <el-col :span="14">
        <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="reward"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">
        <p style="visibility:hidden;">-</p>
      </el-col>
      <el-col :span="10">
        <el-button
          type="primary"
          size="medium"
          style="float: left; margin-top: 5px; width: 150px;"
          @click="submitTaskToServer"
        >提交</el-button>
      </el-col>
    </el-row>
  </el-row>
</template>

<script>
import axios from "axios";

export default {
  name: "PublishTask",
  data() {
    return {
      options: [
        {
          name: "1",
          value: "1",
          label: "开发团队招募"
        },
        {
          name: "1",
          value: "2",
          label: "开发任务"
        },
        {
          name: "1",
          value: "3",
          label: "知识交流"
        },
        {
          name: "1",
          value: "4",
          label: "家教"
        },
        {
          name: "1",
          value: "5",
          label: "其他"
        }
      ],
      value: "",

      taskId: "",
      userId: "",
      taskTitle: "",
      taskType: "",
      taskRequire: "",
      taskDescribe: "",
      reward: "",
      taskState: "",
      taskEndTime: "",
      taskSubmitTime: ""
    };
  },
  methods: {
    submitTaskToServer() {
      // var token = document.cookie.split("=")[1];

      console.log("click to submit");
      let that = this;
      console.log(that.guuid());
      let newTask = JSON.stringify({
        taskId: that.guuid(),
        userId: that.$store.state.userId,
        taskTitle: this.taskTitle,
        taskType: this.taskType,
        taskRequire: this.taskRequire,
        taskDescribe: this.taskDescribe,
        reward: this.reward,
        taskState: 0,
        taskEndTime: this.taskEndTime,
        taskSubmitTime: new Date().getTime()
      });
      console.log(newTask);

      $.ajax({
        type: "post",
        url: "http://localhost:18002/task",
        contentType: "application/json",
        dataType: "json",
        data: newTask,
        success: function(result) {
          console.log(result);
          if (result.status == 1) {
            that.$message({
              showClose: true,
              message: "发布消息成功!",
              type: "success"
            });
          } else {
            that.$message.error("信息有误！");
          }
        }
      });
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
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.user_info_container {
  padding: 20px 20px;
  color: #727f8e;
}

.input-line-row {
  margin-bottom: 10px;
  line-height: 60px;
}
.input-label {
  text-align: right;
}
</style>
