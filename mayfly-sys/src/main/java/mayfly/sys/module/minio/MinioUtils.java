package mayfly.sys.module.minio;

import com.alibaba.fastjson.JSONObject;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Slf4j
@Component
public class MinioUtils {
    @Autowired
    private MinioClient client;
    @Autowired
    private MinioProp minioProp;



    /**
     * 创建bucket
     *
     * @param bucketName bucket名称
     */
    public boolean createBucket(String bucketName) {
        try {
            if (!client.bucketExists(bucketName)) {
                client.makeBucket(bucketName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 上传文件
     *
     * @param file       文件
     * @param bucketName 存储桶
     * @return
     */
    public JSONObject uploadFile(MultipartFile file, String bucketName, HashMap<String, String> map) throws Exception {
        JSONObject res = new JSONObject();
        res.put("code", 0);
        // 判断上传文件是否为空
        if (null == file || 0 == file.getSize()) {
            res.put("msg", "上传文件不能为空");
            return res;
        }
        try {
            // 判断存储桶是否存在
            createBucket(bucketName);
            // 文件名
            String originalFilename = file.getOriginalFilename();
            // 新的文件名 = 存储桶名称_时间戳.后缀名
            String fileName = bucketName + "_" + System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
            map.put("name",fileName);
            // 开始上传
            client.putObject(bucketName, fileName, file.getInputStream(), file.getContentType());
            res.put("code", 1);
            res.put("msg", minioProp.getEndpoint() + "/" + bucketName + "/" + fileName);
            return res;
        }  catch (Exception e) {
            log.error("上传文件失败：{}", e.getMessage());
        }
        res.put("msg", "上传失败");
        return res;
    }

    public String getPreviewFileUrl(String fileName) {
        try {
            return client.presignedGetObject("product",fileName);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }


}
