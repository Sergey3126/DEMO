package com.example.demo.services.api;

import com.example.demo.models.User;

import java.io.IOException;
import java.util.List;

public interface IOperationsService {


    User get (String login) throws IOException;
    List<User> getAll () throws IOException;
    String getName (String login);
    User create (User userRaw) throws IOException;
    User delete (String login) throws IOException;
    User updateUser (User userRaw) throws IOException;



}
