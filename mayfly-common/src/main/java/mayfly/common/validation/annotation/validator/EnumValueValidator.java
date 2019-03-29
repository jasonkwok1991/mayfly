package mayfly.common.validation.annotation.validator;

import mayfly.common.enums.BaseEnum;
import mayfly.common.utils.EnumUtils;
import mayfly.common.validation.annotation.EnumValue;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * EnumValue注解校验器
 * @author meilin.huang
 * @version 1.0
 * @date 2019-03-28 5:11 PM
 */
public class EnumValueValidator implements Validator {

    @Override
    public ValidResult validation(Field field, Object fieldValue) {
        EnumValue enumValue = field.getAnnotation(EnumValue.class);
        if (enumValue != null && fieldValue != null) {
            if (fieldValue instanceof Integer) {
                Class<? extends Enum> enumClass = enumValue.clazz();
                if (!BaseEnum.class.isAssignableFrom(enumClass)) {
                    throw new IllegalArgumentException("@EnumValue注解中的枚举类必须继承BaseEnum接口！");
                }
                Collection<? extends Enum> es = EnumSet.allOf(enumClass);
                BaseEnum[] enums = new BaseEnum[es.size()];
                int idx = 0;
                for (Iterator it = es.iterator(); it.hasNext();) {
                    enums[idx++] = (BaseEnum) it.next();
                }
                if (EnumUtils.isExist(enums, (Integer)fieldValue)) {
                    return ValidResult.right();
                }
                return ValidResult.error(field.getName() + "字段值错误！");
            }
        }
        return ValidResult.right();
    }
}