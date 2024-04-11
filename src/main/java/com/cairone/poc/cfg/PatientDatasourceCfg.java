package com.cairone.poc.cfg;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.db2")
public class PatientDatasourceCfg {

    private String username;
    private String password;
    private String jdbcUrl;

    @Bean
    public DataSource patientDataSource() {

        MysqlXADataSource ds = new MysqlXADataSource();
        ds.setUser(username);
        ds.setPassword(password);
        ds.setUrl(jdbcUrl);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(ds);
        xaDataSource.setUniqueResourceName("xa_patients_db");
        xaDataSource.setMaxPoolSize(30);

        return xaDataSource;
    }
}
