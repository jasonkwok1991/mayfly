package mayfly.sys.module.check.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class ImageForm implements Serializable {

    /**
     * 平台类型
     */
    private Integer imageType;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 日期
     */
    private Date date;
}
