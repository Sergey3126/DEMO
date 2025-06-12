package com.example.demo.controllers.rest;


import com.example.demo.models.User;
import com.example.demo.services.CreationUserList;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/api/admin/")
public class RestAdminPanelController {
   private Map<String, User> map = new HashMap<>();
   private final CreationUserList creationUserList;
  private final   File file = new File("Users.txt");

    public RestAdminPanelController(CreationUserList creationUserList) {
        this.creationUserList = creationUserList;
    }

    @GetMapping(value = {"deleteall", "deleteall/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deleteAll(){
        file.delete();
        return "Пользователи удалены";
    }

    @GetMapping(value = {"getall", "getall/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Map<String,User> getAll(){
        if (!file.exists()) {
            return null ;
        }
        map = creationUserList.GiveUser();
        return map;
    }

    @GetMapping(value = {"userinfo", "userinfo/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User getInfo(@RequestParam String nick) throws IOException {
        if (!file.exists()) {
            return null ;
        }
        map = creationUserList.GiveUser();
        if (map.containsKey(nick)) {
            return map.get(nick);
        }
        return null;
    }

    @PostMapping(value = {"createuser", "createuser/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createUser(@RequestBody User user) {
        String nick = user.getNickname();
        if (!file.exists()) {
            creationUserList.SaveUser(user, true);
            return "Пользователь создан " + user.toString();
        }
        map = creationUserList.GiveUser();
        if (!map.containsKey(nick)) {
            creationUserList.SaveUser(user, true);
            return "Пользователь создан " + user.toString();
        }

        return "Пользователь существует ";
    }

    @DeleteMapping(value = {"deleteuser", "deleteuser/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@RequestParam String nick) throws IOException {
        Boolean bol = false;
        if (!file.exists()) {
            return "Пользователей нет " ;
        }
        map = creationUserList.GiveUser();
        if (map.containsKey(nick)) {
            map.remove(nick);
            for (Map.Entry<String, User> entry : map.entrySet()) {
                User user = entry.getValue();
                creationUserList.SaveUser(user, bol);
                bol = true;
            }
            return "Пользователь удален";
        }
        return "Пользователь не найден";
    }

}


