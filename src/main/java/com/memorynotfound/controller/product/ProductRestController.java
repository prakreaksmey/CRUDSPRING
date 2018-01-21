package com.memorynotfound.controller.product;

import com.memorynotfound.dao.ProductDAO;
import com.memorynotfound.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class ProductRestController {
    @Autowired
    public ProductDAO productDAO;

    @RequestMapping("/rest/products")
    private List<Product> getProduct(){
        return (List<Product>) productDAO.getAllProduct();
    }
}
