package com.pagoda.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hunkyang
 */
public class StringUtil {

    /**
     * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替
     *
     * @param content  传入的字符串
     * @return 带星号的字符串
     */
    public static String desensitizedCustomerName(String content) {

        if (StringUtils.isBlank(content)) {
            return content;
        }
        int len = content.length();
        int beginIndex = 0;
        int endIndex = len;

        if (len == 1) {
            return content;
        }
        if (len == 2) {
            beginIndex = 0;
            endIndex = len -1;
        }
        if (len == 3) {
            beginIndex = 1;
            endIndex = len -1;
        }
        if (len >= 4) {
            beginIndex = 0;
            endIndex = len -2;
        }

        char[] cardChar = content.toCharArray();
        for (int j = beginIndex; j < endIndex; j++) {
            cardChar[j] = '*';
        }
        return new String(cardChar);
    }
}
