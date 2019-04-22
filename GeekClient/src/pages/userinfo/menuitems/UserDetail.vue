<template>
  <el-row class="user_info_container">
    <el-row class="header-row">
      <el-col :xs="12" :sm="13" class="header-img">
        <img
          data-v-798ac6b6
          src="https://fdugeek.com/media/user_18212010064/icons/default_icon"
          class="user-icon"
        >
      </el-col>
      <el-col :xs="12" :sm="11" class="image-upload">
        <el-button type="primary" style="float: left;" size="small" plain>上传图片</el-button>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">姓名：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">学号：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">学院：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">专业：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">性别：</el-col>
      <el-col :span="10">
        <el-radio-group v-model="radio2">
          <el-radio :label="3">保密</el-radio>
          <el-radio :label="6">男</el-radio>
          <el-radio :label="9">女</el-radio>
        </el-radio-group>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">手机：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">微信：</el-col>
      <el-col :span="10">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">QQ：</el-col>
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
  name: "UserDetail",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      user_name: "",
      radio2: 3
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
.header-row el-col {
  height: 100%;
  display: block;
}
.user-icon {
  height: 120px;
  width: 120px;
  border-radius: 50px;
  object-fit: cover;
  text-align: right;
  float: right;
  padding: 25px 40px;
}
.image-upload {
  display: flex;
  align-items: center;
  height: 170px;
  padding: 25px 10px;
}

.input-line-row {
  margin-bottom: 10px;
  line-height: 60px;
}
.input-label {
  text-align: right;
}
</style>
