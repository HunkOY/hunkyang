package com.pagoda.util;

import com.alibaba.fastjson.JSONObject;
import com.pagoda.entity.PosPoll;

import java.util.Date;

/**
 * @author Hunk
 * @Description TODO
 * @Date 2020/10/29 15:18
 */
public class SignUtil {

    private static final String POS_SERVER_KEY = "POS";
    private static final String POS_FORMAT = "json";
    private static final String POS_VERSION = "1.0";
    private static final String POS_SERVER_SECRET = "DDKMVH9KWJTIZXMIMXVN0Q4KM6NC06YT";



    public static  String generateSign(String timestamp){
        if (null == timestamp || "".equals(timestamp)){
            timestamp = DateUtils.formatDate(new Date(),DateUtils.DATETIME_PATTERN);
        }
        PosPoll posPoll = PosPoll.create(POS_SERVER_KEY, timestamp, POS_FORMAT, POS_VERSION,new JSONObject());
        return generateSign(posPoll);
    }

    public static String generateSign(PosPoll posPoll){
        if (posPoll == null){
            return "参数不对";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("format=" + posPoll.getFormat() + "&");
        sb.append("params=" + posPoll.getParams() + "&");
        sb.append("serverKey=" + posPoll.getServerKey() + "&");
        sb.append("timestamp=" + posPoll.getTimestamp() + "&");
        sb.append("version=" + posPoll.getVersion());
        String singFrom = POS_SERVER_SECRET + sb.toString() + POS_SERVER_SECRET;
        System.out.println("生成签名前：" + singFrom);
        String sign = MD5.setMd5Code(singFrom).toUpperCase();
        return sign;
    }

}
