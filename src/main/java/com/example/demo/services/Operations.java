package com.example.demo.services;

import com.example.demo.dao.api.IUserStorage;
import com.example.demo.dao.entity.UserEntity;
import com.example.demo.models.User;
import com.example.demo.services.api.IOperationsService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Operations implements IOperationsService {

    private final IUserStorage userStorage;

    public Operations(IUserStorage userStorage, ConversionService conversionService) {
        this.userStorage = userStorage;
        this.conversionService = conversionService;
    }

    private final ConversionService conversionService;

    @Override
    public User get(String login) throws IOException {
        UserEntity userEntity = userStorage.findById(login).orElse(null);
        System.out.println(userEntity);
        User user = conversionService.convert(userEntity, User.class);
        System.out.println(user);
        return user;
    }


   public List<User> getAll () throws IOException{
return null;
    }

  public   String getName (String login) {

        return null;
    }

    @Override
    public User create(User userRaw) throws IOException {
        userStorage.save(conversionService.convert(userRaw, UserEntity.class));
        return userRaw;
    }

  public   User delete (String login) throws IOException {
        return null;

    }

  public   User updateUser (User userRaw) throws IOException {

        return null;
    }


    }

