package cn.dhx.function_java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author daihongxin
 * @create 2023/9/4 16:11
 */
@Slf4j
public class MyStream {

    @Test
    public void funCollectorsGroupingBy() {
        List<User> users = Arrays.asList(
                new User("Jack", 9),
                new User("Kreas", 10),
                new User("Kreas_Demo2", 10),
                new User("Marry", 13),
                new User("Timi", 14));

        Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getAge));
        Map<String, List<User>> map1 = users.stream().collect(Collectors.groupingBy(i -> i.getAge() + "_" + "年龄"));
        Map<String, List<User>> map2 = users.stream().collect(Collectors.groupingBy(i -> {
            if (i.getAge() < 10) {
                return "young";
            } else {
                return "old";
            }
        }));

        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);


    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private String name;
    private int age;
}