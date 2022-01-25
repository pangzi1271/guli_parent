package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testJava
 * @since 2022-01-22
 */
public interface EduSubjectService extends IService<EduSubject> {

    // 添加课程分类
    void saveSubject(MultipartFile file, EduSubjectService subjectService);
}
