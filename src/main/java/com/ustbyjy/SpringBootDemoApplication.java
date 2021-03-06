package com.ustbyjy;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ustbyjy.interceptor.MyInterceptor1;
import com.ustbyjy.interceptor.MyInterceptor2;
import com.ustbyjy.servlet.MyServlet1;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

/**
 * SpringBootApplication注解申明让Spring Boot自动给程序进行必要的设置，
 * 等价于以默认属性使用@Configuration、@EnableAutoConfiguration、@ComponentCan
 */
@SpringBootApplication
@EnableAsync
@ServletComponentScan
// 使用@ComponentScan注解可以指定扫描的包，默认会扫描启动类同包以及子包下的注解
//@ComponentScan(basePackages = "com.ustbyjy")
public class SpringBootDemoApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        // 默认调用方法
//        SpringApplication.run(SpringBootDemoApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringBootDemoApplication.class);

        // 自定义Banner显示方式，Banner.Mode.OFF:关闭，Banner.Mode.CONSOLE:控制台输出，默认方式，Banner.Mode.LOG:日志输出方式
        springApplication.setBannerMode(Banner.Mode.CONSOLE);

        ApplicationContext applicationContext = springApplication.run(args);
        // 打印所有创建的bean
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("所有bean的个数：" + beanNames.length);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        String[] serviceBeanNames = applicationContext.getBeanNamesForAnnotation(Service.class);
        System.out.println("所有service的个数：" + serviceBeanNames.length);
        for (String beanName : serviceBeanNames) {
            System.out.println(beanName);
        }
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        // 1KB、10MB
        multipartConfigFactory.setMaxFileSize("100KB");
        multipartConfigFactory.setMaxRequestSize("1MB");
//        multipartConfigFactory.setLocation("doc");

        return multipartConfigFactory.createMultipartConfig();
    }

    @Bean
    public HttpMessageConverters httpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }

    @Bean
    public ServletRegistrationBean MyServlet1() {
        return new ServletRegistrationBean(new MyServlet1(), "/my_servlet1/*");
    }

    /**
     * 注入自定义拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 自定义资源映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/res/**").addResourceLocations("classpath:/res/");
        super.addResourceHandlers(registry);
    }

    /**
     * 如果继承 WebMvcConfigurationSupport，会导致静态资源无法访问
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 设置是否使用后缀模式匹配，如"/user"是否匹配"/user.*"，默认true
        configurer.setUseSuffixPatternMatch(false);
        // 设置是否使用反斜杠匹配，如"/user"是否匹配"/user/"，默认true
        configurer.setUseTrailingSlashMatch(true);
    }

    /**
     * 使用FastJson处理json数据
     *
     * @param converters
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//
//        converters.add(fastConverter);
//    }

}
