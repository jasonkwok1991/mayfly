<template>
  <!-- <el-space wrap
            direction="horizontal"> -->
 <div>
  <el-row justify="center">
    <el-text tag="b">今日上传任务进度</el-text>
  </el-row>
  <br>
  <el-row :gutter="6" justify="center">
    <el-col :xs="12" :sm="8" :md="6" :lg="5" :xl="5" >
    <el-card shadow="hover" class="cardone">
      <el-progress type="circle"
                   v-model="fb"
                   color="white"
                   :format="format"
                   :percentage="fb" />
      海安发布 </el-card>
    </el-col>
    <el-col :xs="12" :sm="8" :md="6" :lg="5" :xl="5">
    <el-card shadow="hover" class="cardtwo">
      <el-progress type="circle"
                   v-model="bb"
                   color="white"
                   :format="format"
                   :percentage="bb" />
      海安播报 </el-card>
    </el-col>
  </el-row>
  <br>
  <el-row :gutter="6" justify="center">
    <el-col :xs="12" :sm="8" :md="6" :lg="5" :xl="5">
    <el-card shadow="hover" class="cardthree">
      <el-progress type="circle"
                   v-model="rm"
                   color="white"
                   :format="format"
                   :percentage="rm" />
      海安融媒 </el-card>
    </el-col>
    <el-col :xs="12" :sm="8" :md="6" :lg="5" :xl="5">
    <el-card shadow="hover" class="cardfour">
      <el-progress type="circle"
                   v-model="wd"
                   color="white"
                   :format="format"
                   :percentage="wd" />
      我的海安 </el-card>
    </el-col>
  </el-row>
  <br>
  <el-row :gutter="6" justify="center">
    <el-col :xs="12" :sm="8" :md="6" :lg="5" :xl="5">
    <el-card shadow="hover" class="cardfive"> 
      <el-progress type="circle"
                   v-model="yhh"
                   color="white"
                   :format="format"
                   :percentage="yhh" />
      悦海安   </el-card>
    </el-col>
    <el-col :xs="12" :sm="8" :md="6" :lg="5" :xl="5">
    <el-card shadow="hover" class="cardsix">
      <el-progress type="circle"
                   v-model="rb"
                   color="white"
                   :format="format"
                   :percentage="rb" />
      海安日报 </el-card>
    </el-col>
  </el-row>
  <br>
  <el-row justify="center">
    <el-button type="primary"
               @click="searchInfo">获取数据</el-button>
    <el-button type="primary"
               @click="enterView">立即上传</el-button>
  <!-- </el-space> -->
  </el-row>
 </div>
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
            fb: 0,
            bb: 0,
            rm: 0,
            wd: 0,
            yhh: 0,
            rb: 0,
        });
        const enterView = () => {
            router.push({ path: '/upload' });
        };
        // const save = () => {
        //     checkApi.save(state);
        // };
        const searchInfo = async () => {
            const res = await checkApi.searchImage();
            // const res = checkApi.searchImage();
            console.log(res);
            state.fileList = res;

            // for (let tp of state.fileList) {
            //     console.log(tp.imageType);
            // }

            for (let tp of state.fileList) {
                switch (tp.imageType) {
                    case 1:
                        state.fb = 100;
                        break;
                    case 2:
                        state.bb = 100;
                        break;
                    case 3:
                        state.rm = 100;
                        break;
                    case 4:
                        state.wd = 100;
                        break;
                    case 5:
                        state.yhh = 100;
                        break;
                    case 6:
                        state.rb = 100;
                        break;
                    default:
                        break;
                }
            }
            // console.log(state.fb);
        };

        let format = (percentage:number) =>{
          return percentage === 100 ? '已完成' : `${percentage}%`;
        }
        
        return {
            ...toRefs(state),
            enterView,
            searchInfo,
            format
        };
    },
};
</script>
<style scoped>
/* .el-card {
    height: 160px;
} */
.cardone{
  color: aliceblue;
  font-size: 17px;
  background-color:rgb(94, 144, 244);
}
.cardtwo{
  color: aliceblue;
  font-size: 17px;
  background-color:rgb(243, 204, 131);
}
.cardthree{
  color: aliceblue;
  font-size: 17px;
  background-color:rgb(237, 93, 93);
}
.cardfour{
  color: aliceblue;
  font-size: 17px;
  background-color:rgb(79, 203, 91);
}
.cardfive{
  color: aliceblue;
  font-size: 17px;
  background-color:rgb(239, 147, 105);
}
.cardsix{
  color: aliceblue;
  font-size: 17px;
  background-color:rgb(239, 134, 188);
}
</style>