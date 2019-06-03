<template>
  <el-header>
    <el-row style="margin-left: 20px; margin-right: 20px;">
      <el-col class="logo-part" :xs="12" :sm="12">
        <router-link to="/">
          <img style="width:55px; height:55px;" src="/static/img/geek.png">
          <img src="/static/img/geek+.png" style="padding-bottom: 16px; width:50px;">
        </router-link>
      </el-col>

      <el-col class="user-buttons" :xs="12" :sm="12">
        <router-link to="/login" v-if="login_or_not == false">
          <el-button type="primary" size="small">登录</el-button>
        </router-link>

        <router-link to="/register" v-if="login_or_not == false">
          <el-button type="success" size="small">注册</el-button>
        </router-link>

        <router-link to="/app/user_info/user-detail" v-if="login_or_not == true">
          <el-button style="border: none;">
            <span>{{this.$store.state.userName}} ▼</span>
          </el-button>
        </router-link>
      </el-col>
    </el-row>
  </el-header>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      login_or_not: false
    };
  },
  mounted() {
    console.log(this.$store.state.login_in_or_not + "main header mounted-" + this.$store.state.userName )
    if(this.$store.state.login_in_or_not == true){
      this.login_or_not  = true;
    }else{
      this.login_or_not  = false;
    }
  },
  watch: {
    userName: function(newUserName, olgUserName) {
      console.log(this.userName);
    }
  }
};
</script>
 
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.el-header {
  position: fixed;
  background-color: #ffffff;
  color: #333;
  text-align: center;
  width: 100%;
  line-height: 60px;
  z-index: 1;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.logo-part {
  text-align: left;
  padding-left: 20px;
  padding-right: 20px;
  text-decoration: none;
}
.user-buttons {
  text-align: right;
  padding-left: 20px;
  padding-right: 20px;
}
</style>
