package com.example.demo.controllers.rest;


import com.example.demo.models.User;
import com.example.demo.services.Operations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;



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
    public String getAll(){

        return null;
    }

    @GetMapping(value = {"userinfo", "userinfo/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User getInfo(@RequestParam String nick) throws IOException {

        return null;
    }

    @PostMapping(value = {"createuser", "createuser/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createUser(@RequestBody User user) {

        return "Пользователь существует ";
    }

    @DeleteMapping(value = {"deleteuser", "deleteuser/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@RequestParam String nick) throws IOException {

        return "Пользователь не найден";
    }

}


