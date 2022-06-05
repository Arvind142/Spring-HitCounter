package com.personal.HitCounter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class PersistenceConfigurator {

    // few variables required tohold db creds

    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;

    /***
     * Datasource builder created to manually create datasource and perform check on jdbc url
     * @return DataSource
     */
    @Bean
    public DataSource setDataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();

        // check if given url contains jdbc appended before, else add it here!
        if(!jdbcUrl.startsWith("jdbc:postgresql://")){
            jdbcUrl="jdbc:postgresql://"+jdbcUrl;
        }

        // creating DataSource
        builder.url(jdbcUrl).username(username).password(password).driverClassName(driverClass);

        // builder.build to return Datasource for database connectivity
        return builder.build();
    }
}
