import request from '@/utils/request'

export default{
  getTeacherListPage(current, limit, teacherQuery){

    // 1. 讲师列表，条件分页查询
    // current 当前页，limit 每页记录数，teacherQuery条件查询对象
    return request({
      // 两种url的写法，推荐第2种写法。url要与后端controller中相应的方法一致
      // url: '/eeduservice/teacher/pageTeacherCondition/' + current + "/" + limit,
      url: `/eduservice/teacher/pageTeacherCondition/${current}/${limit}`,
      method: 'post',
      // teacherQuery条件查询对象，后端使用RequestBody来获取数据
      // data表示把对象转换成json类型的数据再传递到接口里面
      data: teacherQuery
    })
  },

  // 2. 删除讲师
  deleteTeacherId(id){
    return request({
      url: `/eduservice/teacher/${id}`,
      method: 'delete'
    })
  }
}
