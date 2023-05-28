package cn.dhx.juc.share.unlocked.cas.unsafe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author daihongxin
 * @create 2023/5/28 14:20
 */
@Slf4j
public class UnsafeDemo {


    public static void main(String[] args) throws NoSuchFieldException {
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        Field id = Student.class.getDeclaredField("id");
        Field name = Student.class.getDeclaredField("name");
        long idOffSet = UnsafeAccessor.unsafe.objectFieldOffset(id);
        long nameOffSet = UnsafeAccessor.unsafe.objectFieldOffset(name);

        Student student = new Student();
        UnsafeAccessor.unsafe.compareAndSwapInt(student, idOffSet, 0, 20);
        UnsafeAccessor.unsafe.compareAndSwapObject(student, nameOffSet, null, "lisi");

        System.out.println(student);
    }

}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    volatile int id;
    volatile Student name;


}