package cn.dhx.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/9/25 12:20
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttrGroupRelationVo {

    private Long attrId;

    private Long attrGroupId;

}
