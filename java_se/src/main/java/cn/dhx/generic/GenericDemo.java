package cn.dhx.generic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author daihongxin
 * @create 2023/9/8 15:07
 */
@Slf4j
public class GenericDemo {

    @Test
    public void fun1() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("caka");
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(100);
        System.out.println("arrayList1类型为:" + arrayList1.getClass());
        System.out.println("arrayList2类型为:" + arrayList2.getClass());
        System.out.println(arrayList1.getClass() == arrayList2.getClass());

    }

    @Test
    public void fun2() throws Exception {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("caka");

        System.out.println(arrayList1);
        Class<? extends ArrayList> aClass = arrayList1.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.invoke(arrayList1, 1);
        System.out.println(arrayList1);


    }
}
