package org.trimming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrimmedAnnotationBeanPostProcessorConfig {
    @Bean
    public TrimmedAnnotationBeanPostProcessor create() {
        return new TrimmedAnnotationBeanPostProcessor();
    }
}
