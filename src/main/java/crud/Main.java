package crud;

import crud.model.User;

public class Main {
    public static void main (String[] args){
        User user1 = new User("vasya", "lohov", 50000);
        System.out.println(user1.getId() + user1.getName() + user1.getLastName() + user1.getSalary());

    }
}
