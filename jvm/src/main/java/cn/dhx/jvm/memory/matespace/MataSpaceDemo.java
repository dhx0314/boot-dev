package cn.dhx.jvm.memory.matespace;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/6/5 21:31
 */
@Slf4j
public class MataSpaceDemo extends ClassLoader{


    /**
     * 演示元空间内存溢出 java.lang.OutOfMemoryError: Metaspace
     * -XX:MaxMetaspaceSize=8m
     *
     * -XX:MaxMetaspaceSize=8m  -XX:-UseCompressedClassPointers  禁用压缩类指针
     */
    public static void main(String[] args) {
        int j = 0;
        try {
            MataSpaceDemo test = new MataSpaceDemo();
            for (int i = 0; i < 10000; i++, j++) {
                // ClassWriter 作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                // 版本号， public， 类名, 包名, 父类， 接口
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                // 返回 byte[]
                byte[] code = cw.toByteArray();
                // 执行了类的加载
                test.defineClass("Class" + i, code, 0, code.length); // Class 对象
            }
        } finally {
            System.out.println(j);
        }
    }
}
