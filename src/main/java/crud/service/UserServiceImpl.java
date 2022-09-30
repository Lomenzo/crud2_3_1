package crud.service;

import crud.model.User;
import crud.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private Util util;

    public void saveUser() {
        EntityManager em = util.getEntityManager();
        User user1 = new User("pet", "pupk", 100);
        System.out.println(user1.getId() + user1.getName() + user1.getLastName() + user1.getSalary());
        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();
    }

    public User testUserMethod() {
        User user1 = new User("testUserName", "testUserLastName", 99999);
        return user1;
    }

}
