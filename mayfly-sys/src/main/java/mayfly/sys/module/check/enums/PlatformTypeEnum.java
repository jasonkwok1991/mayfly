package mayfly.sys.module.check.enums;

import mayfly.core.util.enums.NameValueEnum;

public enum PlatformTypeEnum implements NameValueEnum<Integer> {

    /**
     * 海安发布
     */
    HAIANFABU(1, "haianfabu"),

    /**
     *海安播报
     */
    HAIANBOBAO(2, "haianbobao"),

    /**
     *海安融媒
     */
    HAIANRONGMEI(3, "haianrongmei"),

    /**
     *我的海安
     */
    WODEHAIAN(4, "wodehaian"),

    /**
     *悦海安
     */
    YUEHAIAN(5, "yuehaian"),

    /**
     *海安日报
     */
    HAIANRIBAO(6, "haianribao")

    ;

    private Integer value;
    private String name;

    PlatformTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
