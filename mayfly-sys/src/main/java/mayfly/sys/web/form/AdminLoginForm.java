package mayfly.sys.web.form;

import lombok.Data;
import mayfly.common.validation.annotation.NotBlank;

/**
 * @author meilin.huang
 * @version 1.0
 * @date 2018-11-22 10:28 AM
 */
@Data
public class AdminLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String captcha;
}
