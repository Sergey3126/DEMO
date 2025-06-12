package com.example.demo.services.api;

import com.example.demo.models.User;

import java.util.Map;

public interface ICreationUserListService {

    void SaveUser(User user, boolean bol);


     Map<String, User> GiveUser();


}
