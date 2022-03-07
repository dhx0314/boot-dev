package cn.dhx.boot.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;


public class FileCacheUtil {

    private static final ConcurrentHashMap<String, String> fileHashMap = new ConcurrentHashMap<>();

    private static ReentrantLock lock = new ReentrantLock();

    public static synchronized String getOrUpdate(String path) {

        String result = fileHashMap.get(path);
        if (result == null) {
            fileHashMap.put(path, "ok");
        }
        return result;
    }
}
