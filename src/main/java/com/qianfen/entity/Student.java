package com.qianfen.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 学生类
 * /@Setter/@Getter/@ToString
 * 以上三个等价于@Data
 * 自动生成 set get toString方法
 * 所有参数构造方法// 无惨构造
 * @author hxq
 * @version 1.0
 * @date 2023/9/11 22:08 星期一
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student implements Serializable {
    /**
     * 学生id
     */
    private Integer id;
    /**
     * 学生名字
     */
    private String name;
    /**
     * 学生性别
     */
    private String sex;
    /**
     * 学生年龄
     */
    private Integer age;
    /**
     * 学生身高
     */
    private Float height;
    //只要遇到时间都加时间转换注解响应
    /* JsonFormat
     *      1.当处理器方法返回对象时，将java.utils.Date 转化为对应的字符串 2023-08-31接收
     *      2.如果前端提交的json字符串 使用java对象接收    字符串2023-08-31 转化为java.utils.Date类型
     *  DateTimeFormat 将前端提交的键值对的时间字符串2023-08-31 转化为java.utils.Date类型
     */
    /**
     * 学生生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTime;

    /**
     * 将score对象作为 student属性放入list
     */
    private List<Score> scoreList;
//
//    private List<Role> roleList;

}