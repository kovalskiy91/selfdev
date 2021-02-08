package kovalskiy91.selfdev.springcore.beanresolution

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import spock.lang.Shared
import spock.lang.Specification

class AnnotationConfigSpec extends Specification {
    @Shared
    def context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

    void "should resolve bean by custom name"() {
        expect:
        context.getBean("aService")
    }

    //annotation approach does not support aliases

    void "should resolve bean by bean class"() {
        expect:
        context.getBean(Service)
    }

    void "should resolve bean by bean interfaces"() {
        expect:
        context.getBean(Reader)
        context.getBean(Writer)
    }


}
