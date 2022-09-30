package crud.util;

import crud.model.User;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

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
public class Util {

    @Autowired
    private Environment env;

    @Bean
    public EntityManagerFactory createEntityManagerFac() {

        Properties props = new Properties();
        props.put("hibernate.connection.url", env.getProperty("db.url"));
        props.put("hibernate.connection.username", env.getProperty("db.username"));
        props.put("hibernate.connection.password", env.getProperty("db.password"));

        PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfo() {

            @Override
            public Properties getProperties() {
                return props;
            }

            @Override
            public List<String> getManagedClassNames() {
                return Arrays.asList(User.class.getName());
            }

            @Override
            public String getPersistenceUnitName() {
                return "TestUnit";
            }

            @Override
            public String getPersistenceProviderClassName() {
                return HibernatePersistenceProvider.class.getName();
            }

            @Override
            public PersistenceUnitTransactionType getTransactionType() {
                return null;
            }

            @Override
            public DataSource getJtaDataSource() {
                return null;
            }

            @Override
            public DataSource getNonJtaDataSource() {
                return null;
            }

            @Override
            public List<String> getMappingFileNames() {
                return null;
            }

            @Override
            public List<URL> getJarFileUrls() {
                return null;
            }

            @Override
            public URL getPersistenceUnitRootUrl() {
                return null;
            }

            @Override
            public boolean excludeUnlistedClasses() {
                return false;
            }

            @Override
            public SharedCacheMode getSharedCacheMode() {
                return null;
            }

            @Override
            public ValidationMode getValidationMode() {
                return null;
            }

            @Override
            public String getPersistenceXMLSchemaVersion() {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }

            @Override
            public void addTransformer(ClassTransformer transformer) {

            }

            @Override
            public ClassLoader getNewTempClassLoader() {
                return null;
            }
        };

        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();

        Properties settings = new Properties();
        settings.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
        settings.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");

        EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider
                .createContainerEntityManagerFactory(persistenceUnitInfo, settings);

        return entityManagerFactory;
    }

    @Bean
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = createEntityManagerFac();
        return emf.createEntityManager();
    }
}
