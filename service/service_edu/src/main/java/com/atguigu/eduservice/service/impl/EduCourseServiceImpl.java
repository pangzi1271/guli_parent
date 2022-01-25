package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduCourseDescription;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testJava
 * @since 2022-01-23
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    /**
     * 向课程表添加课程基本信息，向课程简介表添加课程简介
     *
     * @param courseInfoVo 网页提交过来的数据
     */
    @Override
    public void saveCourseInfo(CourseInfoVo courseInfoVo) {

        // 将网页端传过来的数据传递给EduCourse实例对象
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);

        // 向课程表添加课程基本信息
        int insert = baseMapper.insert(eduCourse);
        if (insert == 0) {
            throw new GuliException(20001, "添加课程信息失败");
        }

        // 向课程简介表添加课程简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(courseInfoVo.getId());
        courseDescriptionService.save(courseDescription);
    }
}
