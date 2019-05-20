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

            <!-- 分页 -->
            <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page.sync="pages.currentPage"
            :page-size="pages.size"
            layout="total, prev, pager, next"
            :total="pages.itemNum">
          </el-pagination>

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
      currentPage1: 5,
      pages: {
        size: 1,
        itemNum: 1,
        currentPage: 1
      },
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
      typeValue: "",
      input5: ""
    };
  },
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    }
  },
  mounted() {
    console.log("mounted");
    let that = this;

    $.ajax({
      type: "get",
      url: "http://localhost:18002/task",
      contentType: "application/json",
      dataType: "json",
      headers: { Authorization: "Bearer " + that.$store.state.token },
      success: function(result) {
        console.log(result);
        if (result.status == 1) {
          that.taskList = result.data;
          console.log(result.data.length)
          that.pages.itemNum = result.data.length;
        
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
  height: 100%;
  padding-top: 75px;
  padding-bottom: 40px;
  margin-bottom: 40px;
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
