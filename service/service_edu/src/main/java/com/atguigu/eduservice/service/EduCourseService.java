package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testJava
 * @since 2022-01-23
 */
public interface EduCourseService extends IService<EduCourse> {

    void saveCourseInfo(CourseInfoVo courseInfoVo);
}
