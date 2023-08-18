package cn.dhx.function_java8.method;

import cn.dhx.function_java8.stream.Author;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/6/2 15:55
 */
@Slf4j
public class MethodReference {

    @Test
    public void fun1() {
        List<Author> authors = Author.getAuthors();
        authors.stream().distinct()
                .map(Author::getAge)
                .map(String::valueOf)
                .forEach(System.out::println);


        authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .map(age->String.valueOf(age))
                .forEach(age-> System.out.println(age));
    }

    @Test
    public void fun2() {
        List<Author> authors = Author.getAuthors();
        authors.stream().distinct().map(Author::getName).map(name -> new StringBuffer(name))
                .forEach(System.out::println);

        authors.stream().distinct().map(Author::getName).map(StringBuffer::new)
                .forEach(System.out::println);
    }
}
