package com.yqboots.social.wechat.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class WeChatUtils {
    private static final String NONCE_STRING_CHAR_SET = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final int NONCE_STRING_LENGTH = 32;

    /**
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     */
    public static boolean isValidSign(String characterEncoding,
                                      SortedMap<String, String> packageParams,
                                      String API_KEY) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entries = packageParams.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String k = entry.getKey();
            String v = entry.getValue();
            if (!"sign".equals(k) && !StringUtils.isEmpty(v)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(API_KEY);
        //算出摘要  
        String mySign = MD5Utils.MD5Encode(sb.toString(), characterEncoding).toLowerCase();
        String wxSign = packageParams.get("sign").toLowerCase();
        return wxSign.equals(mySign);
    }

    /**
     * sign签名
     */
    @SuppressWarnings({"rawtypes"})
    public static String createSign(String characterEncoding,
                                    SortedMap<String, String> packageParams,
                                    String apiKey) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entries = packageParams.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String k = entry.getKey();
            String v = entry.getValue();
            if (!StringUtils.isEmpty(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(apiKey);

        return MD5Utils.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
    }

    /**
     * 获取当前时间 yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
}
