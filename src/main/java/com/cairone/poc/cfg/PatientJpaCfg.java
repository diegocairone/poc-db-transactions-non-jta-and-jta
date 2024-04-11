package com.cairone.poc.cfg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.cairone.poc.data.patients",
        entityManagerFactoryRef = "patientEmf",
        transactionManagerRef = "transactionManager")
public class PatientJpaCfg {

    @Bean
    public EntityManagerFactoryBuilder patientEntityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
                new HibernateJpaVendorAdapter(), jpaProperties(), null);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean patientEmf(
            @Qualifier("patientEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
            @Qualifier("patientDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.cairone.poc.data.patients")
                .persistenceUnit("doctors")
                .jta(true)
                .properties(jpaProperties())
                .build();
    }

    public Map<String, String> jpaProperties() {
        Map<String, String> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.hbm2ddl.auto", "none");
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        jpaProperties.put("javax.persistence.transactionType", "JTA");
        return jpaProperties;
    }
}
