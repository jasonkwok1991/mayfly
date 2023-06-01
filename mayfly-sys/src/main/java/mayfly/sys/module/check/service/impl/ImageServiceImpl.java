package mayfly.sys.module.check.service.impl;

import mayfly.core.permission.LoginAccount;
import mayfly.sys.module.check.entity.Image;
import mayfly.sys.module.check.form.ImageForm;
import mayfly.sys.module.check.mapper.ImageMapper;
import mayfly.sys.module.check.service.ImageService;
import mayfly.sys.module.check.vo.ImageVO;
import mayfly.sys.module.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private AccountService accountService;


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

    @Override
    public void saveImage(ImageForm form) {
        //从上下文获取用户登录ID
        Long uid = LoginAccount.getLoginAccountId();
        String username = LoginAccount.getFromContext().getUsername();

        ArrayList<Image> list = new ArrayList<>();
        Image image = new Image();
        image.setCreator(username);
        image.setImageType(form.getImageType());
        image.setCreatorId(uid);
        image.setUrl(form.getUrl());
        image.setCreateTime(new Date());
        list.add(image);
        this.insertBatchByProperty(list);
    }

    @Override
    public List<ImageVO> selectByAccountId() {
        Long uid = LoginAccount.getLoginAccountId();
        List<ImageVO> list = imageMapper.selectByAccountId(uid);

        return list;
    }
}