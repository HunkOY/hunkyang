package com.pagoda.util;

import com.alibaba.fastjson.JSONObject;


/**
 * @author hunkyang
 */
public class JSONUtil {


    public static JSONObject generateString(String json){

        return JSONObject.parseObject(json);
    }
}
