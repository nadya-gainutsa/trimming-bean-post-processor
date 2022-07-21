package org.trimming;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.trimming.annotation.Trimmed;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var type = bean.getClass();

        if (type.isAnnotationPresent(Trimmed.class)) {
            var enhancer = new Enhancer();

            enhancer.setSuperclass(type);
            MethodInterceptor methodInterceptor = (o, method, args, methodProxy) -> {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof String) {
                        args[i] = String.valueOf(args[i]).trim();
                    }

                }
                var returnValue = methodProxy.invokeSuper(o, args);
                if (returnValue instanceof String) {
                    return (String) ((String) returnValue).trim();
                }
                return returnValue;
            };
            enhancer.setCallback(methodInterceptor);
            return enhancer.create();
        }

        return bean;
    }
}
