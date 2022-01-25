package com.atguigu.servicebase.exceptionHandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author 老胖
 * @Date 4/12/2021 8:37 pm
 */

@Data // 生成getter和setter方法
@AllArgsConstructor // 该注解能够生成有参数的构造方法
@NoArgsConstructor // 该注解能够生成无参数的构造方法
public class GuliException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;


}
