package com.qianfen.controller;

import com.github.pagehelper.PageInfo;
import com.qianfen.common.R;
import com.qianfen.entity.Student;
import com.qianfen.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/1 21:53 星期五
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping
public class StudentController {

    @Autowired //从容器中获取studentService
    private StudentService studentService;

    @RequestMapping("/findStudentById")
    public R findStudentById(int id) {
        Student student = studentService.findStudentById(id);
        if (student != null) {
            return R.success(student);
        }
        return R.error("查询报道啊");
    }

    @RequestMapping("/findAllStudent")
    public R<List<Student>> findAllStudent() {
        // 查询所有学生
        List<Student> allStudent = studentService.findAllStudent();
        if (allStudent != null) {
            return R.success(allStudent);
        }
        return R.error("查询报道啊");

    }

    @RequestMapping("/conditionQuery")
    public R<Map<String, Object>> conditionQuery(Student student,
                                           @RequestParam(defaultValue = "1") Integer currentPage,
                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        // 查询所有学生
        log.info("student:" + student);
        Map<String, Object> result = studentService.conditionQuery(student, currentPage, pageSize);
        if (result != null) {
            return R.success(result);
        }
        return R.error("查询报道啊");

    }

    @RequestMapping("/addStudent")
    public R addStudent(Student student) {
        int row = studentService.addStudent(student);
        if (row > 0) {
            return R.success("添加成功");
        }
        return R.error("添加失败");
    }

    @RequestMapping("/deleteStudentById")
    public R deleteStudentById(int id) {
        int row = studentService.deleteStudentById(id);
        if (row > 0) {
            return R.success("删除成功");
        }
        return R.error("该用户不存在");
    }

    @RequestMapping("/updateStudentById")
    public R updateStudentById(Student student) {
        log.info("student:" + student);
        int row = studentService.updateStudentById(student);
        if (row > 0) {
            return R.success("更新成功");
        }
        return R.error("该用户不存在");

    }


    @RequestMapping("/deleteStudentByIds")
    public Map<String, Object> deleteStudentByIds(int id1, int id2) {

        studentService.deleteStudentByIds(id1, id2);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "ok");
        return map;
    }

    /**
     * url  /getAllStudentByPage?pageIndex=1&pageSize=10
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/getAllStudentByPage")
    @ResponseBody
    public PageInfo<Student> getAllStudentByPage(int pageIndex, int pageSize) {
        // 分页查询
        PageInfo<Student> allStudentByPage = studentService.getAllStudentByPage(pageIndex, pageSize);
        return allStudentByPage;

    }
}
