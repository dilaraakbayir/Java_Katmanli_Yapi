package com.dilara.DataBase.repository;

import com.dilara.DataBase.entity.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class UserRepositoryFileImpl implements Repository<User>{
    @Override
    public void save(User entity) {
        try{
            FileWriter fileWriter = new FileWriter("users.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(entity.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception exception){
            System.err.println("Hata!!!  | "+exception);
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }




}
