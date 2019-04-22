<template>
  <el-row class="user_info_container">
    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">标题：</el-col>
      <el-col :span="14">
        <el-input v-model="user_name" placeholder="请输入内容"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">分类：</el-col>
      <el-col :span="10">
        <el-select style="float:left;" v-model="value" placeholder="请选择需要的类型">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">报名截止：</el-col>
      <el-col :span="10">
        <el-date-picker style="float:left;" v-model="dateUntil" type="date" placeholder="选择日期"></el-date-picker>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">需求描述：</el-col>
      <el-col :span="14">
        <el-input type="textarea" :rows="8" placeholder="请输入内容" v-model="require_describe"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">报名要求：</el-col>
      <el-col :span="14">
        <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="require_describe"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label">奖励：</el-col>
      <el-col :span="14">
        <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="require_describe"></el-input>
      </el-col>
    </el-row>

    <el-row class="input-line-row">
      <el-col :span="7" class="input-label"><lable style="visibility:hidden;">-</lable></el-col>
      <el-col :span="10">
        <el-button type="primary" size="medium" style="float: left; margin-top: 5px; width: 150px;">提交</el-button>
      </el-col>
    </el-row>


  </el-row>
</template>

<script>
export default {
  name: "PublishTask",
  data() {
    return {
      options: [
        {
          value: "选项1",
          label: "全部类型"
        },
        {
          value: "选项2",
          label: "开发团队招募"
        },
        {
          value: "选项3",
          label: "开发任务"
        },
        {
          value: "选项4",
          label: "知识交流"
        },
        {
          value: "选项5",
          label: "家教"
        }
      ],
      value: "",
      dateUntil: "",
      require_describe: ""
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
