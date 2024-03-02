package com.dilara.DataBase;

import com.dilara.DataBase.controller.UserController;
import com.dilara.DataBase.utility.DbType;

import java.util.Scanner;

public class RunnerDB {
    public static void main(String[] args) {
        int secim;
        System.out.println("""
                ****************************
                **** KULLANICI İŞLEMLERİ ***
                ****************************
                1-Kullanıcı Ekleme
                2-Kullanıcı Listeleme
                0-Ç I K I Ş
                """);

        do {
            System.out.println("Seçim yapınız.");
            secim = new Scanner(System.in).nextInt();
            switch (secim){
                case 1: new UserController(DbType.IN_MEMORY).save();
                    break;
                case 2: new UserController(DbType.IN_MEMORY).findAll();
                    break;
                case 0:
                    System.err.println("ÇIKIŞ YAPILDI.");
            }
        }while (secim!=0);

    }
}
