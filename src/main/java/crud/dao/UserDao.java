package crud.dao;

import crud.model.User;
import java.util.List;

public interface UserDao {
    public List<User> getAllUsersTable();
    public void saveUser(User userInn);
    public User findUserByID(Long id);
    public void deleteUser(User userInn);
}
