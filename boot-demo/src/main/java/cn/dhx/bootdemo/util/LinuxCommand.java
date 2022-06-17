package cn.dhx.bootdemo.util;

import cn.dhx.bootdemo.pojo.ExecuteResult;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class LinuxCommand {
    private static final boolean isLinux = System.getProperty("os.name").startsWith("Linux");
    private static final Charset UTF8 = StandardCharsets.UTF_8;

    public static ExecuteResult execute(List<String> commands, File directory) {
        if (!isLinux) {
            return ExecuteResult.failed("Only support Linux OS!");
        }
        if (commands == null || commands.size() == 0) {
            return ExecuteResult.failed("Invalid commands: " + commands);
        }
        /*
         *  如果需要访问某个目录下的文件，那么该目录满足如下几个必要条件：
         *  1. 该目录必须存在
         *  2. 该目录具备可读和可执行权限
         */
        if (directory != null && directory.exists() && directory.isDirectory() && directory.canRead() && directory.canExecute()) {
            ProcessBuilder builder = new ProcessBuilder(commands);
            builder.directory(directory);
            Process process = null;
            StringBuilder success = new StringBuilder("");
            StringBuilder failed = new StringBuilder("");
            try {
                if (!commands.contains("status")) {
                    StringBuilder sb = new StringBuilder();
                    for (String cmd : commands) {
                        sb.append(cmd).append(" ");
                    }
                    String cmd = sb.toString();
                    log.info("begin execute command: [{}] directory: [{}]", cmd, directory.getPath());
                }
                process = builder.start();
            } catch (Exception e) {
                return ExecuteResult.failed(e);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream(), UTF8))) {
                String readLine = null;
                while ((readLine = reader.readLine()) != null) {
                    success.append(readLine).append("\n");
                }
            } catch (Exception e) {
                return ExecuteResult.failed(e);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getErrorStream(), UTF8))) {
                String readLine = null;
                while ((readLine = reader.readLine()) != null) {
                    failed.append(readLine);
                }
            } catch (Exception e) {
                return ExecuteResult.failed(e);
            }
            if (failed.length() > 0 && !failed.toString().contains("Not all processes could be identified")) {
                return ExecuteResult.failed(failed.toString());
            }
            return ExecuteResult.success(success.toString());
        } else {
            return ExecuteResult.failed("cannot access directory: " + directory);
        }
    }

}