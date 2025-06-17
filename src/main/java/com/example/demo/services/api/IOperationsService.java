package com.example.demo.services.api;

import com.example.demo.models.User;

import java.io.IOException;
import java.util.List;

public interface IOperationsService {


    User get (String nick) throws IOException;
    List<User> getAll () throws IOException;
    User create (User userRaw) throws IOException;
    User delete (String nick) throws IOException;
    User updateUser (String nick, User userRaw) throws IOException;



}
