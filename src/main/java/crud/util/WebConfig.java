package crud.util;

import crud.model.User;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("crud")
@PropertySource("classpath:db.properties")
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }



// Попытка перенести создание EntityManager из второго @Configuration-класса сюда, в @Configuration WebConfig класс
//
//    @Autowired
//    private Environment env;
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
