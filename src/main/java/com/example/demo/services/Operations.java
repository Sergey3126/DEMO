package com.example.demo.services;

import com.example.demo.dao.api.IUserStorage;
import com.example.demo.dao.entity.UserEntity;
import com.example.demo.models.User;
import com.example.demo.services.api.IOperationsService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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
    public User get(String nick) throws IOException {
        UserEntity userEntity = userStorage.findById(nick).orElse(null);
        User user = conversionService.convert(userEntity, User.class);
        return user;
    }

    @Override
   public List<User> getAll () throws IOException{
   List<UserEntity>   userEntityList =  userStorage.findAll();
        List<User> userList= new ArrayList<>();
   for (int i = 0; i<userEntityList.size(); i++){
       UserEntity userEntity =userEntityList.get(i);
       User user = conversionService.convert(userEntity, User.class);
       userList.add(user);
   }
return userList;
    }


    @Override
    public User create(User userRaw) throws IOException {
        userStorage.save(conversionService.convert(userRaw, UserEntity.class));
        return userRaw;
    }
    @Override
  public   User delete (String nick) throws IOException {
        userStorage.delete(userStorage.findById(nick).orElse(null));
        return null;

    }
    @Override
  public  User updateUser (String nick, User userRaw) throws IOException {

userStorage.delete(userStorage.findById(nick).orElse(null));
            userStorage.save(conversionService.convert(userRaw, UserEntity.class));

        return userRaw;
    }


    }

