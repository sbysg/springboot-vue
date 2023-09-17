package com.qianfen.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/4 11:40 星期一
 */
@Data
public class Score implements Serializable {

    /**
     * 成绩id
     */
    private Integer id;

    /**
     * 学科
     */
    private String course;

    /**
     * 分数
     */
    private Float score;

    /**
     * 学生id
     */
    private Integer studentId;


    /**
     *一对一 一个成绩只归属于一个学生
     */
    private Student student;

}
