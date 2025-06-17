package com.example.demo.dao.converters;

import com.example.demo.dao.entity.UserEntity;
import com.example.demo.models.User;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<UserEntity, User> {
    @Override
    public User convert(UserEntity source) {
        User user = new User();
        user.setName(source.getName());
        user.setSurname(source.getSurname());
        user.setNickname(source.getNickname());
        user.setMail(source.getMail());
        return user;
    }

    @Override
    public <U> Converter<UserEntity, U> andThen(Converter<? super User, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
