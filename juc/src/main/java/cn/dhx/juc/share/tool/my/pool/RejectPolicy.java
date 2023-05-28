package cn.dhx.juc.share.tool.my.pool;

/**
 * @Author daihongxin
 * @create 2023/5/28 16:44
 */
@FunctionalInterface
public interface RejectPolicy<T> {

    void reject(BlockedQueue<T> queue, T task);
}
