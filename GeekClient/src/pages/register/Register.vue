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
                <span>请通过邮箱进行注册</span>
              </el-col>
            </el-row>

            <el-row :gutter="10">
              <el-col :xs="1" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>

              <el-col :xs="22" :sm="16" :md="12">
                <el-input placeholder="请输入邮箱" v-model="qqNumber">
                  <template slot="append">@qq.cm</template>
                </el-input>
              </el-col>

              <el-col :xs="1" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>
            </el-row>

            <el-row :gutter="10">
              <el-col :xs="1" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>

              <el-col :xs="22" :sm="16" :md="12">
                <el-input placeholder="请输入密码" v-model="password" clearable></el-input>
              </el-col>

              <el-col :xs="1" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>
            </el-row>

            <el-row :gutter="10">
              <el-col :xs="1" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>

              <el-col :xs="22" :sm="16" :md="12">
                <el-input placeholder="重复输入密码" v-model="repassword" clearable></el-input>
              </el-col>

              <el-col :xs="1" :sm="4" :md="6">
                <span style="visibility:hidden;">empty</span>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <span>
                  <el-button style="width:180px;" type="primary" @click="registerToServer">提交</el-button>
                </span>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <span>
                  <span style="color: gray">已有账号，</span>
                  <router-link to="/login">立即登录</router-link>
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

import { requestURLs } from "@/util/uril_utils";

export default {
  components: {
    AppHeader,
    AppFooter
  },
  name: "Register",
  data() {
    return {
      qqNumber: "",
      password: "",
      repassword: ""
    };
  },
  methods: {
    registerToServer() {
      console.log(
        this.qqNumber + " --- " + this.password + "---" + this.repassword
      );
      var that = this;

      axios({
        method: "post",
        url: requestURLs[3].value,
        data: {
          qqNumber: this.qqNumber,
          password: this.password
        }
      }).then(function(response) {
        console.log(response.data.statusCode);
        if (response.data.statusCode == true) {
          that.$store.commit('changeQqNumber', that.qqNumber)
          that.$store.commit('changePassword', that.password)
          that.openLoginDialog();
        } else {
          that.openRegisterFailed();
        }
      });

      
    },
    openLoginDialog() {
      this.$confirm("注册成功", "提示", {
        confirmButtonText: "去登录",
        cancelButtonText: "关闭",
        type: "warning",
        center: true
      })
        .then(() => {
          this.$router.push("/login");
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消"
          });
        });
    },
    openRegisterFailed() {
      this.$message.error("注册有误！");
    }
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
  /* background: #ffffff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); */

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
