package com.chinasofti.springcloud.utils;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义响应结构
 */
public class RtrkmsResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public static RtrkmsResult build(Integer status, String msg, Object data) {
        return new RtrkmsResult(status, msg, data);
    }

    public static RtrkmsResult ok(Object data) {
        return new RtrkmsResult(data);
    }

    public static RtrkmsResult ok(String flag) {
        return new RtrkmsResult(flag);
    }

    public static RtrkmsResult ok() {
        return new RtrkmsResult(null);
    }

    public static RtrkmsResult resultOk(String flag, Object data){
        return new RtrkmsResult(flag, data);
    }
    public RtrkmsResult() {

    }

    public static RtrkmsResult build(Integer status, String msg) {
        return new RtrkmsResult(status, msg, null);
    }

    public RtrkmsResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public RtrkmsResult(Integer status, String msg, String flag) {
        this.status = status;
        this.msg = msg;
        this.flag = flag;
    }

    public  RtrkmsResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public  RtrkmsResult(String flag) {
        this.status = 200;
        this.msg = "OK";
        this.flag = flag;
    }

    public  RtrkmsResult(String flag, Object object) {
        this.status = 200;
        this.msg = "OK";
        this.flag = flag;
        this.data = object;
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为RtrkmsResult对象
     * 
     * @param jsonData json数据
     * @param clazz RtrkmsResult中的object类型
     * @return
     */
    public static RtrkmsResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, RtrkmsResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static RtrkmsResult format(String json) {
        try {
            return MAPPER.readValue(json, RtrkmsResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static RtrkmsResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
