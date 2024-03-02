package com.dilara.DataBase.repository;

import com.dilara.DataBase.entity.Product;

import java.util.List;

public class ProductRepositoryMemoryImpl implements Repository<Product>{
    @Override
    public void save(Product entity) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    } //<T> olduğu için


}
