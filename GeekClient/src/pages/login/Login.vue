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
              <el-col :span="24">
                <span>请登录</span>
              </el-col>
            </el-row>

            <el-row :gutter="10">
              <el-col :xs="0" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>

              <el-col :xs="24" :sm="16" :md="12">
                <el-input placeholder="请输入账号" v-model="qqNumber">
                  <template slot="append">@qq.cm</template>
                </el-input>
              </el-col>

              <el-col :xs="0" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>
            </el-row>

            <el-row :gutter="10">
              <el-col :xs="0" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>

              <el-col :xs="24" :sm="16" :md="12">
                <el-input placeholder="请输入密码" v-model="password" clearable></el-input>
              </el-col>

              <el-col :xs="0" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <span>
                  <el-button style="width:180px;" type="primary" @click="loginBtn">提交</el-button>
                </span>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <span>
                  <span style="color: gray">还没账号,</span>
                  <router-link to="/register">立即注册</router-link>
                </span>
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
import axios from "axios";

import AppHeader from "@/pages/header/Header";

import AppFooter from "@/pages/footer/Footer";

export default {
  components: {
    AppHeader,
    AppFooter
  },
  name: "Login",
  data() {
    return {
      qqNumber: "",
      password: "",
      loginEmail:""
    };
  },
  methods: {
    loginBtn() {
      var that = this;

      $.ajax({
        type: "post",
        url: "http://localhost:8083/user/login",
        dataType: "json",
        data: { qqNumber: this.qqNumber, password: this.password },
        success: function(response) {
          console.log(response);
          console.log(response.objectList[0].u_id)
          if (response.statusCode == true) {
            that.$store.commit("changeQqNumber", that.qqNumber);
            that.$store.commit("changePassword", that.password);
            that.$store.commit('changeUuid', response.objectList[0].u_id)
            that.$store.commit('changeLoginOrNot', 'true')
            document.cookie = "token=" + response.msg;
            that.openLoginDialog();
          } else {
            that.openLoginFailed();
          }
        },
        error: function(e) {
          console.log(e)
        }
      });
      // axios.defaults.withCredentials = true
      // axios({
      //   method: "post",
      //   url: "http://localhost:8083/user/login",
      //   data: {
      //     qqNumber: this.qqNumber,
      //     password: this.password
      //   }
      // }).then(function(response) {
      //   console.log(response.data.statusCode);
      //   if (response.data.statusCode == true) {
      //     that.$store.commit("changeQqNumber", that.qqNumber);
      //     that.$store.commit("changePassword", that.password);
      //     document.cookie ="token=" + response.data.msg;
      //     that.openLoginDialog();

      //   } else {
      //     that.openLoginFailed();
      //   }
      // });
    },
    openLoginDialog() {
      console.log("登录成功")
      this.$message({
        showClose: true,
        message: "登录成功！",
        type: "success"
      });
      this.$router.push("/app");
    },
    openLoginFailed() {
      this.$message.error("登录信息有误！");
    }
  },
  mounted() {
    this.qqNumber = this.$store.state.qqNumber;
    this.password = this.$store.state.password;
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
  /* background: #ffffff; */
  /* box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */

  margin-bottom: 15px;
  padding-top: 10px;
  padding: 25px 35px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.grid-content .el-row {
  margin-top: 10px;
}
</style>
