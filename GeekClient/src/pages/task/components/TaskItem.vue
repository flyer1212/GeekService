<template>
  <div class="root task-list-element">
    <el-row>
      <el-col class="header" :xs="24">
        <span class="user-info-span">
          <router-link to="/app/account_public_detail">
            <img
              src="https://fdugeek.com/media/user_16300180042/icons/1551631562193_16ff6e825fc0b6170c3e27475fd79eee"
              class="user-icon-small"
            >
            {{taskItem.u_id}}
            <img src="/static/img/male.png" class="sex-icon">
          </router-link>
        </span>
        <span class="light-color">
          |
          <time>2 天前</time> 发布
          <span>
            <el-tag size="small">{{stateOptions[taskItem.taskState].label}}</el-tag>
          </span>
        </span>
      </el-col>
    </el-row>
    <el-row>
      <el-col :xs="24" class="task-link-col">
        <router-link to="/app/task_detail" style="text-decoration: none;">
          <span class="task-link">{{taskItem.taskTitle}}</span>
        </router-link>
      </el-col>
    </el-row>
    <el-row>
      <el-col class="task-detail-col" :xs="24">
        <div class="task-detal-item">
          <span class="light-color">类型:</span>
          <span>
            <el-tag size="small">{{typeOptions[taskItem.taskType].label}}</el-tag>
          </span>
        </div>

        <div class="task-detal-item">
          <span class="light-color">报名截止:</span>
          <span>
            <time class="light-value-color">10</time>
          </span>
          <span>天之内</span>
        </div>

        <div class="task-detal-item">
          <span class="light-color">报名人数:</span>
          <span class="light-value-color">0</span>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Task",
  props: ["taskItem"],
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
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
      ]
    };
  },
  mounted () { 
      console.log(this.taskItem)
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.root:hover {
  background-color: #f9fafc;
}
.root {
  text-align: left;
  border-top: 1px solid #f0f2f5;
  border-bottom: 1px solid #f0f2f5;
  border-radius: 0px;
  padding: 10px;
  margin-bottom: -1px;
}
.header {
  line-height: 35px;
  height: 35px;
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
}
.light-color {
  color: #727f8e;
}
.light-value-color {
  color: #c7c9cc;
}
</style>
