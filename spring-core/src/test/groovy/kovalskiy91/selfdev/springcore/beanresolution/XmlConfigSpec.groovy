package kovalskiy91.selfdev.springcore.beanresolution


import org.springframework.context.support.ClassPathXmlApplicationContext
import spock.lang.Shared
import spock.lang.Specification

class XmlConfigSpec extends Specification {
    @Shared
    def context = new ClassPathXmlApplicationContext("beanresolution.xml");

    void "should resolve bean by custom name"() {
        expect:
        context.getBean("aService")
    }

    void "should resolve bean by aliases"() {
        expect:
        context.getBean("aService1")
        context.getBean("aService2")
        context.getBean("aService3")
    }

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
