package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //@Component 찾아서 스프링빈 등록(AppConfig는 빼고 -> @Configuration에도 @Component가 있음)
public class AutoAppConfig {
}
