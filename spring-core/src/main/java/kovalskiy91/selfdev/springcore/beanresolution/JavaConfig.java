package kovalskiy91.selfdev.springcore.beanresolution;

import org.springframework.context.annotation.Bean;

public class JavaConfig {

    @Bean({"aService", "aService1", "aService2"})
    public Service service() {
        return new Service();
    }

}
