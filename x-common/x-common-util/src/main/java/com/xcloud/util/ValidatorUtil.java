package com.xcloud.util;

import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @author xuehy
 * @since 2022/2/24
 */
public class ValidatorUtil {

    private static Validator VALIDATOR;

    static {
        VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    }

    //验证List中的每项是否符合注释格式
    public static String validate(List list, Class<?>... groups) {
        for (int i = 0; i < list.size(); i++) {
            String message = validate(list.get(i), groups);
            if (StrUtil.isNotBlank(message)) {
                return "第" + (i + 1) + "条数据:" + message;
            }
        }
        return null;
    }

    //验证Object是否符合注释格式
    public static String validate(Object o, Class<?>... groups) {
        Set<ConstraintViolation<Object>> validateSet = VALIDATOR.validate(o, groups);
        if (!validateSet.isEmpty()) {
            return validateSet.stream().map(ConstraintViolation::getMessage)
                                .reduce((m1, m2) -> m1 + ";" + m2)
                                .orElse("参数有误");
        }
        return null;
    }

}
