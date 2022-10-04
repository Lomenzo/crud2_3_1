package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsersTable();
    public void saveUser(User userInn);
    public User findUserByID(Long id);
    public void deleteUser(User userInn);
    public void deleteUserByID(Long id);
    public User testUserMethod(User userInn);


}
