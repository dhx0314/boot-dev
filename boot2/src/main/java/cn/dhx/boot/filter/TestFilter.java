package cn.dhx.boot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author daihongxin
 * @create 2023/9/12 11:08
 */
@Slf4j
@Component
@Order(1)
@WebFilter(filterName = "myFilter", urlPatterns = {"*"})
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器：执行 init 方法。");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        log.info("doFilter");
        log.info("uri {}",httpRequest.getRequestURI());
        chain.doFilter(request, response);
        log.info("过滤器：开始执行 doFilter 方法。");
        // 请求放行
//        chain.doFilter(request, response);
        log.info("过滤器：结束执行 doFilter 方法。");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
