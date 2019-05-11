package com.yqboots.social.wechat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;

/**
 * MD5加密
 */
public final class MD5Utils {
    private static final Logger LOG = LoggerFactory.getLogger(MD5Utils.class);

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * Encodes to MD5-style string.
     *
     * @param origin  origin string
     * @param charset charset
     * @return MD5 based string
     */
    public static String MD5Encode(String origin, String charset) {
        String result = null;
        try {
            result = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (StringUtils.isEmpty(charset)) {
                result = byteArrayToHexString(md.digest(result.getBytes()));
            } else {
                result = byteArrayToHexString(md.digest(result.getBytes(charset)));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        return result;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte value : b) {
            sb.append(byteToHexString(value));
        }

        return sb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }

        int d1 = n / 16;
        int d2 = n % 16;

        return hexDigits[d1] + hexDigits[d2];
    }
}
