package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 组合条件查询的实体类
 * @Author 老胖
 * @Date 2/12/2021 8:59 am
 */

@Data
public class TeacherQuery {

    @ApiModelProperty(value = "教师姓名，模糊查询")
    private String name;

    @ApiModelProperty(value = "教师头衔 1-高级讲师， 2-首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-1-1 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-1-1 10:10:10")
    private String end;

}
