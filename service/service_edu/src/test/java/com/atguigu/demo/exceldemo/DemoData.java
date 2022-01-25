package com.atguigu.demo.exceldemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 老胖
 * @Date 22/01/2022 10:49 am
 */

@Data
public class DemoData {

    // 定义excel的表头名称
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名", index = 1)
    private String sname;
}
