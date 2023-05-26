package mayfly.sys.module.check.service;

import mayfly.sys.module.check.entity.Image;
import java.util.List;

/**
 * 服务接口
 *
 * @author yujian.guo
 * @version 1.0.0
 * @date 2023/05/23 10:52:30
 * @copyright All Rights Reserved.
 */
public interface ImageService {


    /**
     * 根据对象属性列表批量插入
     *
     * @param list 实例列表
     * @return {@link Integer}
     */
    Integer insertBatchByProperty(List<Image> list);

    /**
     * 根据对象属性带主键更新
     *
     * @param image 实例对象
     * @return {@link Integer}
     */
    Integer updateByPrimaryKey(Image image);

    /**
     * 根据对象属性带主键列表批量更新
     *
     * @param list 实例对象列表
     * @return {@link Integer}
     */
    Integer updateBatchByPrimaryKey(List<Image> list);

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@link Integer}
     */
    Integer deleteByPrimaryKey(Long id);

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return {@link Integer}
     */
    Integer deleteBatchByPrimaryKey(List<Long> list);

    /**
     * 根据属性删除
     *
     * @param image 实例对象
     * @return {@link Integer}
     */
    Integer deleteByProperty(Image image);

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return {@link Image}
     */
    Image selectByPrimaryKey(Long id);
    
    /**
     * 根据属性进行查询
     *
     * @param image 实例对象
     * @return {@link List<Image>}
     */
    List<Image> selectByProperty(Image image);

    /**
     * 根据属性进行查询统计
     *
     * @param image 实例对象
     * @return {@link Long}
     */
    Long countByProperty(Image image);

    /**
     * 保存文件
     * @param url
     */
    void saveImage(String url);

}