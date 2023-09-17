package com.qianfen.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 加入到容器中的bean 初始化属性的两种方式
 *   1.批量初始化
 *       /@ConfigurationProperties(prefix = "aliyun")
 *      作用：批量读取配置文件中以 aliyun开头的属性，配置到对应创建bean的属性中
 *    2. 单个读取属性
 * @author hxq
 * @version 1.0
 * @date 2023/9/6 14:18 星期三
 */
@ConfigurationProperties(prefix = "aliyun")
@Component
@Data
public class AliYunYml implements Serializable {
    /**
     * key
     */
    private String accessKey;
    /**
     *秘钥
     */
    private String accessSecret;
}
