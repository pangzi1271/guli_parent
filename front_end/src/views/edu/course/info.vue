<template>

  <div class="app-container">

    <h2 style="text-align: center;">发布新课程</h2>

    <el-steps :active="1" process-status="wait" align-center style="margin-bottom: 40px;">
      <el-step title="填写课程基本信息"/>
      <el-step title="创建课程大纲"/>
      <el-step title="最终发布"/>
    </el-steps>

    <el-form label-width="120px">

      <el-form-item label="课程标题">
        <el-input v-model="courseInfo.title" placeholder=" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写"/>
      </el-form-item>

      <!-- 所属分类 -->
      <!--<el-form-item label="课程分类">-->
      <!--  <el-select-->
      <!--    v-model="courseInfo.subjectParentId"-->
      <!--    placeholder="一级分类" @change="subjectLevelOneChanged">-->

      <!--    <el-option-->
      <!--      v-for="subject in subjectOneList"-->
      <!--      :key="subject.id"-->
      <!--      :label="subject.title"-->
      <!--      :value="subject.id"/>-->
      <!--  </el-select>-->

      <!--  &lt;!&ndash; 二级分类 &ndash;&gt;-->
      <!--  <el-select v-model="courseInfo.subjectId" placeholder="二级分类">-->
      <!--    <el-option-->
      <!--      v-for="subject in subjectTwoList"-->
      <!--      :key="subject.id"-->
      <!--      :label="subject.title"-->
      <!--      :value="subject.id"/>-->
      <!--  </el-select>-->
      <!--</el-form-item>-->

      <!--课程讲师-->
      <!--<el-form-item label="课程讲师">-->
      <!--  <el-select-->
      <!--    v-model="courseInfo.teacherId"-->
      <!--    placeholder="请选择">-->

      <!--    <el-option-->
      <!--      v-for="teacher in teacherList"-->
      <!--      :key="teacher.id"-->
      <!--      :label="teacher.name"-->
      <!--      :value="teacher.id"/>-->
      <!--  </el-select>-->
      <!--</el-form-item>-->

      <el-form-item label="总课时">
        <el-input-number :min="0" v-model="courseInfo.lessonNum" controls-position="right" placeholder="请填写课程的总课时数"/>
      </el-form-item>

      <!-- 课程简介 -->
      <el-form-item label="课程简介">
        <el-input v-model="courseInfo.description" placeholder=" "/>
      </el-form-item>

      <!-- 课程封面-->
      <!--<el-form-item label="课程封面">-->

      <!--  <el-upload-->
      <!--    :show-file-list="false"-->
      <!--    :on-success="handleAvatarSuccess"-->
      <!--    :before-upload="beforeAvatarUpload"-->
      <!--    :action="BASE_API+'/eduoss/fileoss'"-->
      <!--    class="avatar-uploader">-->
      <!--    <img :src="courseInfo.cover">-->
      <!--  </el-upload>-->

      <!--</el-form-item>-->

      <el-form-item label="课程价格">
        <el-input-number :min="0" v-model="courseInfo.price" controls-position="right" placeholder="免费课程请设置为0元"/> 元
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">保存并下一步</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import course from '@/api/edu/course'
export default {
  data() {
    return {
      saveBtnDisabled: false,
      courseInfo: {
        title: "",
        subjectId: "",
        teacherId: "",
        lessonNum: 0,
        description: "",
        cover: "",
        price: 0
      }
    }
  },

  created() {

  },

  methods: {
    saveOrUpdate() {
      course.addCourseInfo(this.courseInfo)
            .then(response =>{
              // 信息提示
              this.$message({
                type: 'success',
                message: "添加课程信息成功"
                });
              // 跳转到下一个页面
              this.$router.push("/course/chapter/1")
            })
    }
  }
}
</script>
