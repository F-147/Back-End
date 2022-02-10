package com.adduser.crud.controller;


import java.util.List;

import com.adduser.crud.model.User;
import com.adduser.crud.model.UserModel;
import com.adduser.crud.service.UserCrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiUser")
public class UserCrudController {

    @Autowired
    private UserCrudService userCrudService;

    @RequestMapping("/findUserAll")
    public List<User> findUserAll() {
        return userCrudService.findUserAll();
    }

    @RequestMapping(value = "/getUserAll", method = RequestMethod.GET)
    public @ResponseBody List<UserModel> getUserAll() {

        List<UserModel> result = userCrudService.findUserModelsAll();
        return result;
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    public @ResponseBody UserModel getUserById(@PathVariable int id) {

        UserModel result = userCrudService.findUserModelById(id);
        return result;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody Boolean addUser(@RequestBody UserModel User) {
        return userCrudService.InsertUser(User);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public @ResponseBody Boolean updateUser(@RequestBody UserModel User) {
        return userCrudService.UpdateUser(User);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteUser(@PathVariable long id) {
        return userCrudService.deleteUserById(id);
    }

    
}
