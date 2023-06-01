<template>

  <el-row class="head">
    <el-col>
      上传主页
    </el-col>
  </el-row>

  <br><br>

  <div class="container">
    <el-row justify="center">
      <el-col :xs="12"
              :sm="12"
              :md="12"
              :lg="12"
              :xl="12">
        <!-- <el-form-item label="平台类型:"> -->
        <el-select default-first-option
                   style="width: 100%"
                   v-model="imageType"
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
      <el-col :xs="12"
              :sm="12"
              :md="12"
              :lg="12"
              :xl="12">
        <el-text>一次最多上传5张<br>可选择上传日期，不选择默认当天</el-text>
      </el-col>
    </el-row>
    <br><br>
    <el-row justify="center">
      <el-col :xs="12"
              :sm="12"
              :md="12"
              :lg="12"
              :xl="12">
        <el-upload action="http://localhost:8080/upload"
                   list-type="picture-card"
                   :on-success="handleAvatarSuccess"
                   :on-remove="handleRemove"
                   :before-upload="beforeAvatarUpload">
          <div class="el-upload__text">上传图片</div>
          <i class="el-icon-plus"></i>
        </el-upload>
      </el-col>
    </el-row>
    <br><br>
    <!-- <el-row justify="center">
      <el-col :xs="12"
              :sm="12"
              :md="12"
              :lg="12"
              :xl="12">
        <uploadfile :limit='1'></uploadfile>

      </el-col>
    </el-row>
    <br><br> -->
    <el-row justify="center">
      <el-col :xs="12"
              :sm="12"
              :md="12"
              :lg="12"
              :xl="12">
        <el-date-picker v-model="date"
                        type="date"
                        placeholder="选择日期">
        </el-date-picker>
      </el-col>
    </el-row>

    <el-row justify="center"
            class="fot">
      <el-button type="primary"
                 @click="save">上传</el-button>
    </el-row>
  </div>
</template>
<script lang="ts">
import checkApi from '@/common/checkApi.ts';
import uploadfile from '@/components/uploadfile.vue';
import { ElMessage } from 'element-plus';
import { reactive, toRefs } from 'vue';
import { useRouter } from 'vue-router';
import enums from '../enums';

export default {
    name: 'Upload',
    components: { uploadfile },
    setup() {
        const router = useRouter();
        //上传文件地址，待用
        const fileUploadUrl = checkApi.uploadImg;
        const state = reactive({
            imageType: '',
            date: '',
            url: '',
        });
        const save = () => {
            checkApi.save(state);
            router.push({ path: '/check' });
        };
        const beforeAvatarUpload = (rawFile) => {
            if (rawFile.type !== 'image/jpeg' && rawFile.type !== 'image/png') {
                ElMessage.error('只能上传jpg或png');
                return false;
            } else if (rawFile.size / 1024 / 1024 > 2) {
                ElMessage.error('文件大小不能超过2MB!');
                return false;
            }
            return true;
        };

        const handleAvatarSuccess = (res, file, uploadFiles) => {
            //临时路径
            // let urls = [];
            //处理文件list
            // uploadFiles.forEach((item) => {
            //     // 上传文件是带有response属性的，回显的文件没有。处理是为了回显再编辑文件的时候
            //     if (item) {
            //         let rs = item.response;
            //         if (rs) {
            //             let code = rs.code;
            //             if (code == 200) {
            //                 let fileUrl = rs.data.fileUrl;
            //                 urls.push(fileUrl);
            //             }
            //         } else {
            //             urls.push(item.url);
            //         }
            //     }
            // });
            state.url = res.msg;
            //返回父组件 给到指定字段赋值，多文件以逗号分隔
            // emits('getUrl', urls.toString());
        };
        const handleRemove = (uploadFile, uploadFiles) => {
            state.url = '';
            //临时路径
            // let urls = [];
            // //处理文件list
            // uploadFiles.forEach((item) => {
            //     // console.log(el.response.fileUrl);
            //     if (item) {
            //         let rs = item.response;
            //         if (rs) {
            //             let code = rs.code;
            //             if (code == 200) {
            //                 let fileUrl = rs.data.fileUrl;
            //                 urls.push(fileUrl);
            //             }
            //         } else {
            //             urls.push(item.url);
            //         }
            //     }
            // });
            //返回父组件 给到指定字段赋值，多文件以逗号分隔
            // emits('getUrl', urls.toString());
        };
        return {
            ...toRefs(state),
            enums,
            save,
            fileUploadUrl,
            handleAvatarSuccess,
            beforeAvatarUpload,
            handleRemove,
        };
    },
};
</script>

<style scoped>
.head {
    /* font-weight: bold; */
    text-align: center;
    font-size: 15px;
    background-color: rgb(92, 187, 235);
    /* background-size: 50%; */
}
.el-upload__text {
    color: rgb(47, 197, 238);
}
.fot {
    position: fixed;
    bottom: 0;
    width: 100%;
    line-height: var(--footer-height);
}
</style>