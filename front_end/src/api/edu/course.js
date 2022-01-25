import request from '@/utils/request'

export default {
  addCourseInfo(courseInfo){
    return request({
      url: '/eduservice/course/addCourseInfo',
      method: 'post',
      data: courseInfo
    })
  }
}
