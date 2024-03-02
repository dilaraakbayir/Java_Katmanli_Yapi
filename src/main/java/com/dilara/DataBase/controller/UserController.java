package com.dilara.DataBase.controller;

import com.dilara.DataBase.repository.UserRepositoryFileImpl;
import com.dilara.DataBase.repository.UserRepositoryMemoryImpl;
import com.dilara.DataBase.repository.UserRepositoryPostgreSQLImpl;
import com.dilara.DataBase.service.UserService;
import com.dilara.DataBase.utility.DbType;

import java.util.Scanner;

public class UserController {
    private final UserService userService;
    public UserController(DbType type){
        switch (type){
            case IN_MEMORY -> this.userService = new UserService(new UserRepositoryMemoryImpl());
            case POSTGRESQL -> this.userService = new UserService(new UserRepositoryPostgreSQLImpl());
            case FILE -> this.userService = new UserService(new UserRepositoryFileImpl());
            default -> this.userService = new UserService(new UserRepositoryFileImpl());
        }
    }
    public void save(){
        System.out.println("Kullanıcı adı giriniz: ");
        String userName = new Scanner(System.in).nextLine();
        System.out.println("Kullanıcı şifrenizi giriniz: ");
        String password = new Scanner(System.in).nextLine();
        boolean isSave = userService.save(userName, password);
        if (isSave)
            System.out.println("Kayıt yapıldı.");
        else
            System.out.println("Kayıt yapılamadı.");
    }
    public void findAll(){
        userService.findAll().forEach(System.out::println);
    }
}
