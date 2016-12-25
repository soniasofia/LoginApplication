package org.academiadecodigo.Service;


import org.academiadecodigo.Model.User;

import java.util.LinkedList;

/**
 * Created by codecadet on 12/12/16.
 */
public interface UserService {

    void addUser(User user);
    User findByName(String userName);
    void remove(String userName);
    LinkedList<User> getUsersList();
}
