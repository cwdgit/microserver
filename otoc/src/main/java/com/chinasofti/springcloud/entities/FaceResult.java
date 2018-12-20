package com.chinasofti.springcloud.entities;



import java.io.Serializable;

/**
 * 人脸识别返回的实体对象
 */

public class FaceResult implements Serializable {
    private String log_id;
    private Integer result_num;
    private FResult[] result;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public Integer getResult_num() {
        return result_num;
    }

    public void setResult_num(Integer result_num) {
        this.result_num = result_num;
    }

    public FResult[] getResult() {
        return result;
    }

    public void setResult(FResult[] result) {
        this.result = result;
    }
}
