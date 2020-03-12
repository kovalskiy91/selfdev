package kovalskiy91.selfdev

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SelfDevSpecification extends Specification {

    def contextLoads() {
        expect:
        true
    }

}
