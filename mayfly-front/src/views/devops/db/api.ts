import Api from '@/common/Api';

export const dbApi = {
    // 获取权限列表
    dbs: Api.create("/devops/dbs", 'get'),
    tableMetadata: Api.create("/devops/dbs/{id}/t-metadata", 'get'),
    columnMetadata: Api.create("/devops/dbs/{id}/c-metadata", 'get'),
    // 获取表即列提示
    hintTables: Api.create("/devops/dbs/{id}/hint-tables", 'get'),
    selectData: Api.create("/devops/dbs/{id}/select-data", 'get'),
    // 保存sql
    saveSql: Api.create("/devops/dbs/{id}/sql", 'post'),
    // 获取保存的sql
    getSql: Api.create("/devops/dbs/{id}/sql", 'get'),
    lsFile: Api.create("/devops/machines/files/{fileId}/ls", 'get'),
    rmFile: Api.create("/devops/machines/files/{fileId}/rm", 'delete'),
    uploadFile: Api.create("/devops/machines/files/upload", 'post'),
    fileContent: Api.create("/devops/machines/files/{fileId}/cat", 'get'),
    // 修改文件内容
    updateFileContent: Api.create("/devops/machines/files/{id}", 'put'),
    // 添加文件or目录
    addConf: Api.create("/devops/machines/{machineId}/files", 'post'),
    // 删除配置的文件or目录
    delConf: Api.create("/devops/machines/files/{id}", 'delete'),
}