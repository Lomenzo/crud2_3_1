package crud.service;

import crud.model.User;
//import crud.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @PersistenceUnit(unitName = "EMF")
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public List<User> getAllUsersTable() {
        List<User> userList = new ArrayList<>();
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT U FROM User U", User.class);
        return userList = q.getResultList();
    }

    @Transactional
    public void saveUser(User userInn) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(userInn);
        em.getTransaction().commit();
        System.out.println("User SAVED to DataBase:  " + userInn.getId() + userInn.getName() + userInn.getLastName() + userInn.getSalary());
    }

    @Transactional
    public void deleteUser(User userInn) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, userInn.getId());
        em.remove(user);
        em.getTransaction().commit();
        System.out.println("User DELETED from DataBase:  " + userInn.getId() + userInn.getName() + userInn.getLastName() + userInn.getSalary());
    }

    public User testUserMethod(User userInn) {
        User user1 = new User("testUserName", "testUserLastName", 99999);
        int newSalary = userInn.getSalary() + 500;
        userInn.setSalary(newSalary);
        return userInn;
    }
}
