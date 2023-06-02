package cn.dhx.function.optional;

import cn.dhx.function.stream.Author;
import cn.dhx.function.stream.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author daihongxin
 * @create 2023/6/1 16:11
 */
@Slf4j
public class OptionalDemo {

    public static Author getAuthor() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        author.setBooks(books1);
        return author;
    }

    @Test
    public void create() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        Optional<Author> author1 = Optional.of(getAuthor());
        Optional<Object> empty = Optional.empty();
    }

    @Test
    public void consumer() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        author.ifPresent(author1 -> System.out.println(author1.getAge()));
    }

    @Test
    public void get() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        //可能存在null
        Author author1 = author.get();
        System.out.println(author1.getName());


        Optional<Author> authorOptional = Optional.ofNullable(getAuthor());
        Author author2 = authorOptional.orElseGet(Author::new);


        try {
            Optional<Object> empty = Optional.empty();
            Object optional_error = empty.orElseThrow(() -> {
                return new RuntimeException("optional error");
            });
        } catch (Exception e) {
            log.error("error");
        }
    }

    @Test
    public void filter() {
        Optional<Author> author0 = Optional.ofNullable(getAuthor());
        author0.filter(author -> author.getAge() > 10).ifPresent(author1 -> System.out.println(author1.getName()));
    }

    @Test
    public void ifPresent() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        if (author.isPresent()) {
            System.out.println(author.get().getName());
        }
    }


    @Test
    public void map() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        Optional<List<Book>> books = author.map(authors2 -> authors2.getBooks());
        books.ifPresent(books1 -> System.out.println(books1));
    }
}
