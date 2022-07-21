**Implement @EnableStringTrimming magic**

1. Create a new maven project
2. Create annotation @Trimmed that you can put on class
3. Create annotation @EnableStringTrimming
    - it should enable automatic Spring trimming for all beans that are annotated with @Trimmed
    - so if I pass  "  Hello " as argument to my bean’s method, or return it from the bean’s method, it gets automatically trimmed to "Hello"
4. Implement TrimmedAnnotationBeanPostProcessor that 
    - looks for beans that are marked with @Trimmed
    - creates a proxy of those classes, and override methods (trim all String arguments and trim all String return values)
5. Extract  TrimmedAnnotationBeanPostProcessor into a separate StringTrimmingConfiguration that is imported by @EnableStringTrimming
6. Verify that the automatic logic is only applied when you put @EnableStringTrimming
