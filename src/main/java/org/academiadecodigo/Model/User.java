package org.academiadecodigo.Model;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by codecadet on 12/12/16.
 */
public class User {

    @NotNull(message = "username is mandatory")
    @NotBlank(message = "username is mandatory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "username has invalid characters")
    private String userName;

    @NotNull(message = "password is mandatory")
    @NotBlank (message = "password is mandatory")
    @Size(min = 3, max = 10)
    private String password;

    private String email;

    public User() {}

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {return userName;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
