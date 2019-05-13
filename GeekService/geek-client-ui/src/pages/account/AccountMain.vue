<template>
  <div id="app">
    <app-header></app-header>
    <el-main>
      <el-row :gutter="10">
        <el-col :xs="0" :sm="1" :md="2" :lg="3">
          <!-- 左边空白部分 -->
          <div class="grid-content"></div>
        </el-col>

        <!-- 中间白色部分 -->
        <el-col :xs="24" :sm="22" :md="20" :lg="18">
          <div class="grid-content bg-purple-middle">
            <el-row>
              <el-col :xs="24" :sm="12">
                <img
                  data-v-cfcb5864
                  src="https://fdugeek.com/media/user_16300180042/icons/1551631562193_16ff6e825fc0b6170c3e27475fd79eee"
                  class="user-icon-large"
                >
              </el-col>
              <el-col :xs="24" :sm="12">
                <p align="left">学号：16300180042</p>
                <p align="left">姓名：李响</p>
                <p align="left">性别：男</p>
                <p align="left">学院：数学科学学院</p>
                <p align="left">专业：信息与计算科学</p>
              </el-col>
            </el-row>
          </div>
        </el-col>

        <el-col :xs="0" :sm="1" :md="2" :lg="3">
          <!-- 右边空白部分 -->
          <div class="grid-content"></div>
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
  name: "AccountMain",
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
  padding-top: 70px;
}
.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.bg-purple-middle {
  background: #ffffff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  height: 600px;
  margin-bottom: 15px;
  padding-top: 10px;
  padding: 25px 35px;
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
</style>