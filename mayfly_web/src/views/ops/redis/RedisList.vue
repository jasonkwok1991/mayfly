<template>
  <div>
    <div class="toolbar">
      <el-button
        type="primary"
        icon="el-icon-plus"
        size="small"
        @click="openFormDialog(false)"
        plain
      >添加</el-button>
      <el-button
        type="primary"
        icon="el-icon-edit"
        :disabled="currentId == null"
        size="small"
        @click="openFormDialog(currentData)"
        plain
      >编辑</el-button>
      <el-button
        type="danger"
        icon="el-icon-delete"
        :disabled="currentId == null"
        size="small"
        @click="deleteNode"
        plain
      >删除</el-button>
      <div style="float: right;">
        <el-input
          placeholder="host"
          size="small"
          style="width: 140px;"
          v-model="params.host"
          @clear="search"
          plain
          clearable
        ></el-input>
        <el-select v-model="params.clusterId" size="small" clearable placeholder="集群选择">
          <el-option v-for="item in clusters" :key="item.id" :value="item.id" :label="item.name"></el-option>
        </el-select>
        <el-button @click="search" type="success" icon="el-icon-search" size="small"></el-button>
      </div>
    </div>
    <el-table :data="redisTable" stripe style="width: 100%" @current-change="choose">
      <el-table-column label="选择" width="50px">
        <template slot-scope="scope">
          <el-radio v-model="currentId" :label="scope.row.id">
            <i></i>
          </el-radio>
        </template>
      </el-table-column>
      <el-table-column prop="host" label="IP" width></el-table-column>
      <el-table-column prop="port" label="端口" width></el-table-column>
      <el-table-column prop="clusterId" label="集群id"></el-table-column>
      <el-table-column prop="description" label="描述"></el-table-column>
      <el-table-column label="操作" width>
        <template slot-scope="scope">
          <el-button
            v-permission="permission.redis.code"
            type="primary"
            @click="info(scope.row)"
            :ref="scope.row"
            icom="el-icon-tickets"
            size="small"
            plain
          >info</el-button>
          <el-button
            v-permission="keyPermission.redisKey.code"
            type="success"
            @click="manage(scope.row)"
            :ref="scope.row"
            size="small"
            plain
          >数据管理</el-button>
        </template>
      </el-table-column>
    </el-table>

    <Info :visible.sync="infoDialog.visible" :title="infoDialog.title" :info="infoDialog.info"></Info>

    <dynamic-form-dialog
      :dialog-width="formDialog.dialogWidth"
      :visible.sync="formDialog.visible"
      :title="formDialog.title"
      :form-info="formDialog.formInfo"
      :form-data.sync="formDialog.formData"
      @submitSuccess="submitSuccess"
    ></dynamic-form-dialog>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import Info from './Info.vue'
import { redisPermission, redisKeyPermission } from '../permissions'
import { redisApi, redisKeyApi } from '../api'
import { DynamicFormDialog } from '@/components/dynamic-form'

@Component({
  name: 'RedisList',
  components: {
    Info,
    DynamicFormDialog
  }
})
export default class RedisList extends Vue {
  validatePort = (rule: any, value: any, callback: any) => {
    if (value > 65535 || value < 1) {
      callback(new Error('端口号错误'))
    }
    callback()
  }

  redisTable = []
  permission = redisPermission
  keyPermission = redisKeyPermission
  currentId = null
  currentData: any = null
  params = {
    host: null,
    clusterId: null
  }
  redisInfo = {
    url: ''
  }
  clusters = [
    {
      id: 0,
      name: '单机'
    }
  ]
  infoDialog = {
    title: '',
    visible: false,
    info: {
      Server: {},
      Keyspace: {},
      Clients: {},
      CPU: {},
      Memory: {}
    }
  }
  formDialog = {
    visible: false,
    title: '',
    formInfo: {
      createApi: redisApi.save,
      updateApi: redisApi.update,
      formRows: [
        [
          {
            type: 'input',
            label: '主机：',
            name: 'host',
            placeholder: '请输入节点ip',
            rules: [
              {
                required: true,
                message: '请输入节点ip',
                trigger: ['blur', 'change']
              }
            ]
          }
        ],
        [
          {
            type: 'input',
            label: '端口号：',
            name: 'port',
            placeholder: '请输入节点端口号',
            inputType: 'number',
            rules: [
              {
                required: true,
                message: '请输入节点端口号',
                trigger: ['blur', 'change']
              }
            ]
          }
        ],
        [
          {
            type: 'input',
            label: '密码：',
            name: 'pwd',
            placeholder: '请输入节点密码',
            inputType: 'password'
          }
        ],
        [
          {
            type: 'input',
            label: '描述：',
            name: 'description',
            placeholder: '请输入节点描述',
            inputType: 'textarea'
          }
        ]
      ]
    },
    formData: { port: 6379 }
  }

  mounted() {
    this.search()
  }

  choose(item: any) {
    if (!item) {
      return
    }
    this.currentId = item.id
    this.currentData = item
  }

  // connect() {
  //   Req.post('/open/redis/connect', this.form, res => {
  //     this.redisInfo = res
  //   })
  // }

  async deleteNode() {
    await redisApi.del.request({ id: this.currentId })
    this.$message.success('删除成功')
    this.search()
  }

  manage(row: any) {
    this.$router.push(`/redis_operation/${row.clusterId}/${row.id}`)
  }

  info(redis: any) {
    redisApi.info.request({ id: redis.id }).then(res => {
      this.infoDialog.info = res
      this.infoDialog.title = `'${redis.host}' info`
      this.infoDialog.visible = true
    })
  }

  search() {
    redisApi.list.request(this.params).then(res => {
      this.redisTable = res
    })
  }

  openFormDialog(redis: any) {
    let dialogTitle
    if (redis) {
      this.formDialog.formData = this.currentData
      dialogTitle = '编辑redis节点'
    } else {
      this.formDialog.formData = { port: 6379 }
      dialogTitle = '添加redis节点'
    }

    this.formDialog.title = dialogTitle
    this.formDialog.visible = true
  }

  submitSuccess() {
    this.currentId = null
    this.currentData = null
    this.search()
  }

}
</script>

<style>
</style>
