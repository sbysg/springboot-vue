package com.qianfen.service.impl;

import com.qianfen.entity.Score;
import com.qianfen.mapper.ScoreMapper;
import com.qianfen.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/4 14:32 星期一
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreMapper scoreMapper;


    @Override
    public List<Score> findAllScoreWithStudent() {
        return scoreMapper.findAllScoreWithStudent();
    }
}
