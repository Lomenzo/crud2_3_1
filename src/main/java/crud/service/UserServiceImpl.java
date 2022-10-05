package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        List<User> list = userDao.getAllUsers();
        return list;
    }

    public void saveUser(User userInn) {
        userDao.saveUser(userInn);
    }

    public User findUserByID(Long id) {
        User user = userDao.findUserByID(id);
        return user;
    }

    public void deleteUser(User userInn){
        userDao.deleteUser(userInn);
    }
}
