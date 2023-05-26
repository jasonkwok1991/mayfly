<template>
  <el-space wrap
            direction="horizontal">

    <el-card>
      <el-progress type="circle"
                   :percentage="50" />
      海安发布 </el-card>
    <el-card>
      <el-progress type="circle"
                   :percentage="50" />
      海安播报 </el-card>
    <el-card>
      <el-progress type="circle"
                   :percentage="50" />
      海安融媒 </el-card>
    <el-card>
      <el-progress type="circle"
                   :percentage="50" />
      我的海安 </el-card>
    <el-card>
      <el-progress type="circle"
                   :percentage="50" />
      悦海安 </el-card>
    <el-card>
      <el-progress type="circle"
                   :percentage="50" />
      海安日报 </el-card>

    <el-button type="primary"
               @click="enterView">立即上传</el-button>
  </el-space>

</template>
<script lang="ts">
import { defineComponent } from 'vue';
export default defineComponent({
    name: 'check',
    methods: {
        enterView() {
            console.log('今日上传');
            this.$router.push({ path: '/upload' });
        },
    },
});
</script>
<style scoped>
.box-card {
    width: 680px;
}
</style>