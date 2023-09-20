package cn.dhx.function_java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author daihongxin
 * @create 2023/5/20 13:24
 */
@Slf4j
public class StreamDemo {

    @Test
    public void fun1() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(System.out::println);
    }

    @Test
    public void createStream() {

        //单例集合
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //数组
        Integer[] arr = {1, 2, 3};
        Stream<Integer> stream1 = Arrays.stream(arr);
        Stream<Integer> stream2 = Stream.of(arr);

        //双列集合
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aa", 10);
        map.put("bb", 20);
        Stream<Map.Entry<String, Integer>> stream3 = map.entrySet().stream();
    }


    //打印所有姓名长度大于1的作家的姓名
    @Test
    public void filter() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(System.out::println);
    }


    //打印所有作家的姓名
    @Test
    public void map() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .map(Author::getName)
                .forEach(System.out::println);
    }

    @Test
    public void map2() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .map(Author::getAge)
                .map(age -> age + 10)
                .forEach(System.out::println);
    }

    @Test
    public void map3() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .map(author -> {
                    author.setAge(author.getAge() * 2);
                    return author;
                })
                .forEach(System.out::println);
    }

    @Test
    public void map3Peek() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .peek(author -> author.setAge(author.getAge() * 2))
                .forEach(System.out::println);
    }



    @Test
    public void distinct() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    @Test
    public void sorted() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("----");
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .forEach(System.out::println);

        System.out.println("----");
        authors.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Author::getAge))
                .forEach(System.out::println);

    }


    //对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
    @Test
    public void limit() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(System.out::println);
    }


    //打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
    @Test
    public void skip() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1)
                .forEach(System.out::println);
    }


    //打印所有书籍的名字。要求对重复的元素进行去重。
    @Test
    public void flatMap() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));

    }

    //打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情     爱情
    @Test
    public void flatMap2() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void map_flatMap() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .map(Author::getBooks)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("----------------");
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .forEach(System.out::println);
    }

    @Test
    public void forEach() {
        List<Author> authors = Author.getAuthors();
        authors.stream()
                .forEach(System.out::println);
    }

    @Test
    public void count() {
        List<Author> authors = Author.getAuthors();
        long count = authors.stream().count();
        System.out.println(count);
    }

    //分别获取这些作家的所出书籍的最高分和最低分并打印
    @Test
    public void max_min() {
        List<Author> authors = Author.getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max(((o1, o2) -> o1 - o2));

        System.out.println(max.get());

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .min(((o1, o2) -> o1 - o2));

        System.out.println(min.get());
    }

    @Test
    public void collect() {
        List<Author> authors = Author.getAuthors();
        List<Book> list = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toList());
        System.out.println(list);


        Set<Book> set = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());

        System.out.println(set);

        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, author -> author.getBooks()));

        System.out.println(map);
    }

    // 判断是否有年龄在29以上的作家
    @Test
    public void anyMatch() {
        List<Author> authors = Author.getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(b);
    }


    //   判断是否所有的作家都是成年人
    @Test
    public void allMatch() {
        List<Author> authors = Author.getAuthors();
        boolean b = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(b);
    }


    // 判断作家是否都没有超过100岁的。
    @Test
    public void noneMatch() {
        List<Author> authors = Author.getAuthors();
        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b);
    }


    @Test
    public void findAny() {
        List<Author> authors = Author.getAuthors();
        Optional<Author> any = authors.stream()
                .filter(author -> author.getAge() > 18)
                .findAny();

        if (any.isPresent()) {
            System.out.println(any.get());
        }else {
            System.out.println("Optional null");
        }
    }


    //        获取一个年龄最小的作家，并输出他的姓名。
    @Test
    public void findFirst() {
        List<Author> authors = Author.getAuthors();
        Optional<Author> first = authors.stream()
                .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
                .findFirst();
        first.ifPresent(System.out::println);
    }

    @Test
    public void reduce() {
        List<Author> authors = Author.getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, ((result, age) -> result + age));

        System.out.println(reduce);


        Integer reduce2 = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, (Integer::sum));
    }

    @Test
    public void reduce2() {
        List<Author> authors = Author.getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(Integer.MIN_VALUE, ((result, element) -> result > element ? result : element));
        System.out.println(reduce);
    }

    @Test
    public void reduce3() {
        List<Author> authors = Author.getAuthors();
        Optional<Integer> reduce = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce((result, element) -> result > element ? result : element);
        reduce.ifPresent(System.out::println);
    }

    @Test
    public  void test27() {

        List<Author> authors = Author.getAuthors();
        authors.stream()
                .mapToInt(Author::getAge)
                .map(age -> age + 10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);



        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);
    }


    @Test
    public void sort() {
        List<Author> authors = Author.getAuthors();
        authors.forEach(System.out::println);
        System.out.println("----------------");
        authors.stream().sorted(Comparator.comparingInt(Author::getAge))
                .forEach(System.out::println);

        System.out.println("---------------------");
        // 逆序
        authors.stream().sorted(Comparator.comparingInt(Author::getAge).reversed())
                .forEach(System.out::println);
    }
}
