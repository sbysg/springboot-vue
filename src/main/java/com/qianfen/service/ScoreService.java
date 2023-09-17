package com.qianfen.service;

import com.qianfen.entity.Score;

import java.util.List;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/4 14:32 星期一
 */

public interface ScoreService {

    /**
     * 查询所有成绩包含学生
     * @return list集合
     */
    List<Score> findAllScoreWithStudent();
}
