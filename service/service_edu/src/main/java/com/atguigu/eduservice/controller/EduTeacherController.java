package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiParam;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 讲师 前端控制器
 * @author testJava
 * @since 2021-11-29
 */
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    private final EduTeacherService teacherService;

    public EduTeacherController(EduTeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * 1. 查询讲师表
     * @return 返回定义的统一值
     */
    @GetMapping("findAll")
    public R findAllTeacher() {
        return R.ok().data("items", teacherService.list(null));
    }

    /**
     * 2. 逻辑删除讲师的方法
     * @param id id值需要通过路径进行传递，如localhost:8001/delete/1表示删除表中id值为1的数据
     * @return 返回定义的统一值
     */
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 3. 分页查询讲师的方法
     * @param current 当前页
     * @param limit 每页记录条数
     * @return 返回定义的统一值
     */
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageTeacher(@PathVariable long current, @PathVariable long limit) {

        // 创建page对象，
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
        teacherService.page(pageTeacher, null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        Map<String, Object> teacherMap = new HashMap<>();
        teacherMap.put("total", total);
        teacherMap.put("rows", records);
        return R.ok().data(teacherMap);
    }

    /**
     * 4. 组合条件查询带分页功能
     * 如果使用 @RequestBody注解，就需要将注解@GetMapping改成@PostMapping，否则取不到值。
     * 并且@RequestBody要加入参数required = false，这个表示条件查询的条件也可以都为空
     * @param current 当前页
     * @param limit 每页记录条数
     * @param teacherQuery 组合条件查询对象
     * @return 返回定义的统一值
     */
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) TeacherQuery teacherQuery) {

        // 创建page对象，
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);

        // 构建查询条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        // 多条件组合查询，使用mybatis中的动态SQL原理
        // 首先拿到teacherQuery对象的值
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        // 然后判断这些值是否为空，如果不为空，就说明有这个条件，将这些条件进行拼接
        if (!ObjectUtils.isEmpty(name)) {
            // 构建条件
            wrapper.like("name", name);
        }
        if (!ObjectUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!ObjectUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!ObjectUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }

        // 调用方法实现组合条件分页查询
        teacherService.page(pageTeacher, wrapper);
        return R.ok().data("total", pageTeacher.getTotal()).data("rows", pageTeacher.getRecords());
    }

    /**
     * 5. 添加讲师
     * @param eduTeacher eduTeacher对象
     * @return 返回定义的统一值
     */
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = teacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 6. 根据id查找讲师
     * @param id eduTeacher的属性值
     * @return 返回定义的统一值
     */
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher", eduTeacher);
    }

    /**
     * 7. 更新讲师信息
     * @param eduTeacher eduTeacher对象
     * @return 返回定义的统一值
     */
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {

        boolean success = teacherService.updateById(eduTeacher);
        if (success) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}