package org.seckill.dto;

/**
 * Created by hujiayu on 2017/7/27.
 */
//所有ajax的请求返回类型，封装json结果
public class SeckillResult<T> {

    private boolean success;

    private T data;

    private String error; //错误信息

    public SeckillResult(boolean status, T data) {
        this.success = status;
        this.data = data;
    }

    public SeckillResult(boolean status, String error) {
        this.success = status;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean status) {
        this.success = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
