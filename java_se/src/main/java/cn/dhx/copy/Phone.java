package cn.dhx.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author daihongxin
 * @create 2023/8/14 15:10
 */
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Phone implements Serializable {

    private String name;


}
