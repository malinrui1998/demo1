package com.mlr.demo1.config;

import com.mlr.demo1.interceptor.LoginInterceptor;
import com.mlr.demo1.resolver.UserIdArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;

    @Resource
    UserIdArgumentResolver userIdArgumentResolver;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)//添加拦截器
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userIdArgumentResolver);
    }

    //    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//        .addResourceHandler("swagger-ui.html")
//        .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("doc.html")
//        .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//        .addResourceLocations("classpath:/META-INF/resources/webjars/")
//        .addResourceLocations("/index.jsp");
//        registry.addResourceHandler("/upload/**").
//                addResourceLocations("file:D:/Users/mlr");
//
//    }

}

