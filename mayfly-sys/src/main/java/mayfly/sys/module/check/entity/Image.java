package mayfly.sys.module.check.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 实体
 *
 * @author yujian.guo
 * @version 1.0.0
 * @date 2023/05/23 10:52:30
 * @copyright All Rights Reserved.
 */
@Data
public class Image implements Serializable {
    private static final long serialVersionUID = -88796209835241506L;

    private Long id;
        /**
     * 1：海安发布；2：海安播报: 3:海安融媒;4:我的海安;5:悦海安;6:海安日报
     */
    private Integer imageType;
    

    private String url;
    
    private Long creatorId;
    
    private String creator;
    
    private Date createTime;
        
}