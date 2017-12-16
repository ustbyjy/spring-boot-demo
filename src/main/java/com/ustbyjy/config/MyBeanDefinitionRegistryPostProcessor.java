package com.ustbyjy.config;

import com.ustbyjy.domain.Demo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //bean 的名称生成器.
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory()");
    }


    /**
     * 先执行：postProcessBeanDefinitionRegistry()方法，
     * 再执行：postProcessBeanFactory()方法。
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");

        // 注入bean
        registerBean(registry, "demo1", Demo.class);
        registerBean(registry, "demo2", Demo.class);
    }


    /**
     * 提供公共的注册方法。
     *
     * @param registry
     * @param name
     * @param beanClass
     */
    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);

        // 可以自动生成name
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry));

        // bean注册的holder类
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);

        // 使用bean注册工具类进行注册.
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
    }
}
