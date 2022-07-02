package cn.dhx.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class MyStream {


    @Test
    public void fun1() {
        ArrayList<String> arrayList = new ArrayList<>();
        Stream<String> stream = arrayList.stream();

        HashSet<String> hashSet = new HashSet<>();
        Stream<String> stream1 = hashSet.stream();

        HashMap<String, String> hashMap = new HashMap<>();
        Set<String> keySet = hashMap.keySet();
        Stream<String> stream2 = keySet.stream();
        Collection<String> values = hashMap.values();
        Stream<String> stream3 = values.stream();

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        Stream<Map.Entry<String, String>> stream4 = entries.stream();
    }

    @Test
    public void fun2() {

        String[] strArr={"aa","vv","cc"};
        Stream<String> strArr1 = Stream.of(strArr);

        Integer[] integer={1,2,3};
        Stream<Integer> integer1 = Stream.of(integer);

        // 不能操作基本数据类型,会将整个数组堪称一个元素进行操作
        int[] ints={1,2,3};
        Stream<int[]> ints1 = Stream.of(ints);
    }
}
