<template>

  <el-row class="head">
    <el-col >
    上传主页
    </el-col>
  </el-row>

  <br><br>

  <div class="container">
    <el-row justify="center">
      <el-col  :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
        <!-- <el-form-item label="平台类型:"> -->
          <el-select default-first-option
                    style="width: 100%"
                    v-model="value"
                    placeholder="请选择平台类型">
            <el-option v-for="item in enums.platformTypeEnum"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"></el-option>
          </el-select>
        <!-- </el-form-item> -->
      </el-col>
      <!-- <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
        <el-button type="primary" >确定</el-button>
      </el-col> -->
    </el-row>

    <br><br>

    <el-row justify="center">
      <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">   
        <el-text>一次最多上传5张<br>可选择上传日期，不选择默认当天</el-text>
      </el-col>
    </el-row>
    <br><br>
    <el-row justify="center" >
      <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
       <el-upload
        action="https://jsonplaceholder.typicode.com/posts/"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove">
        <div class="el-upload__text">上传图片</div>
        <i class="el-icon-plus"></i>
       </el-upload>
      </el-col>
    </el-row>
    <br><br>
    <el-row justify="center" >
      <el-col :xs="12" :sm="12" :md="12" :lg="12" :xl="12">
        <el-date-picker
          v-model="value1"
          type="date"
          placeholder="选择日期">
        </el-date-picker>
      </el-col>
    </el-row>

    <el-row justify="center" class="fot">  
    <el-button type="primary" 
               @click="enterView">上传</el-button>
    </el-row>
  </div>

  {{value}}
  {{value1}}
</template>
<script lang="ts">
import { defineComponent, reactive } from 'vue';
import enums from '../enums';
export default defineComponent({
    name: 'Upload',
    data(){
        return{
          value :'',
          value1 : ''
        }
    },
    setup() {
        return {
            enums,
        };
        const state = reactive({
            form: {
                type: null,
            },
        });
    },
    
    
});
</script>

<style scoped>

.head{
  /* font-weight: bold; */
  text-align: center;
  font-size: 15px;
  background-color: rgb(92, 187, 235);
  /* background-size: 50%; */
}
.el-upload__text{
    color: rgb(47, 197, 238);
}
.fot{
    position: fixed;
    bottom: 0;
    width: 100%;
    line-height: var(--footer-height);
}


</style>