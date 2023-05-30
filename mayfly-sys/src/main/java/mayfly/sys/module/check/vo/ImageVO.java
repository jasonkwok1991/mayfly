package mayfly.sys.module.check.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageVO {
    /**
     * 平台类型
     */
    private Integer imageType;

    /**
     * 统计
     */
    private Integer count;
}
