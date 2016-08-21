package com.mjd;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReadingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}

    /* Overrides Spring property prefix: spring.datasource
	@Bean
	@ConfigurationProperties(prefix="jdbc")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
*/
    
}
