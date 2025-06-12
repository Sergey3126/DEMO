package controller.web.controllers.advice;


import com.example.demo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/api/admin/")
public class RestAdminPanelController {
    Map<String, User> map = new HashMap<>();
    CreationUserList creationUserList = new CreationUserList();
    File file = new File("Users.txt");
    public RestAdminPanelController() {

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
    public String getAll(){
        if (!file.exists()) {
            return "Пользователей нет " ;
        }
        map = creationUserList.GiveUser();
        return map.values().toString();
    }

    @GetMapping(value = {"userinfo", "userinfo/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getInfo(@RequestParam String nick) throws IOException {
        if (!file.exists()) {
            return "Пользователей нет " ;
        }
        map = creationUserList.GiveUser();
        if (map.containsKey(nick)) {
            return String.valueOf(map.get(nick));
        }
        return "Такой пользователь не найден";
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


//    @DeleteMapping(value = {"/deleteuser/{nick}", "/deleteuser/{nick}/"}, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public String DeleteUser(@PathVariable String nick)  throws IOException {
//
//        Boolean bol = false;
//        if (!file.exists()) {
//            return "Пользователей нет " ;
//        }
//        map = creationUserList.GiveUser(nick);
//        if (map.containsKey(nick)) {
//            map.remove(nick);
//            for (Map.Entry<String, User> entry : map.entrySet()) {
//                User user = entry.getValue();
//                creationUserList.SaveUser(user, bol);
//                bol = true;
//            }
//            return "Пользователь удален";
//        }
//        return "Пользователь не найден";
//    }
}


