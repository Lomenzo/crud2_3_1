package crud.config;

import crud.model.User;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.*;
import javax.persistence.spi.*;
import javax.sql.DataSource;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(value = "crud")
public class DBConfig {

    @Autowired
    private Environment env;

    @Bean()
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        Properties props = new Properties();
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(vendorAdapter());
        factoryBean.setDataSource(getDataSource());
        factoryBean.setJpaProperties(props);
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setPackagesToScan("crud.model");
        return factoryBean;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager() {
        return new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
    }

    private HibernateJpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "false");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }
//
//    @Bean
//    public EntityManagerFactory createEntityManagerFac() {
//
//        Properties props = new Properties();
//        props.put("hibernate.connection.url", env.getProperty("db.url"));
//        props.put("hibernate.connection.username", env.getProperty("db.username"));
//        props.put("hibernate.connection.password", env.getProperty("db.password"));
//
//        PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfo() {
//
//            @Override
//            public Properties getProperties() {
//                return props;
//            }
//
//            @Override
//            public List<String> getManagedClassNames() {
//                return Arrays.asList(User.class.getName());
//            }
//
//            @Override
//            public String getPersistenceUnitName() {
//                return "TestUnit";
//            }
//
//            @Override
//            public String getPersistenceProviderClassName() {
//                return HibernatePersistenceProvider.class.getName();
//            }
//
//            @Override
//            public PersistenceUnitTransactionType getTransactionType() {
//                return null;
//            }
//
//            @Override
//            public DataSource getJtaDataSource() {
//                return null;
//            }
//
//            @Override
//            public DataSource getNonJtaDataSource() {
//                return null;
//            }
//
//            @Override
//            public List<String> getMappingFileNames() {
//                return null;
//            }
//
//            @Override
//            public List<URL> getJarFileUrls() {
//                return null;
//            }
//
//            @Override
//            public URL getPersistenceUnitRootUrl() {
//                return null;
//            }
//
//            @Override
//            public boolean excludeUnlistedClasses() {
//                return false;
//            }
//
//            @Override
//            public SharedCacheMode getSharedCacheMode() {
//                return null;
//            }
//
//            @Override
//            public ValidationMode getValidationMode() {
//                return null;
//            }
//
//            @Override
//            public String getPersistenceXMLSchemaVersion() {
//                return null;
//            }
//
//            @Override
//            public ClassLoader getClassLoader() {
//                return null;
//            }
//
//            @Override
//            public void addTransformer(ClassTransformer transformer) {
//
//            }
//
//            @Override
//            public ClassLoader getNewTempClassLoader() {
//                return null;
//            }
//        };
//
//        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
//
//        Properties settings = new Properties();
//        settings.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
//        settings.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
//
//        EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider
//                .createContainerEntityManagerFactory(persistenceUnitInfo, settings);
//
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public EntityManager getEntityManager() {
//        EntityManagerFactory emf = createEntityManagerFac();
//        return emf.createEntityManager();
//    }
}
