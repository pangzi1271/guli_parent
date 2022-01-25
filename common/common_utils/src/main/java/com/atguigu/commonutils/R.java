package com.atguigu.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

// 统一返回结果的类
@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    // 构造方法私有化，这样做目的是其他人只能调用这个类中我定义好的方法
    private R() {}

    /**
     * “成功”静态方法
     * @return
     */
    public static R ok() {
        R r = new R();
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        r.setSuccess(true);
        return r;
    }

    /**
     * “失败”静态方法
     * @return
     */

    public static R error() {
        R r = new R();
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        r.setSuccess(false);
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
