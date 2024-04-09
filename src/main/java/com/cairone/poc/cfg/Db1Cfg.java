package com.cairone.poc.cfg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = "com.cairone.poc.data.doctors",
        entityManagerFactoryRef = "entityManagerFactoryOne",
        transactionManagerRef = "db1TransactionManager")
public class Db1Cfg {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSourceOne() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOne(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceOne())
                .packages("com.cairone.poc.data.doctors")
                .build();
    }

    @Bean
    public PlatformTransactionManager db1TransactionManager(
            @Qualifier("entityManagerFactoryOne") LocalContainerEntityManagerFactoryBean entityManagerFactoryOne) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryOne.getObject()));
    }
}
