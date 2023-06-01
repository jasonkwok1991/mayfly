<template>
  <el-space wrap
            direction="horizontal">

    <el-card>
      <el-progress type="circle"
                   v-model="fb"
                   :percentage="fb" />
      海安发布 </el-card>
    <el-card>
      <el-progress type="circle"
                   v-model="bb"
                   :percentage="bb" />
      海安播报 </el-card>
    <el-card>
      <el-progress type="circle"
                   v-model="rm"
                   :percentage="rm" />
      海安融媒 </el-card>
    <el-card>
      <el-progress type="circle"
                   v-model="wd"
                   :percentage="wd" />
      我的海安 </el-card>
    <el-card>
      <el-progress type="circle"
                   v-model="yhh"
                   :percentage="yhh" />
      悦海安 </el-card>
    <el-card>
      <el-progress type="circle"
                   v-model="rb"
                   :percentage="rb" />
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
            fb:0,bb:0,rm:0,wd:0,yhh:0,rb:0
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

            for (let tp of state.fileList){
              console.log(tp);
            }

            // for (let tp of state.fileList) {
            //   switch(tp.imageType){
            //     case '1': state.fb = 100;break;
            //     case '2': state.bb = 100;break;
            //     case '3': state.rm = 100;break;
            //     case '4': state.wd = 100;break;
            //     case '5': state.yhh = 100;break;
            //     case '6': state.rb = 100;break;
            //     default : break;
            //   }
            // }
            // console.log(state.fb);
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