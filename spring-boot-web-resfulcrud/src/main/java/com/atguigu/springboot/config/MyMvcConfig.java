package com.atguigu.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {



    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        /**
         * 添加视图映射（把某个路径映射到，具体的静态资源文件）
         *
         * 原理：springboot 的{@link org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration}
         * 会自动添加所有的webMvcConfigurer{@link org.springframework.web.servlet.config.annotation.WebMvcConfigurerComposite}，
         * 所以自己写个类继承 {@link WebMvcConfigurer}，用@Bean 添加到 ioc 中，springboot自动配置类就会让自个的springMVC配置类起作用时候
         * 把个人添加的配置类也添加进来了，springboot自动配置springMVC的类为：
         * {@link WebMvcAutoConfiguration.EnableWebMvcConfiguration}
         */
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/suc").setViewName("success");
            }

            /**
             * 注册添加的拦截器
             * addPathPatterns() 拦截的请求 '/**'意思是拦截任意 路径下的任意请求
             * excludePathPatterns() 排除拦截的请求，登录页面肯定不能拦截
             *
             * 那么静态资源呢？springboot已经做好了静态资源映射，所以不需要处理静态资源，也可以正常访问。
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
        return webMvcConfigurer;
    }
}
