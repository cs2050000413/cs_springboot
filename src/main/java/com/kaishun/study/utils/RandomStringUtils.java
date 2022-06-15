package com.kaishun.study.utils;

import java.util.Random;

/**
 * ClassName:    RandomStringUtils
 * Package:    com.test.demo.utils
 * Description:
 * Datetime:    2020/1/17   14:19
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class RandomStringUtils {

    private static String number = "0123456789";

    private static String upperWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String lowerWord = "abcdefghijklmnopqrstuvwxyz";

    /**
     * @description 生成n为随机数字
     * @author zhoukaishun
     * @date 2020/2/18 16:48
     */
    public static String randomNumeric(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(number.charAt(random.nextInt(number.length())));
        }
        return stringBuffer.toString();
    }

    /**
     * @description 生成n位随机的字符串
     * @author zhoukaishun
     * @date 2020/2/18 16:47
     */
    public static String randomString(int n) {
        String string = number + upperWord + lowerWord;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(string.charAt(random.nextInt(string.length())));
        }
        return stringBuffer.toString();
    }

    /**
     * @description 左边不足补0
     * @author zhoukaishun
     * @date 2020/2/18 16:47
     */
    public static String leftZeroFill(String string, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = string.length(); i < length; i++) {
            builder.append("0");
        }
        return builder.toString() + string;
    }

    /**
     * @description 取最大相同部分
     * @author zhoukaishun
     * @date 2020/2/18 16:45
     */
    public static String getMaxSubString(String s1, String s2) {
        String max = "", min = "";
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max == s1) ? s2 : s1;
        for (int x = 0; x < min.length(); x++) {
            for (int y = 0, z = min.length() - x; z != min.length() + 1; y++, z++) {
                String temp = min.substring(y, z);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return "";
    }

}
