package com.qianfen.controller;

import com.qianfen.common.R;
import com.qianfen.entity.Score;
import com.qianfen.mapper.ScoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hxq
 * @version 1.0
 * @date 2023/9/13 16:09 星期三
 */

@Slf4j
@CrossOrigin
@RestController
public class ScoreController {

    @Resource
    private ScoreMapper scoreMapper;

    @RequestMapping("/findAllScoreWithStudent")
    public R<List<Score>> findAllScoreWithStudent(){
        List<Score> allScoreWithStudent = scoreMapper.findAllScoreWithStudent();
        // 查到相关数据
        if (allScoreWithStudent!=null && !allScoreWithStudent.isEmpty()){
            return R.success(allScoreWithStudent);
        }
        return R.error("数据不存在");
    }

}
