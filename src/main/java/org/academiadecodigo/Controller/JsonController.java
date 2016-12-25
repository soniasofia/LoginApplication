package org.academiadecodigo.Controller;

import org.academiadecodigo.Model.User;
import org.academiadecodigo.Service.MockUserService;
import org.academiadecodigo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

/**
 * Created by codecadet on 15/12/16.
 */
@RestController
public class JsonController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LinkedList> usersList() {

        return new ResponseEntity<LinkedList>(userService.getUsersList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/add")
    public ResponseEntity<LinkedList> addUser(@RequestBody User user) {

        userService.addUser(user);
        return new ResponseEntity<LinkedList>(userService.getUsersList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/remove/{userName}")
    public ResponseEntity<Void> removeUser(@PathVariable("userName") String userName) {

        userService.remove(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/update/{userName}")
    public ResponseEntity<Void> editUser(@PathVariable("userName") String userName) {

        userService.remove(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
