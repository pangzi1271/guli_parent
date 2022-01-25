package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.service.EduSubjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-01-22
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    private final EduSubjectService subjectService;

    public EduSubjectController(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // 添加课程分类
    /**
     * 把上传后的文件读取出来
     * @param file 读取的文
     * @return 是否正确写入
     */
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
        subjectService.saveSubject(file, subjectService);
        return R.ok();
    }
}

