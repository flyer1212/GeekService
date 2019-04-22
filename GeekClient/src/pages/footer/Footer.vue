<template>
  <el-footer style="height:40px; line-height:40px;">FDU GEEK Copyright © 2018-2019</el-footer>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.el-footer {
    background-color: #1f2d3d;
    color: #fff;
    text-align: center;
    position: fixed;
    bottom: 0;
    width: 100%;
    z-index: 1;
  }

</style>
