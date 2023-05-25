package cn.dhx.nio.filechannel;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author daihongxin
 * @create 2023/5/25 20:49
 */
@Slf4j
public class PathDemo {

    @Test
    public void Paths() {
        Path path = Paths.get("nio/data.txt");
        Path projects = Paths.get("d:\\data", "projects"); // 代表了  d:\data\projects
        System.out.println(path);
    }


    @Test
    public void filePath() throws IOException {
        Path path = Paths.get("C:\\D\\gitee\\boot-dev\\netty\\src");
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        AtomicInteger jarFileCount = new AtomicInteger();
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                dirCount.incrementAndGet();
                System.out.println(dir);
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                fileCount.incrementAndGet();
                System.out.println(file);
                String name = file.toFile().getName();
                if (name.endsWith(".java")) {
                    jarFileCount.incrementAndGet();
                }
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("=======================>");
                return super.postVisitDirectory(dir, exc);
            }
        });
        System.out.println("fileCount: " + fileCount);
        System.out.println("dirCount: " + dirCount);
        System.out.println("jarFileCount: " + jarFileCount);
    }


    @Test
    public void deletePath() throws IOException {
        Path path = Paths.get("C:\\D\\a\\demo");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return super.postVisitDirectory(dir, exc);
            }
        });
    }

    @Test
    public void delete() throws Exception {
        String from = "C:\\D\\a\\0522";
        String to = "C:\\D\\a\\0522_bak";
        Files.walk(Paths.get(from)).forEach(path -> {
            try {
                String targetName = path.toString().replace(from, to);
                if (Files.isDirectory(path)) {
                    Files.createDirectory(Paths.get(targetName));
                } else if (Files.isRegularFile(path)) {
                    Files.copy(path, Paths.get(targetName));
                }
            } catch (Exception e) {

            }
        });
    }

}
