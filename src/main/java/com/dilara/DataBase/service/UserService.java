package com.dilara.DataBase.service;

import com.dilara.DataBase.entity.User;
import com.dilara.DataBase.repository.Repository;

import java.util.List;
import java.util.Optional;

public class UserService {
    /**
     * final değişkenler değişmezliği garanti ederler. Mutlaka ilk
     * değerlerinin sınıftan nesne oluşturulmadan atanmasını isterler.
     */
    private final Repository<User> repository; //Repository interface
    public UserService(Repository<User> repository){
        this.repository = repository;
    }
    public boolean save(String userName, String password){
        /**
         * Eğer aynı kullanıcı adı daha önce alınmış ise ne olacak?
         * 1-Kullanıcı listesini çekerek var mı bakıyoruz
         */
        Optional<User> optionalUser = repository.findAll().stream().filter(user-> user.getUsername()
                .equalsIgnoreCase(userName)).findAny();
        //eğer bu ada sahip kullanıcı var ise false dönecek
        if (optionalUser.isPresent())
            return false;
        //böyle bir kullanıcı yok ise, kayıt yapıyoruz
        repository.save(new User(userName, password));
        return true;
    }

    public List<User> findAll(){
        return repository.findAll();
    }
}
