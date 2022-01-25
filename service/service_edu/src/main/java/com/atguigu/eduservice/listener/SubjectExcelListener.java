package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @Description
 * @Author 老胖
 * @Date 22/01/2022 8:41 pm
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    public EduSubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData data, AnalysisContext context) {
        if (data == null) {
            throw new GuliException(20001, "文件数据为空");
        }

        // 逐行读取，每一行都有两个值，第一个值是一级分类，第二个值是二级分类
        // 判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(subjectService, data.getOneSubjectName());
        if (existOneSubject == null) {
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(data.getOneSubjectName());
            subjectService.save(existOneSubject);
        }

        // 判断二级分类是否重复
        String pid = existOneSubject.getId();
        EduSubject existTwoSubject = this.existTwoSubject(subjectService, data.getTwoSubjectName(), pid);
        if (existTwoSubject == null) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(data.getTwoSubjectName());
            subjectService.save(existTwoSubject);
        }
    }

    /**
     * 判断一级分类不能重复添加
     *
     * @param subjectService
     * @param name           分类名
     * @return 是否存在相同的一级分类
     */
    private EduSubject existOneSubject(EduSubjectService subjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        return subjectService.getOne(wrapper);

    }

    /**
     * 判断一级分类不能重复添加
     *
     * @param subjectService
     * @param name           分类名
     * @return 是否存在相同的二级分类
     */
    private EduSubject existTwoSubject(EduSubjectService subjectService, String name, String pid) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        return subjectService.getOne(wrapper);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
