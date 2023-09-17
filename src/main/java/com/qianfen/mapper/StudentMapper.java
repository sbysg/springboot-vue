package com.qianfen.mapper;

import com.qianfen.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


/**
 * java2310 相关增删改查
 * /可以加 @Mapper注解 或者 全包扫描
 *      配置mybatis的包扫描器 @MapperScan(value = "com.qianfen.mapper")
 * @author hxq
 * @version 1.0
 * @date 2023/9/1 21:22 星期五
 */
@SuppressWarnings("all")
public interface StudentMapper {

    /**
     * 查询所有学生
     *
     * @return list学生对象集合
     */
    @Select("select * from java2310")
    List<Student> findAllStudent();

    /**
     * 根据id查找学生
     * @param id
     * @return 学生对象
     */
    @Select("select * from java2310 where id = #{id}")
    Student findStudentById(int id);

    /**
     * 增加学生
     * 返回的受影响行数
     * @param student
     * @return 受影响行数
     */
    @Insert("insert into java2310 (name,sex,age,height,date_time) values(#{name},#{sex},#{age},#{height},#{dateTime})")
    @Results({
            @Result(column = "date_time", property = "dateTime")
    })
    int  addStudent(Student student);

    /**
     * 根据id 删除学生
     * @param id
     * @return 受影响行数
     */
    @Delete("delete from java2310 where id = #{id}")
    int deleteStudentById(int id);

    /**
     * 更新学生
     * 返回受影响行数
     * @param student
     * @return 受影响行数 row
     */
    @Update("update java2310 set name = #{name}, age = #{age}, sex = #{sex}," +
            " height = #{height}, date_time = #{dateTime} where id = #{id}")
    @Results({
            @Result(column = "date_time", property = "dateTime")
    })
    int  updateStudentById(Student student);



    /**
     * 查询 性别 对应的平均身高  年龄
     * @return
     */
    @Select("select sex, avg(height) avg_height, avg(age) avg_age from java2310 group by sex")
    List<Map<String, Object>> getAvgAgeAndHeightBySex();

    /**
     * 根据条件查找学生集合
     * @return 学生对象list集合
     * @param student 学生对象
     */
    List<Student> conditionQuery(Student student);

    /**
     * 根据条件查找学生集合
     * @return 学生对象Map集合
     */
    List<Map<String, Object>> studentMapList();

    /**
     * 查询所有学生 并包含对应的成绩
     * @return
     */
    List<Student> findAllStudentWithScore();


}
