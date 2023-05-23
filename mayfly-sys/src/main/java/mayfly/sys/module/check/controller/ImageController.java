package mayfly.sys.module.check.controller;



import mayfly.sys.module.check.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理
 *
 * @author yujian.guo
 * @version 1.0.0
 * @date 2023/05/23 10:52:30
 * @copyright All Rights Reserved.
 */
@Controller
@RequestMapping("/image/")
public class ImageController {

    @Autowired
    private ImageService imageService;

}