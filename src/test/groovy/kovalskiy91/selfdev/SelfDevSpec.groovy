package kovalskiy91.selfdev

import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import spock.lang.Specification

@SpringBootTest
@Import(SelfDevSpecConfig)
class SelfDevSpec extends Specification {

    @Autowired
    Sql sql

    def contextLoads() {
        expect:
        true
    }

}
