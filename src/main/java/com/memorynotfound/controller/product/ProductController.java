package com.memorynotfound.controller.product;

import com.memorynotfound.dao.ProductDAOImpl;
import com.memorynotfound.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductDAOImpl productDAO;

    @RequestMapping(value = "/product",method= RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("product") Product product)
    {
        try
        {
            if(productDAO.getById(product.getId()) != null){
                productDAO.updateProduct(product);
            }
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("inside catch");
            productDAO.saveProduct(product);
        }
        return new ModelAndView("redirect:/products");
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editProduct(@ModelAttribute("product") Product product,@PathVariable("id") int id)
    {
        ModelAndView model = new ModelAndView("products");

        product = productDAO.getById(id);
        List<Product> productList = productDAO.getAllProduct();

        model.addObject("product",product);
        model.addObject("productList",productList);

        return model;

    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteEmployee(@ModelAttribute("product") Product product,@PathVariable("id") int id)
    {
        productDAO.deleteProduct(id);
        return new ModelAndView("redirect:/products");
    }

    @RequestMapping(value = "/products")
    public ModelAndView listProducts(@ModelAttribute("product") Product product)
    {
        ModelAndView model = new ModelAndView("products");

        List<Product> productList = productDAO.getAllProduct();
        System.out.println(productList);
        model.addObject("productList", productList);

        return model;
    }
}
