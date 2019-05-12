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
          <div class="grid-content bg-purple-middle navbar">
            <el-row>
              <el-col class="card-left" :xs="24" :sm="6">
                <!-- 左边导航菜单 开始 -->
                <el-row>
                  <router-link to="/app/user_info/publish-task">
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-circle-plus-outline"></i>
                        发布需求
                      </span>
                    </button>
                  </router-link>
                </el-row>

                <el-row>
                  <router-link to="/app/task_main">
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-document"></i>
                        需求列表
                      </span>
                    </button>
                  </router-link>
                </el-row>

                <el-row>
                  <router-link to="/app/user_info/user-detail">
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-edit-outline"></i> 用户信息
                      </span>
                    </button>
                  </router-link>
                </el-row>

                <el-row>
                  <router-link to="/app/user_info/modify-password">
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-warning"></i> 修改密码
                      </span>
                    </button>
                  </router-link>
                </el-row>

                <el-row>
                  <router-link to="/app/user_info/publishd-task">
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-date"></i> 我发布的任务
                      </span>
                    </button>
                  </router-link>
                </el-row>

                <el-row>
                  <router-link to="/app/user_info/my-task">
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-document"></i> 我报名的任务
                      </span>
                    </button>
                  </router-link>
                </el-row>

                <el-row>
                  <router-link to="/app/user_info/feed-back">
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-service"></i> 反馈
                      </span>
                    </button>
                  </router-link>
                </el-row>

                <el-row>
                  <a>
                    <button type="button" class="el-button">
                      <span>
                        <i class="el-icon-circle-close-outline"></i> 注销
                      </span>
                    </button>
                  </a>
                </el-row>
                <!-- 左边导航结束 -->
              </el-col>

              <el-col class="card-middle" :xs="24" :sm="1">
                <!-- blank -->
                <div class="grid-content"></div>
              </el-col>

              <el-col :xs="24" :sm="17">
                <el-row class="card-right">
                  <!-- 中间部分 -->
                  <router-view></router-view>
                </el-row>
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
  name: "UserMain",
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
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
  height: 600px;
  padding-top: 75px;
  padding-bottom: 40px;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.bg-purple-middle {
  margin-bottom: 15px;
}
.user-icon-large {
  margin-top: 15px;
  height: 150px;
  width: 150px;
}
p {
  display: block;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}
.card-left {
  background: #ffffff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  padding: 15px;
}
.card-middle {
}
.card-right {
  background: #ffffff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.el-button {
  width: 100%;
  border: none;
  color: #727f8e;
  font-size: 16px;
  font-weight: lighter;
}
</style>