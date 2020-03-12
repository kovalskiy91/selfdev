package kovalskiy91.selfdev

import groovy.sql.Sql
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

import javax.sql.DataSource

@TestConfiguration
class SelfDevSpecConfig {

    @Bean
    Sql sql(DataSource dataSource) {
        new Sql(dataSource)
    }

}
