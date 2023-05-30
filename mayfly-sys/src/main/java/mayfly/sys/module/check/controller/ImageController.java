package mayfly.sys.module.check.controller;


import mayfly.core.model.result.Response2Result;
import mayfly.sys.module.check.form.ImageForm;
import mayfly.sys.module.check.service.ImageService;
import mayfly.sys.module.check.vo.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理
 *
 * @author yujian.guo
 * @version 1.0.0
 * @date 2023/05/23 10:52:30
 * @copyright All Rights Reserved.
 */


@Response2Result
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/saveImage")
    public void saveImage(@RequestBody ImageForm form) {
        imageService.saveImage(form);
    }
    @GetMapping("/searchImage")
    public List<ImageVO> search(){
        return imageService.selectByAccountId();
    }

}