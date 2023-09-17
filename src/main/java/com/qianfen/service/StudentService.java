package com.qianfen.service;

import com.github.pagehelper.PageInfo;
import com.qianfen.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/1 21:46 星期五
 */

public interface StudentService {
    /**
     * 查询所有学生
     *
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 根据id查找学生
     *
     * @param id
     * @return
     */
    Student findStudentById(int id);

    /**
     * 增加学生
     * 返回的受影响行数
     *
     * @param student
     * @return
     */
    int addStudent(Student student);


    /**
     * 测试事务 同时删除多个id
     *
     * @param id1 id
     * @param id2 id
     */
    void deleteStudentByIds(int id1, int id2);

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Student> getAllStudentByPage(int currentPage, int pageSize);

    /**
     * 根据id 删除学生
     *
     * @param id id
     * @return 受影响行数
     */
    int deleteStudentById(int id);

    /**
     * 更新学生
     * 返回受影响行数
     *
     * @param student student
     * @return 受影响行数 row
     */
    int updateStudentById(Student student);

    /**
     * 根据条件查找学生集合
     *
     * @param student 学生对象
     * @return 学生对象list集合
     */
    Map<String, Object> conditionQuery(Student student, Integer currentPage, Integer pageSize);

}
