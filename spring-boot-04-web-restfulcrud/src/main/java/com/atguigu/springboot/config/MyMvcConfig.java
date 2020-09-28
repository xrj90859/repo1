package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc   //全面接管SpringBoot的自动配置，让其配置失效
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    public  void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
    }

    @Bean//将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            public  void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override//注册拦截器
            //注： SpringBoot已经做好了静态资源的映射，谢拦截器不需要管静态资源
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //对 /** 的都拦截，对 "/index.html","/","/user/login","/static/" 放行
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/ststic/");
            }
        };
        return adapter;
    }
}
