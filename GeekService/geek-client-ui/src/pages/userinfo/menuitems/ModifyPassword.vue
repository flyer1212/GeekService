<template>
  <el-row class="user_info_container">
   
   
    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">旧密码：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">新密码：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">再输入一次：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>


     <el-row class="input-line-row">
      <el-button type="primary" size="medium" style="width: 150px;">  提交  </el-button>
    </el-row>

  </el-row>
</template>

<script>
export default {
  name: "ModifyPassword",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      user_name: ""
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.user_info_container {
  padding: 20px 20px;
  color: #727f8e;
}
.input-line-row {
  margin-bottom: 10px;
  line-height: 60px;
}
.input-label {
  text-align: right;
}
</style>
