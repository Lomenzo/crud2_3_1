package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User userInn);
    public User findUserByID(Long id);
    public void deleteUser(User userInn);
}
