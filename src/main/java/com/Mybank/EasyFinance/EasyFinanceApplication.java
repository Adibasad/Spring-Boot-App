package com.Mybank.EasyFinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan("com.Mybank.EasyFinance.*")
public class EasyFinanceApplication extends SpringBootServletInitializer {

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
//		return applicationBuilder.sources(EasyFinanceApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(EasyFinanceApplication.class, args);
	}

}
