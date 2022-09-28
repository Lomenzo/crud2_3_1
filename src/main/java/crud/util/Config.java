// Этот класс потребуется для Spring Boot   (сделан через LocalContainerEntityManagerFactoryBean)

/*
package crud.util;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@PersistenceContext
@ComponentScan(value = "crud")
public class Config {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean lfb() {

        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(getDataSource());

        Properties settings = new Properties();
        settings.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        settings.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        lfb.setJpaProperties(settings);
        //lfb.setPackagesToScan( "crud" );
        lfb.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
        //lfb.setPersistenceUnitName( "crudUser" );
        lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lfb.afterPropertiesSet();
        //EntityManagerFactory emf = lfb.getObject();
        return lfb;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(lfb().getObject());
        return transactionManager;
    }
}
*/