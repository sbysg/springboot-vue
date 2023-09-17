package com.qianfen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfen.common.R;
import com.qianfen.entity.Student;
import com.qianfen.mapper.StudentMapper;
import com.qianfen.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加入容器
 *
 * @author hxq
 * @version 1.0
 * @date 2023/9/1 21:47 星期五
 */

@Slf4j
@Service
//@SuppressWarnings("all")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }

    @Override
    public Student findStudentById(int id) {
        return studentMapper.findStudentById(id);
    }


    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }


    /**
     * 开启事务  一般都在service层
     * @param id1 id
     * @param id2 id
     */
    @Transactional()
    @Override
    public void deleteStudentByIds(int id1, int id2) {
        int num1 = studentMapper.deleteStudentById(id1);
        // 故意抛出异常
//        int i = 1/0;
        int num2 = studentMapper.deleteStudentById(id2);

    }


    @Override
    public PageInfo<Student> getAllStudentByPage(int currentPage, int pageSize) {
        // 使用分页 本质就是在后续查询语句之后 追加  limit (pageIndex-1)*pageSize,pageSize
        PageHelper.startPage(currentPage,pageSize);

        // 执行sql    SELECT id,name,age,sex,height,birthday,student_info as studentInfo from student_tb  limit (pageIndex-1)*pageSize,pageSize
        // 查询所有 就会自动配置分页  limit (pageIndex-1)*pageSize,pageSize
        List<Student> allStudent = studentMapper.findAllStudent();

        // pageInfo 封装所有的分页信息
        // 获取总页数 总行数
        PageInfo<Student> pageInfo = new PageInfo<>(allStudent);
        System.out.println("总行数 pageInfo.getTotal() = " + pageInfo.getTotal());
        System.out.println("总页数 pageInfo.getPages() = " + pageInfo.getPages());
        System.out.println("每页数量 pageInfo.ge = " + pageInfo.getSize());
        return pageInfo;
    }

    @Override
    public int deleteStudentById(int id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public int updateStudentById(Student student) {
        return studentMapper.updateStudentById(student);
    }

    @Override
    public Map<String, Object> conditionQuery(Student student, Integer currentPage, Integer pageSize) {

        PageHelper.startPage(currentPage,pageSize);
        // 此时按照分页查询结果
        List<Student> studentList = studentMapper.conditionQuery(student);

        // 获取总页数 总条数
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);

        log.info("总条数："+pageInfo.getTotal());
        log.info("总页数: "+pageInfo.getPages());
        log.info("分页查询结果："+pageInfo.getList());
        if (studentList!=null && !studentList.isEmpty()){
            // 返回前端数据有  studentList  total
            HashMap<String,Object> map = new HashMap();
            map.put("list",studentList);
            map.put("total",pageInfo.getTotal());

            return map;
        }
        return null;
    }


}
