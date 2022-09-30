package crud;

import crud.model.User;
//import crud.util.Config;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import crud.util.Util;

import java.util.Map;


public class Main {
    public static void main (String[] args){

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Util.class);

        User user1 = new User("vasya", "lohov", 50000);
        System.out.println(user1.getId() + user1.getName() + user1.getLastName() + user1.getSalary());

        //UserService userService = new UserService();
        UserService userService = context.getBean(UserService.class);
        userService.saveUser();

        /*Config config = new Config();
        EntityManagerFactory emf = config.lfb().getObject();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();*/

//        @PersistenceContext
//        EntityManager em = getEntityManager();
//
//        em.getTransaction().begin();
//        em.persist(user1);
//        em.getTransaction().commit();

    }
}
