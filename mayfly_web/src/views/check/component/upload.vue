<template>

  <el-form>
    <el-form-item label="平台类型">
      <el-select default-first-option
                 style="width: 100%"
                 placeholder="请选择类型">
        <el-option v-for="item in enums.platformTypeEnum"
                   :key="item.value"
                   :label="item.label"
                   :value="item.value"></el-option>
      </el-select>
    </el-form-item>
  </el-form>

</template>
<script lang="ts">
import { defineComponent, reactive } from 'vue';
import enums from '../enums';
export default defineComponent({
    name: 'Upload',
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
</style>