package mayfly.sys.module.check.service.impl;

import mayfly.sys.module.check.mapper.ImageMapper;
import mayfly.sys.module.check.entity.Image;
import mayfly.sys.module.check.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务接口实现
 *
 * @author yujian.guo
 * @version 1.0.0
 * @date 2023/05/23 10:52:30
 * @copyright All Rights Reserved.
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
    
    @Override
    public Integer insertByProperty(Image image) {
        return this.imageMapper.insertByProperty(image);
    }

    @Override
    public Integer insertBatchByProperty(List<Image> list) {
        return this.imageMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(Image image) {
        return this.imageMapper.updateByPrimaryKey(image);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<Image> list) {
        return this.imageMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return this.imageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Long> list) {
        return this.imageMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(Image image) {
        return this.imageMapper.deleteByProperty(image);
    }

    @Override
    public Image selectByPrimaryKey(Long id) {
        return this.imageMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<Image> selectByProperty(Image image) {
        return this.imageMapper.selectByProperty(image);
    }

    @Override
    public Long countByProperty(Image image) {
        return this.imageMapper.countByProperty(image);
    }
}