package mayfly.sys.module.machine.service;

import mayfly.core.base.service.BaseService;
import mayfly.sys.module.machine.controller.form.MachineFileForm;
import mayfly.sys.module.machine.controller.vo.LsVO;
import mayfly.sys.module.machine.entity.MachineFileDO;

import java.io.InputStream;
import java.util.List;

/**
 * @author meilin.huang
 * @version 1.0
 * @date 2019-11-04 3:04 下午
 */
public interface MachineFileService extends BaseService<Long, MachineFileDO> {

    /**
     * 获取指定机器上已保存的配置文件信息
     *
     * @param machineId 机器id
     * @return 配置文件信息
     */
    List<MachineFileDO> listByMachineId(Long machineId);

    /**
     * 检查是否有权限操作文件
     *
     * @param fileId id
     * @param path   路径
     * @return 文件配置信息
     */
    MachineFileDO checkFile(Long fileId, String path);

    /**
     * 更新文件内容
     *
     * @param confId  配置信息id
     * @param path    文件全路径
     * @param content 文件内容
     */
    void updateFileContent(Long confId, String path, String content);

    /**
     * 新增配置文件
     *
     * @param machineId 机器id
     * @param form      表单
     */
    MachineFileDO create(Long machineId, MachineFileForm form);

    /**
     * 文件上传
     *
     * @param fileId      配置的文件id
     * @param filePath    文件完整路径，包括文件名
     * @param inputStream inputstream
     */
    void uploadFile(Long fileId, String filePath, InputStream inputStream);

    /**
     * 删除文件
     *
     * @param fileId 配置的文件id
     * @param path   路径
     */
    void rmFile(Long fileId, String path);

    /**
     * 获取目录下的内容
     *
     * @param fileId 目录id
     * @param path   路径
     * @return 内容
     */
    List<LsVO> ls(Long fileId, String path);
}
