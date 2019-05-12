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
          <div class="grid-content bg-purple-middle">
            <el-row>
              <el-col :xs="24" :sm="6">
                <router-link to="/app/user_info/publish-task">
                  <el-button type="primary" class="new-task-button" icon="el-icon-upload2">发布需求</el-button>
                </router-link>
              </el-col>

              <el-col :xs="12" :sm="6">
                <el-select v-model="typeValue" placeholder="全部类型">
                  <el-option
                    v-for="item in typeOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    :disabled="item.disabled"
                  ></el-option>
                </el-select>
              </el-col>

              <el-col :xs="12" :sm="6">
                <el-select v-model="stateValue" placeholder="全部状态">
                  <el-option
                    v-for="item in stateOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                    :disabled="item.disabled"
                  ></el-option>
                </el-select>
              </el-col>

              <el-col :xs="24" :sm="6">
                <el-input v-model="input5" placeholder="搜索" class="input-with-select">
                  <el-button slot="append" icon="el-icon-search"></el-button>
                </el-input>
              </el-col>
            </el-row>

            <div class="task_body">
              <!-- 中间任务部分 -->
              <span v-for="taskItem in taskList">
                <task-item :taskItem="taskItem"></task-item>
              </span>
            </div>
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
import axios from "axios";

import AppHeader from "@/pages/header/Header";

import AppFooter from "@/pages/footer/Footer";
import TaskItem from "@/pages/task/components/TaskItem";

export default {
  components: {
    AppHeader,
    TaskItem,
    AppFooter
  },
  name: "Main",
  data() {
    return {
      showTaskItem: true,
      showAccountInfo: false,
      taskList: [],
      typeOptions: [
        {
          value: "team",
          label: "开发团队招募"
        },
        {
          value: "development",
          label: "开发任务"
        },
        {
          value: "knowledge",
          label: "知识交流"
        },
        {
          value: "homeTeacher",
          label: "家教"
        },
        {
          value: "other",
          label: "其他"
        }
      ],
      stateOptions: [
        {
          value: "all",
          label: "全部状态"
        },
        {
          value: "ing",
          label: "招募中"
        },
        {
          value: "end",
          label: "截止报名"
        }
      ],
      stateValue: "",
      typeValue:"",
      input5: ""
    };
  },
  mounted() {
    console.log("mounted");
    let that = this;
    // token=1qfhiowrs1q7dj54d9lvvdfiodrtnnh5
  //  var token = document.cookie.split("=")[1];

    $.ajax({
      type: "get",
      url: "http://localhost:8083/task/tasks",
      dataType: "json",
      xhrFields: { withCredentials: true },
      success: function(result) {
        console.log(result);
        if (result.statusCode == true) {
          that.taskList = result.objectList;
        }
      }
    });

    // axios.get('http://localhost:8083/task/tasks', {
    //   headers: {
    //     "Content-Type": "application/json;charset=utf-8" , // 这一段必须加,
    //     "Authorization" : "jewjwefewhf"
    //   }
    // }).then(function (response){
    //   console.log(response)
    //   that.taskList = response.data.objectList;
    //   console.log(that.taskList)
    // }).catch(function(error) {
    //   console.log(error)
    // })
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
  height: 600px;
  padding-top: 75px;
  padding-bottom: 40px;
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

  margin-bottom: 15px;
  padding-top: 10px;
  padding: 25px 35px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.el-select .el-input {
  width: 130px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
.new-task-button {
  width: 100%;
}
.task_body {
  margin-top: 20px;
}
</style>
