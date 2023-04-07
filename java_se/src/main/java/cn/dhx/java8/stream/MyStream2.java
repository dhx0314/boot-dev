package cn.dhx.java8.stream;

import cn.dhx.pojo.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStream2 {

    @Test
    public void forEach() {

        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "aa", "bbbb", "ccc", "dd");

        arrayList.forEach(str -> {
            System.out.println(str);
        });

        arrayList.stream().forEach(str -> {
            System.out.println(str);
        });

        long count = arrayList.stream().count();
        System.out.println(count);

    }


    // filter 过滤
    @Test
    public void filter() {

        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "aa", "bbbb", "ccc", "dd");

        arrayList.stream().filter((s -> {
            return s.length() == 3;
        })).forEach(s -> {
            System.out.println(s);
        });
        System.out.println("-------------");

        arrayList.stream().limit(2).forEach(x -> {
            System.out.println(x);
        });
        System.out.println("-------------");

        arrayList.stream().skip(2).forEach(x -> {
            System.out.println(x);
        });
    }


    //map
    @Test
    public void map() {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "11", "1234", "223", "33");

        Stream<Integer> integerStream = arrayList.stream().map((x) -> {
            return Integer.parseInt(x);
        });
        integerStream.forEach(x -> {
            System.out.println(x);
        });
    }


    //sorted 排序
    @Test
    public void sorted() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 11, 55, 1234, 223, 33);
        arrayList.stream().sorted().forEach(x -> {
            System.out.println(x);
        });

        System.out.println();
        arrayList.stream().sorted((i1, i2) -> {
            return i2 - i1;
        }).forEach(x -> {
            System.out.println(x);
        });
    }

    //distinct 去重
    @Test
    public void distinct() {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "aa", "bbbb", "ccc", "dd", "ccc");
        arrayList.stream().distinct().forEach(x -> {
            System.out.println(x);
        });


        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("aa", 18));
        list.add(new Person("cc", 20));
        list.add(new Person("dd", 18));
        list.add(new Person("aa", 18));

        //重写hashcode equals
        list.stream().distinct().forEach(x -> {
            System.out.println(x);
        });
    }

    @Test
    public void match() {

        //allMatch: 元素是否全部满足条件
        //anyMatch: 元素是否任意有一个满足条件
        //noneMatch: 元素是否全部不满足条件
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 3, 5, 9, 12);
        boolean b = arrayList.stream().allMatch((x) -> {
            return x > 6;
        });
        System.out.println(b);

        boolean b2 = arrayList.stream().anyMatch((x) -> {
            return x > 6;
        });
        System.out.println(b2);

        boolean b3 = arrayList.stream().noneMatch((x) -> {
            return x > 6;
        });
        System.out.println(b3);
    }


    //findFirst 查找第一个元素
    //
    //findAny 串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个
    @Test
    public void find() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 3, 5, 9, 12);
        Optional<Integer> first = arrayList.stream().findFirst();
        System.out.println(first.get());
        Optional<Integer> any = arrayList.stream().findAny();
        System.out.println(any.get());

    }

    @Test
    public void fun7a() throws InterruptedException {

        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                List<String> lst1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");
                List<String> lst2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");


                Optional<String> findFirst = lst1.parallelStream().filter(s -> s.startsWith("D")).findFirst();
                Optional<String> fidnAny = lst2.parallelStream().filter(s -> s.startsWith("J")).findAny();

                System.out.println(findFirst.get()); //总是打印出David
                System.out.println(fidnAny.get()); //会随机地打印出Jack/Jill/Julia
//                Optional<String> findFirst = lst1.parallelStream().findFirst();
//                Optional<String> fidnAny = lst2.parallelStream().findAny();
//                System.out.println(findFirst.get()); //总是打印出Jhonny
//                System.out.println(fidnAny.get()); //会随机地打印出Dany
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(5000);
    }

    //max 排序后最后一个值
    //min  排序后第一个值
    @Test
    public void maxAndMin() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 3, 5, 1, 22, 9, 12);
        Optional<Integer> max = arrayList.stream().max(((o1, o2) -> {
            return o1 - o2;
        }));
        System.out.println(max.get());
        Optional<Integer> min = arrayList.stream().min(((o1, o2) -> {
            return o1 - o2;
        }));
        System.out.println(min.get());
    }


    //reduce
    //将所有数据归纳得到一个数据，可以使用 reduce 方法
    @Test
    public void reduce() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 3, 5, 9, 12);
        // 将return 的结果返回给x
        Integer reduce = arrayList.stream().reduce(0, (x, y) -> {
            return x + y;
        });
        System.out.println(reduce);

        Integer reduce1 = arrayList.stream().reduce(0, (x, y) -> {
            return x > y ? x : y;
        });
        System.out.println(reduce1);
    }


    @Test
    public void reducea() {
//        Integer reduce = Stream.of(4, 5, 3, 9).reduce(0, (x, y) -> {
//            return x + y;
//        });


//        Integer reduce = Stream.of(4, 5, 3, 9).reduce(0, (x, y) -> {
//            return Integer.sum(x,y);
//        });
//        Integer reduce = Stream.of(4, 5, 3, 9).reduce(0, Integer::sum);


    }

    @Test
    public void reduce2() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("aa", 12));
        list.add(new Person("cc", 20));
        list.add(new Person("dd", 88));
        list.add(new Person("aa1", 77));

        Integer reduce = list.stream().map(o -> {
            return o.getAge();
        }).reduce(0, (x, y) -> {
            return x + y;
        });
        System.out.println(reduce);
    }


    @Test
    public void mapAndMax() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("aa", 12));
        list.add(new Person("cc", 20));
        list.add(new Person("dd", 88));
        list.add(new Person("aa1", 77));

        Optional<Integer> max = list.stream().map(o -> {
            return o.getAge();
        }).max((x, y) -> {
            return x - y;
        });
        System.out.println(max.get());
    }

    @Test
    public void fun12() {
        Stream<String> stream = Stream.of("a", "b", "c", "a", "d", "a");
        Integer a = stream.map((x) -> {
            if (x.equals("a")) {
                return 1;
            } else {
                return 0;
            }
        }).reduce(0, (x, y) -> {
            return x + y;
        });
        System.out.println(a);
    }


    @Test
    public void fun13() {
        Stream<Integer> stream = Stream.of(3, 5, 1, 22, 9, 12);
        IntStream intStream = stream.mapToInt(x -> {
            return x.intValue();
        });

        intStream.filter(x -> {
            return x > 3;
        }).forEach(x -> {
            System.out.println(x);
        });
    }


    //将流的数据收集到集合
    @Test
    public void concat() {
        Stream<String> aa = Stream.of("aa");
        Stream<String> bb = Stream.of("bb");
        Stream<String> concat = Stream.concat(aa, bb);
        //合并后 不能操作之前的流
        concat.forEach(x -> {
            System.out.println(x);
        });
    }

    @Test
    public void fun15() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "aa");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println("list " + list);
    }

    @Test
    public void fun16() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "aa");
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println("set " + set);
    }

    @Test
    public void fun17() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "aa");
        ArrayList<String> collect = stream.collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    public void fun18() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "aa");
        HashSet<String> collect = stream.collect(Collectors.toCollection(HashSet::new));
    }


    //将流中的数据收集到数组中
    @Test
    public void fun19() {
//        Stream<String> bytestream = Stream.of("aa", "bb", "cc","aa");
//        Object[] objects = bytestream.toArray();
//        System.out.println(Arrays.toString(objects));

        Stream<String> stream = Stream.of("aa", "bb", "cc", "aa");
        String[] strings = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }

}
