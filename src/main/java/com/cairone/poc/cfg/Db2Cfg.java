package com.cairone.poc.cfg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.cairone.poc.data.patients",
        entityManagerFactoryRef = "entityManagerFactoryTwo",
        transactionManagerRef = "db2TransactionManager")
public class Db2Cfg {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSourceTwo() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTwo(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceTwo())
                .packages("com.cairone.poc.data.patients")
                .build();
    }

    @Bean
    public PlatformTransactionManager db2TransactionManager(
            @Qualifier("entityManagerFactoryTwo") LocalContainerEntityManagerFactoryBean entityManagerFactoryTwo) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryTwo.getObject()));
    }
}
