package com.example.demo.dao.converters;

import com.example.demo.dao.entity.UserEntity;
import com.example.demo.models.User;
import org.springframework.core.convert.converter.Converter;

public class UserConverterEntity implements Converter<User, UserEntity> {
    @Override
    public UserEntity convert(User source) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(source.getName());
        userEntity.setMail(source.getMail());
        userEntity.setSurname(source.getSurname());
        userEntity.setNickname(source.getNickname());
        return userEntity;
    }

    @Override
    public <U> Converter<User, U> andThen(Converter<? super UserEntity, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
