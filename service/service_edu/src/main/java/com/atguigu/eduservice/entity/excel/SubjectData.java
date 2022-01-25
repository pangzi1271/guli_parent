package com.atguigu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 老胖
 * @Date 22/01/2022 8:34 pm
 */

@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
