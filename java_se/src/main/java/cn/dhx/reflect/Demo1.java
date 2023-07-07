package cn.dhx.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @Author daihongxin
 * @create 2023/7/7 10:31
 */
@Slf4j
public class Demo1 {

    public static void main(String[] args) throws Exception {


        Student student = new Student("list", 12, "aa");
        extracted(student);
        System.out.println("-----------------------");
        Teacher teacher = new Teacher("zhangsan", 10000);
        extracted(teacher);
    }

    private static void extracted(Object obj) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            Object o = declaredField.get(obj);
            map.put(name, o);
        }

        map.forEach((k,v)->{
            log.info("key {} value {}",k,v);
        });
    }
}
