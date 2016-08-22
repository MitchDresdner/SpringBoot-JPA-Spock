package com.mjd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mjd.controller.ReaderHandlerMethodArgumentResolver;


@SpringBootApplication
public class ReadingListApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ReadingListApplication.class, args);
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/login").setViewName("login");
    }
    
    @Override
    public void addArgumentResolvers(
        List<HandlerMethodArgumentResolver> argumentResolvers) {
      argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
    }
    

    /* Overrides Spring property prefix: spring.datasource
	@Bean
	@ConfigurationProperties(prefix="jdbc")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
*/
    
}
