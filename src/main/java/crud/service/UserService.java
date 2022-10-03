package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsersTable();
    public void saveUser(User userInn);
    public User testUserMethod(User userInn);


}
