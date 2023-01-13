package com.pagoda.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Hunk
 * @Description TODO
 * @Date 2020/10/29 15:16
 */
public class PosPoll<T> {

    private String serverKey;
    private String timestamp;
    private String format;  
    private String version;
    private JSONObject params;


    public static PosPoll create(String serverKey, String timestamp, String format, String version, JSONObject params) {
        PosPoll input = new PosPoll();
        input.setServerKey(serverKey);
        input.setFormat(format);
        input.setTimestamp(timestamp);
        input.setVersion(version);
        input.setParams(params);
        return input;
    }


    public String getServerKey() {
        return serverKey;
    }

    public void setServerKey(String serverKey) {
        this.serverKey = serverKey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public JSONObject getParams() {
        return params;
    }

    public void setParams(JSONObject params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "PosInput{" +
                "serverKey='" + serverKey + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", format='" + format + '\'' +
                ", version='" + version + '\'' +
                ", params=" + params +
                '}';
    }
}
