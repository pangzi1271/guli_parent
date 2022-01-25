package com.atguigu.servicebase.exceptionHandler;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author 老胖
 * @Date 3/12/2021 12:44 am
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理！！！");
    }

    @ExceptionHandler(GuliException.class)
    public R error(GuliException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
