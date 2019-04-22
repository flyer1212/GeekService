<template>
  <el-header>
    <el-row style="margin-left: 20px; margin-right: 20px;">
      <el-col class="logo-part" :xs="12" :sm="12">
        <router-link to="/">
        
            <img style="width:55px; height:55px;" src="/static/img/geek.png">
            <img src="/static/img/geek+.png" style="padding-bottom: 16px;">
         
        </router-link>
      </el-col>
      <el-col class="user-buttons" :xs="12" :sm="12">
        <router-link to="/user_info/user-detail">
          <el-button style="border: none;">
            <span>18212010064 ▼</span>
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
      msg: "Welcome to Your Vue.js App"
    };
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
