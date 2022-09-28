package crud;

import crud.model.User;
//import crud.util.Config;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import crud.util.Util;

import java.util.Map;


public class Main {
    public static void main (String[] args){
        User user1 = new User("vasya", "lohov", 50000);
        System.out.println(user1.getId() + user1.getName() + user1.getLastName() + user1.getSalary());
        Util util = new Util();

        /*Config config = new Config();
        EntityManagerFactory emf = config.lfb().getObject();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();*/

        EntityManager em = util.createEntityManager("jdbc:mysql://localhost/dedusers", "root", "1Dothisf");

        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();

    }
}
