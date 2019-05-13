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
          <div class="grid-content bg-purple-middle">
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
                <p>2019-03-09 12:42</p>
              </el-col>
              <el-col>
                <p>
                  <b>报名理由:</b>
                </p>
              </el-col>
              <el-col>
                <p>熟悉爬虫，写过类似的爬虫代码，和发右键通知的代码</p>
              </el-col>
            </el-row>
          </div>
          <!-- 任务详细信息 -->
          <div class="grid-content bg-purple-middle">
            <el-row>
              <el-col>
                <span style="font-weight: bold; font-size: 18px;">招聘信息的网上抓取</span>
              </el-col>
            </el-row>

            <el-row>
              <el-col class="header" :xs="24">
                <span class="user-info-span">
                  <router-link to="/account_public_detail">
                    <img
                      src="https://fdugeek.com/media/user_16300180042/icons/1551631562193_16ff6e825fc0b6170c3e27475fd79eee"
                      class="user-icon-small"
                    >
                    鲁达师
                    <img src="/static/img/male.png" class="sex-icon">
                  </router-link>
                </span>
                <span class="light-color">
                  |
                  <time>2 天前</time> 发布
                  <span>
                    <el-tag size="small">招募中</el-tag>
                  </span>
                </span>
              </el-col>
            </el-row>

            <el-row>
              <el-col class="task-detail-col" :xs="24">
                <div class="task-detal-item">
                  <span class="light-color">类型:</span>
                  <span>
                    <el-tag size="small">开发团队招募</el-tag>
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
                <div class="task-detal-item">
                  <span class="light-color" style="margin-top: -10px;">
                    <el-button size="small" type="warning">退出</el-button>
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
1、抓取网上的招聘信息，按照规定的类型；
2、按照邮件列表给人员发送邮件。
暂时只有这两个需求。
联系xgoshawk@163.com
                </pre>
              </el-col>
            </el-row>

            <el-row>
              <el-col>报名要求</el-col>
            </el-row>

            <el-row>
              <el-col>奖励</el-col>
            </el-row>

            <el-row>
              <el-col>800</el-col>
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
                <span>6</span>
              </el-col>
            </el-row>
            <el-row>
              <el-col>
                <el-table :data="tableData" style="width: 100%" empty-text="创建者可见">
                  <el-table-column type="index" :index="indexMethod"></el-table-column>
                  <el-table-column prop="date" label="报名时间" width="180"></el-table-column>
                  <el-table-column prop="name" label="姓名"></el-table-column>
                  <el-table-column prop="sex" label="性别"></el-table-column>
                  <el-table-column prop="special" label="专业"></el-table-column>
                
                  <el-table-column prop="phone" label="联系方式"></el-table-column>
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

export default {
  components: {
    AppHeader,
    AppFooter
  },
  name: "TaskDetail",
  data() {
    return {
      showTaskItem: true,
      showAccountInfo: false,
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
          date: "2016-05-02",
          IDcard: "341225199012120111",
          name: "王小虎",
          sex: "男",
          special: "软件工程",
          reason: "上海市普陀区金沙江路 1518 弄",
          phone: 200333
        }
      ]
    };
  },
  methods: {
    indexMethod(index) {
      return index * 2;
    }
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
  padding-top: 60px;
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
