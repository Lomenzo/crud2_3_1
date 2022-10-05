package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceUnit(unitName = "EMF")
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public List<User> getAllUsersTable() {
        List<User> userList = new ArrayList<>();
      //  try {
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT U FROM User U", User.class);
            userList = q.getResultList();

//            em.close();
//            entityManagerFactory.close();

            return userList;

      //  } finally {


      //  }
    }

    @Transactional
    public void saveUser(User userInn) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        if (userInn.getId() == null) {
            em.persist(userInn);
        } else {
            if (!em.contains(userInn)) {
                em.merge(userInn);
            }
        }
        em.getTransaction().commit();
    }

    @Transactional
    public User findUserByID(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        return user;
    }

    @Transactional
    public void deleteUser(User userInn){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(userInn));
        em.getTransaction().commit();
    }
}
