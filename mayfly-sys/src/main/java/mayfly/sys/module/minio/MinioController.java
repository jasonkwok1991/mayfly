package mayfly.sys.module.minio;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Controller
public class MinioController {

    @Autowired
    private MinioUtils minioUtils;


    /**
     * 上传
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        JSONObject res = null;
        HashMap<String, String> map = new HashMap<>();
        try {
            res = minioUtils.uploadFile(file, "product",map);
            String name = map.get("name");
            String previewFileUrl = minioUtils.getPreviewFileUrl(name);
            res.put("msg",previewFileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("code", 0);
            res.put("msg", "上传失败");
        }
        return res.toJSONString();
    }

    @GetMapping("/getAbsoluteFileAddress")
    @ResponseBody
    public String getAbsoluteFileAddress(){
       return minioUtils.getPreviewFileUrl("product_1683873980985.jpg");
    }

}
