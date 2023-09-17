package com.qianfen.mapper;

import com.qianfen.entity.Score;

import java.util.List;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/4 11:45 星期一
 */


public interface ScoreMapper {

    /**
     * 查询所有成绩包含学生
     * @return
     */
    List<Score> findAllScoreWithStudent();

}
