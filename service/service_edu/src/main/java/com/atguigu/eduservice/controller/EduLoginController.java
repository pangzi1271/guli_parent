package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author 老胖
 * @Date 11/12/2021 12:08 pm
 * 在类上添加了注解 @CrossOrigin 是为了解决跨域问题
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {

    /**
     * 登录系统
     * @return 返回统一规定的数据类型
     */
    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    /**
     * 获取讲师的信息
     * @return 返回统一规定的数据类型
     */
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "admin").data("name", "Jack").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
