package org.trimming.annotation;

import org.springframework.context.annotation.Import;
import org.trimming.TrimmedAnnotationBeanPostProcessorConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(TrimmedAnnotationBeanPostProcessorConfig.class)
public @interface EnableStringTrimming {
}
