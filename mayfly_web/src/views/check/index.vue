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
               @click="searchInfo">获取数据</el-button>
    <el-button type="primary"
               @click="enterView">立即上传</el-button>
  </el-space>

</template>
<script lang="ts">
import checkApi from '@/common/checkApi.ts';
import { reactive, toRefs } from 'vue';
import { useRoute, useRouter } from 'vue-router';

export default {
    name: 'check',
    setup() {
        const router = useRouter();
        const route = useRoute();
        const state = reactive({
            fileList: [] as any,
        });
        const enterView = () => {
            router.push({ path: '/upload' });
        };
        // const save = () => {
        //     checkApi.save(state);
        // };
        const searchInfo = async () => {
            const res = checkApi.searchImage();
            console.log(res);
            state.fileList = res;
        };
        return {
            ...toRefs(state),
            enterView,
            searchInfo,
        };
    },
};
</script>
<style scoped>
.box-card {
    width: 680px;
}
</style>