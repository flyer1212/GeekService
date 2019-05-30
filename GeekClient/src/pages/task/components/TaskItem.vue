<template>
  <div class="root task-list-element">
    <el-row>
      <el-col class="header" :xs="24">
        <span class="user-info-span">
          <router-link to="/app/account_public_detail">
            <img  src="/static/img/mans.png" class="user-icon-small">
            {{taskItem.userName}}
            <img src="/static/img/male.png" class="sex-icon">
          </router-link>
        </span>
        <span class="light-color">
          |
          <time> {{sumbitTime(taskItem.taskSubmitTime)}}</time> 发布
          <span>
            <el-tag size="small">{{stateOptions[taskItem.taskState -1].label}}</el-tag>
          </span>
        </span>
      </el-col>
    </el-row>
    <el-row>
      <el-col :xs="24" class="task-link-col">
        <router-link :to="{path:'/app/task_detail', query:{taskId:JSON.stringify(taskItem.taskId)}}" style="text-decoration: none;">
          <span class="task-link">{{taskItem.taskTitle}}</span>
        </router-link>
      </el-col>
    </el-row>
    <el-row>
      <el-col class="task-detail-col" :xs="24">
        <div class="task-detal-item">
          <span class="light-color">类型:</span>
          <span>
            <el-tag size="small">{{typeOptions[taskItem.taskType-1].label}}</el-tag>
          </span>
        </div>

        <div class="task-detal-item">
          <span class="light-color">报名截止:</span>
          <span>
            <time class="light-value-color">{{calculateEndDay(taskItem.taskEndTime)}}</time>
          </span>
          <!-- <span>天之内</span> -->
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
        },
        {
          value: "other",
          label: "未知状态"
        }
      ]
    };
  },
  methods: {
    initDateTime() {
      this.taskItem.taskSubmitTime = this.sumbitTime(
        this.taskItem.taskSubmitTime
      );

      this.taskItem.taskEndTime = this.calculateEndDay(
        this.taskItem.taskEndTime
      );
    },
    sumbitTime(submitDate) {
      var submitDay = new Date(submitDate);
      // 2014-06-05  计算发布到现在的时间差
      var times =
        submitDay.getFullYear() +
        "-" +
        (submitDay.getMonth() + 1) +
        "-" +
        submitDay.getDate() +
        " " +
        submitDay.getHours() +
        ":" +
        submitDay.getMinutes() +
        ":" +
        submitDay.getSeconds();
      var nowTime = Date.parse(new Date());
      var submitTime = Date.parse(times);
      var day = parseInt((nowTime - submitTime) / (1000 * 60 * 60 * 24));
      var hours = parseInt((nowTime - submitTime) / (1000 * 60 * 60));
      var minutes = parseInt((nowTime - submitTime) / (1000 * 60));
      console.log(day + "-" + hours + "-" + minutes);
      if (day > 0) {
        return day + "天前";
      } else if (day < 1 && hours > 0) {
        return hours + "小时前";
      } else {
        return minutes + "分钟前";
      }
    },
    calculateEndDay(endDate) {
      var endDay = new Date(endDate);
      var endTimes =
        endDay.getFullYear() +
        "-" +
        (endDay.getMonth() + 1) +
        "-" +
        endDay.getDate() +
        " " +
        endDay.getHours() +
        ":" +
        endDay.getMinutes() +
        ":" +
        endDay.getSeconds();
      var nowTime = Date.parse(new Date());
      var endTimes = Date.parse(endTimes);
      var day = parseInt((endTimes - nowTime) / (1000 * 60 * 60 * 24));
      var hours = parseInt((endTimes - nowTime) / (1000 * 60 * 60));
      var minutes = parseInt((endTimes - nowTime) / (1000 * 60));
      console.log(day + "-" + hours + "-" + minutes);
      if (day > 0) {
        return day + "天之内";
      } else if (day < 1 && hours > 0) {
        return hours + "小时内";
      } else {
        return minutes + "分钟内";
      }
    }
  },
  created() {
    console.log("item created");
  }
  // ,
  // mounted() {
  //   console.log(this.taskItem);
  //   this.initDateTime();
  // }
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
