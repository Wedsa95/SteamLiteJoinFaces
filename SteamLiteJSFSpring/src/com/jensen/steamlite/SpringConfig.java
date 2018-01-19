package com.jensen.steamlite;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource) {
				
		LocalContainerEntityManagerFactoryBean entityFactory =
				new LocalContainerEntityManagerFactoryBean();
		
		Properties prop = new Properties();
		prop.setProperty("hibernate.show__sql", "true");
		
		entityFactory.setPackagesToScan("com.jensen.steamlite.model.entity");
		entityFactory.setPersistenceProvider(new HibernatePersistenceProvider());
		entityFactory.setJpaProperties(prop);
		entityFactory.setDataSource(dataSource);

		return entityFactory;
	}
	
	@Bean
	public JpaTransactionManager transaktionManager(DataSource dataSource,
			EntityManagerFactory entityManagerFactory) {
		
		JpaTransactionManager transactionManager = 
				new JpaTransactionManager(entityManagerFactory);
		transactionManager.setDataSource(dataSource);
		
		return transactionManager;
	}
	
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/steam_skin");
	    dataSource.setUsername("root");
	    dataSource.setPassword("");
	 
	    return dataSource;
	}
	
}
