package cn.icodening.mall.utils;

/**
 * @author icodening
 * @date 2021.03.28
 */
public class StringUtils {
    private StringUtils() {
    }

    public static boolean isNotBlank(String string) {
        return string != null && !"".equals(string.trim());
    }
}
