package com.example.demo.controllers.rest;


import com.example.demo.models.User;
import com.example.demo.services.Operations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/admin/")
public class RestAdminPanelController {
   private final Operations operations;


    public RestAdminPanelController(Operations operations) {
        this.operations = operations;
    }


    @GetMapping(value = {"getall", "getall/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() throws IOException {

        return operations.getAll();
    }

    @GetMapping(value = {"userinfo", "userinfo/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User getInfo(@RequestParam String nick) throws IOException {
        return operations.get(nick);
    }

    @PostMapping(value = {"createuser", "createuser/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User createUser(@RequestBody User user) throws IOException {

        return operations.create(user);
    }

    @DeleteMapping(value = {"deleteuser", "deleteuser/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@RequestParam String nick) throws IOException {
operations.delete(nick);
        return "Пользователь удален";
    }

    @PutMapping (value = {"updateuser", "updateuser/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestParam String nick,@RequestBody User user) throws IOException {

        return operations.updateUser(nick,user);
    }



}


