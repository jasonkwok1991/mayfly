package mayfly.core.exception;

import mayfly.core.model.result.CodeMessage;
import mayfly.core.model.result.CommonCodeEnum;

/**
 * 业务逻辑运行时异常
 *
 * @author meilin.huang
 * @version 1.0
 * @date 2019-01-05 2:19 PM
 */
public class BizRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -789021883759549647L;

    /**
     * 异常码
     */
    private final Integer errorCode;

    /**
     * 默认错误code为 {@linkplain CommonCodeEnum#FAILURE}
     *
     * @param msg 错误消息
     */
//    public BizRuntimeException(String msg, Object... params) {
//        super(String.format(msg, params));
//        this.errorCode = CommonCodeEnum.FAILURE.getCode();
//    }

    /**
     * @param errorMsg 错误消息
     */
    public BizRuntimeException(CodeMessage errorMsg, Object... params) {
        super(errorMsg.getMessage(params));
        this.errorCode = errorMsg.getCode();
    }

    /**
     * @param errCode 错误code
     */
    public BizRuntimeException(CodeMessage errCode, String msg) {
        super(msg);
        this.errorCode = errCode.getCode();
    }

    /**
     * 获取错误码
     *
     * @return error code
     */
    public Integer getErrorCode() {
        return errorCode;
    }
}
