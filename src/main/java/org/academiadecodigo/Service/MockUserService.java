package org.academiadecodigo.Service;



import org.academiadecodigo.Model.User;

import java.util.LinkedList;

/**
 * Created by codecadet on 15/11/16.
 */
public class MockUserService implements UserService {

    private LinkedList<User> usersList;

    public MockUserService() {
        this.usersList = new LinkedList<>();
        User user = new User("Sonia", "sonia@gmail.com","123");
        User user1 = new User("Ricardo", "ricardo@gmail.com", "123");
        User user2 = new User ("Rafa", "rafa@gmail.com", "123");
        usersList.add(user);
        usersList.add(user1);
        usersList.add(user2);
    }

    public void addUser(User user) {usersList.add(user);}

    public User findByName(String userName) {

        for (int i = 0; i <usersList.size() ; i++) {
            if (usersList.get(i).getUserName().equals(userName)) {
                return usersList.get(i);
            }
        }
        return null;
    }

    public LinkedList <User> getUsersList() {

        return usersList;
    }

    public void remove(String userName){

       User user = findByName(userName);
       usersList.remove(user);
    }
}
