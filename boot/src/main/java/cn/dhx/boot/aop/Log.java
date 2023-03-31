package cn.dhx.boot.aop;

import java.lang.annotation.*;

/**
 * @author : zhouhailin
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

}
