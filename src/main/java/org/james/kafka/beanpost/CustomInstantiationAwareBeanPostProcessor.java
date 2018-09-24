package org.james.kafka.beanpost;

import org.james.kafka.entity.CustomBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

@Component
public class CustomInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    public CustomInstantiationAwareBeanPostProcessor() {
        super();
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) {
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return super.getEarlyBeanReference(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (CustomBean.class.isAssignableFrom(beanClass)) {
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }

        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof CustomBean) {
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (bean instanceof CustomBean) {
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CustomBean) {
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessBeforeInitialization");
        }

        return super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CustomBean) {
            System.out.println("CustomInstantiationAwareBeanPostProcessor.postProcessAfterInitialization");
        }

        return super.postProcessAfterInitialization(bean, beanName);
    }
}
