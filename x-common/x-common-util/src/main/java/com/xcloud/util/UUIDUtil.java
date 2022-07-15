package com.xcloud.util;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xuehy
 * @since 2021/4/22
 */
public class UUIDUtil {

    /**
     * 获得UUID
     * @param removeSymbol 是否删除'-'符号
     * @return uuid
     */
    public static String getUUID(boolean removeSymbol) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        if (removeSymbol) {
            return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        }
        return str;
    }

    //获得指定数量的UUID
    public static String[] getUUID(int number, boolean removeSymbol) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID(removeSymbol);
        }
        return ss;
    }

    /**
     * 获得uuid标识
     * @param head 头,会拼接在最前面
     * @param length 头后面的字符串长度
     * @return uuid
     */
    public static String getUUID(String head, int length) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = ThreadLocalRandom.current();
        StringBuffer sb = new StringBuffer(head);
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

}
