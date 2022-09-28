package crud.util;

import crud.model.User;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.*;
import javax.persistence.spi.*;
import javax.sql.DataSource;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Util {

    //@PersistenceContext
    //EntityManager entityManager;
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.baeldung.movie_catalog");
//
//    public EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//
//    public void getProps() {
//        emf.getProperties();
//        System.out.println(emf.getProperties());
//    }

    public EntityManager createEntityManager(String dbUrl, String dbUser, String dbPassword) {

        Properties props = new Properties();
        props.put("hibernate.connection.url", dbUrl);
        props.put("hibernate.connection.username", dbUser);
        props.put("hibernate.connection.password", dbPassword);

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

        return entityManagerFactory.createEntityManager();
    }
}
