<template>
  <el-row class="feedback-container">
    <h3>您的反馈是我们前进的动力！</h3>
    <el-input type="textarea" :rows="11" placeholder="请输入内容" v-model="textarea"></el-input>
    <el-button type="primary" class="feedback-button" size="medium">提交反馈</el-button>
  </el-row>
</template>

<script>
export default {
  name: "FeedBack",
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      textarea: ""
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.feedback-container {
  padding: 20px 20px;
}
.feedback-container h3 {
  float: left;
  padding-bottom: 20px;
}

.feedback-container .feedback-button {
  float: left;
  width: 150px;
  float: left;
  margin-top: 20px;
}
</style>
