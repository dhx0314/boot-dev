package cn.dhx.jvm.ClassLoader02;

import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/4/2 16:39
 */
public class ClassLoaderDemo {

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) { //同步操作,保证只能加载一次
            // First, check if the class has already been loaded
            // 判断缓存中是否已经加载同名的类
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                try {
                    // 获取当前类加载器的父类加载器
                    if (parent != null) {
                        // 如果存在父类加载器,则调用父类加载器进行类的加载
                        c = parent.loadClass(name, false);
                    } else {
                        // parent 为null  父类加载器是引导类加载器
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }

                if (c == null) {  //当前类的加载器的父类加载器未加载此类 or 当前类的加载器未加载此类 (启动类加载器未加载)
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    // 调用当前ClassLoader的findClass()
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) { //是否进行解析操作
                resolveClass(c);
            }
            return c;
        }
    }

}
