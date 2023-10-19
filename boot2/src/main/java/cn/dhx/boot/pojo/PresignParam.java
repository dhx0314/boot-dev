package cn.dhx.boot.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/10/12 10:02
 */
@Slf4j
@Data
public class PresignParam {

    // 桶名
    private String bucket;

    // 文件名
    private String filename;
}
