package com.aut.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@EnableConfigurationProperties(ConfigProperty.class)
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
		basePackages = {"com.aut"})
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;

	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	
	public DataSource dataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		data.setUrl(env.getProperty("spring.datasource.url"));
		data.setUsername(env.getProperty("spring.datasource.username"));
		data.setPassword(env.getProperty("spring.datasource.password"));

		return data;
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {

		LocalContainerEntityManagerFactoryBean entityManagerFactory =
				builder.dataSource(dataSource).persistenceUnit("portal").build();

		entityManagerFactory.setPackagesToScan(new String[] {"com.aut"});

		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setJpaDialect(new HibernateJpaDialect());

		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		entityManagerFactory.setJpaProperties(prop);

		return entityManagerFactory;
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager barTransactionManager(

			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}