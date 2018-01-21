package com.memorynotfound.dao;

import com.memorynotfound.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProduct();
    Product getById(int id);
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product searchProduct(int id);



}
