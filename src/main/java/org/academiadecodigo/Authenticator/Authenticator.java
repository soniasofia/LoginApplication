package org.academiadecodigo.Authenticator;

import org.academiadecodigo.Model.User;
import org.academiadecodigo.Service.MockUserService;
import org.academiadecodigo.Service.UserService;

/**
 * Created by codecadet on 12/12/16.
 */
public class Authenticator {

    public boolean authenticate(String username, String password) {

        UserService moc = new MockUserService();

        User user = moc.findByName(username);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}