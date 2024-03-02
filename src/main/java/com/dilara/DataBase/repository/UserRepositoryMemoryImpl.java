package com.dilara.DataBase.repository;

import com.dilara.DataBase.entity.User;

import java.util.List;

import static com.dilara.DataBase.utility.DB_InMemory_Cache.*;

public class UserRepositoryMemoryImpl implements Repository<User>{
    @Override
    public void save(User entity) {
        // DB_InMemory_Cache.userList.add(entity); //statik olduğu için gelir
        userList.add(entity);
    }

    @Override
    public List<User> findAll() {
        // return DB_InMemory_Cache.userList;
        return userList;
    }







}
