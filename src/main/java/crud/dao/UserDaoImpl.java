package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("SELECT U FROM User U", User.class).getResultList();
    }

    @Transactional
    public void saveUser(User userInn) {
        if (userInn.getId() == null) {
            em.persist(userInn);
        } else {
            if (!em.contains(userInn)) {
                em.merge(userInn);
            }
        }
    }

    @Transactional
    public User findUserByID(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Transactional
    public void deleteUser(User userInn){
        em.remove(em.merge(userInn));
    }
}
