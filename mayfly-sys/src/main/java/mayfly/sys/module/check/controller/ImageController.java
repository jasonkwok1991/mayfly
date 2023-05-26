package mayfly.sys.module.check.controller;



import jakarta.validation.Valid;
import mayfly.core.exception.BizAssert;
import mayfly.core.log.annotation.Log;
import mayfly.sys.module.check.service.ImageService;
import mayfly.sys.module.open.controller.form.AccountLoginForm;
import mayfly.sys.module.sys.controller.vo.LoginSuccessVO;
import mayfly.sys.module.sys.entity.AccountDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/save")
    @Log(value = "文件保存", resLevel = Log.Level.NONE)
    public void login(@RequestBody String url) {
        imageService.saveImage(url);
    }
    //
    @GetMapping("/searchImage")
    public void search(){

    }

}