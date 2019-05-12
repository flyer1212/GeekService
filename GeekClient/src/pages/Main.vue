<template>
  <div id="app">
    <app-header></app-header>
    <el-main>
      <div class="main_page">
        <el-row :gutter="10">
          <el-col :span="24">
            <span style="color: #ffffff; font-size:40px;display:block; margin-top: 50px;">极客网</span>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="24">
            <span
              style="color: #ffffff; font-size:20px;display:block; margin-top: 20px;"
            >有编程需求? 找中国极客!</span>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="24">
            <span style="color: #ffffff; font-size:20px;display:block; margin-top: 40px;">
              <router-link to="/app/user_info/publish-task">
                <el-button type="primary" style="width: 200px;">发布需求</el-button>
              </router-link>
            </span>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="24">
            <span style="color: #ffffff; font-size:20px;display:block; margin-top: 20px;">
              <router-link to="/app/task_main">
                <el-button style="background-color: transparent; width: 200px;" type="primary">需求列表</el-button>
              </router-link>
            </span>
          </el-col>
        </el-row>

        <div class="bottom-content">
          <el-row :gutter="10">
            <el-col :span="12">
              <el-row>
                <el-col :span="8">
                  <div style="visibility:hidden;">sdds</div>
                </el-col>
                <el-col :span="12">
                  <div class="need_item">
                    <span style=" font-size:20px;display:block;   ">
                      <b>如果你有需求：</b>
                    </span>
                    <span>
                      - 有好点子，
                      <b>就差一个程序员了</b>
                    </span>
                    <span>
                      - 想通过，
                      <b>爬虫</b>
                      获取数据
                    </span>
                    <span>
                      - 需要进行繁杂的
                      <b>数据分析、可视化</b>
                    </span>
                    <span>
                      - 想
                      <b>学习编程技巧</b>
                    </span>
                    
                    <span>
                      - 需要
                      <b>人工智能</b>帮你做点什么
                    </span>
                    
                    <span>
                      - 想上
                      <b>Google</b>,但缺乏工具
                    </span>
                    
                    <span>
                      - 电脑坏了,
                      <b>但不会修</b>
                    </span>
                    <span>
                      <router-link to="/app/user_info/publish-task">
                        <el-button style="margin-top: 15px; ">立即发布需求</el-button>
                      </router-link>
                    </span>
                  </div>
                </el-col>
                <el-col :span="5">
                  <div style="visibility:hidden;">sdds</div>
                </el-col>
              </el-row>
            </el-col>
            <el-col :span="12">
              <el-row>
                <el-col :span="8">
                  <div style="visibility:hidden;">sdds</div>
                </el-col>
                <el-col :span="12">
                  <div class="need_item">
                    <span style=" font-size:20px;display:block;   ">
                      <b>如果你会编程:</b>
                    </span>
                    <span>
                      - 有好点子，
                      <b>就差一个程序员了</b>
                    </span>
                    <span>
                      - 想通过，
                      <b>爬虫</b>
                      获取数据
                    </span>
                    <span>
                      - 需要进行繁杂的
                      <b>数据分析、可视化</b>
                    </span>
                    <span>
                      - 想
                      <b>学习编程技巧</b>
                    </span>
                    
                    <span>
                      - 需要
                      <b>人工智能</b>帮你做点什么
                    </span>
                    
                    <span>
                      - 想上
                      <b>Google</b>,但缺乏工具
                    </span>
                    
                    <span>
                      - 电脑坏了,
                      <b>但不会修</b>
                    </span>
                    <span>
                      <router-link to="/app/task_main">
                        <el-button style="margin-top: 15px;  ">查看需求列表</el-button>
                      </router-link>
                    </span>
                  </div>
                </el-col>
                <el-col :span="5">
                  <div style="visibility:hidden;">sdds</div>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </div>
      </div>
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
  name: "Main",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      loginEmail:""
    };
  },
  mounted() {
    console.log("mounted");
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
  padding-top: 60px;
  background: url("/static/img/es6daily.jpg");
  z-index: 0;
  height: 100%;
  width: 100%;
  padding: 0px;
}
.main_page {
  margin-top: 25px;
  width: 100%;
  height: 100%;
  position: relative;
  float: left;
}

.el-col {
  border-radius: 4px;
}

.bottom-content {
  background: #ffffff;
  position: absolute;
  bottom: 0;
  padding-top: 5px;
  padding-bottom: 10px;
  width: 100%;
  z-index: 0;
}
.need_item {
  font-size: 15px;
  margin-top: 20px;
  font-family: monospace;
}
.need_item span {
  margin-bottom: 5px;
  display: block;
  text-align: left;
}
</style>