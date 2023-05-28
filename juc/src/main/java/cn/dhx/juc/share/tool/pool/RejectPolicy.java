package cn.dhx.juc.share.tool.pool;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/28 16:44
 */
@FunctionalInterface
public interface RejectPolicy<T> {

    void reject(BlockedQueue<T> queue, T task);
}
