package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsersTable() {
        List<User> list = userDao.getAllUsersTable();
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
