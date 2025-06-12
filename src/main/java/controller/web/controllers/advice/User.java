package com.example.demo;


public class User {
    private String name;
    private String surname;
    private String mail;
    private String nickname;

    public User(String name, String surname, String mail, String nickname) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.nickname = nickname;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "имя='" + name + '\'' +
                "фамилия='" + surname + '\'' +
                "почта='" + mail + '\'' +
                "ник='" + nickname + '\'' +
                '}';
    }
}
