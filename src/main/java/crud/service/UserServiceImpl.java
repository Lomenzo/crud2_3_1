package crud.service;

import crud.dao.UserDao;
import crud.dao.UserDaoImpl;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

//    @PersistenceUnit(unitName = "EMF")
//    private EntityManagerFactory entityManagerFactory;

    final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

   // @Transactional
    public List<User> getAllUsersTable() {
        List<User> list = userDao.getAllUsersTable();
//        List<User> userList = new ArrayList<>();
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        Query q = em.createQuery("SELECT U FROM User U", User.class);
//        return userList = q.getResultList();
        return list;
    }

   // @Transactional
    public void saveUser(User userInn) {
        userDao.saveUser(userInn);
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        if (userInn.getId() == null) {
//            em.persist(userInn);
//        } else {
//            if (!em.contains(userInn)) {
//                em.merge(userInn);
//            }
//        }
//        em.getTransaction().commit();
    }

   // @Transactional
    public User findUserByID(Long id) {
        User user = userDao.findUserByID(id);
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        User user = em.find(User.class, id);
//        em.getTransaction().commit();
//        return user;
        return user;
    }

  //  @Transactional
    public void deleteUser(User userInn){
        userDao.deleteUser(userInn);
//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
//        em.remove(em.merge(userInn));
//        em.getTransaction().commit();
    }
}
