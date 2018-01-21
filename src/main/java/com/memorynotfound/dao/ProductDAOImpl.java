package com.memorynotfound.dao;

import com.memorynotfound.model.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ProductDAOImpl implements  ProductDAO {
//    public JdbcTemplate jdbcTemplate;
   private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public List<Product> getAllProduct() {
        String sqlSelect = "Select *from product";

        List<Product> products = jdbcTemplate.query(sqlSelect, new ResultSetExtractor<List<Product>>() {
            @Override
            public List<Product> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Product> productList = new ArrayList<Product>();

                while (resultSet.next()){
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setQty(resultSet.getFloat("qty"));
                    product.setUnitprice(resultSet.getFloat("unitprice"));

                    productList.add(product);
                }
                return productList;
            }
        });
        return products;
    }

    @Override
    public Product getById(int id) {

        String sql = "select *from product where id=?";
        Product product = (Product) jdbcTemplate.queryForObject(sql, new Object[]
                { id }, new RowMapper<Product>()
        {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Product product = new Product();
                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setQty(rs.getFloat("QTY"));
                product.setUnitprice(rs.getFloat("UNITPRICE"));
                return product;
            }
        });
        return product;
    }

    @Override
    public void saveProduct(Product product) {
        String sql = "insert into product values(?,?,?,?)";
        System.out.println("dao called");
        jdbcTemplate.update(sql, new Object[]
                {product.getId(), product.getName(),product.getQty(), product.getUnitprice()});
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "update product set unitprice =?, qty=?,name=? where id=?";
        jdbcTemplate.update(sql, new Object[]
                { product.getQty(), product.getUnitprice(), product.getName(), product.getId() });

    }

    @Override
    public void deleteProduct(int id) {
        String sql = "delete from product where id=?";
        jdbcTemplate.update(sql, new Object[]
                { id });
    }

    @Override
    public Product searchProduct(int id) {

        String sql = "select *from product where id=+search+";
        Product product = (Product) jdbcTemplate.queryForObject(sql, new Object[]
                { id }, new RowMapper<Product>()
        {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Product product = new Product();
                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setQty(rs.getFloat("QTY"));
                product.setUnitprice(rs.getFloat("UNITPRICE"));
                return product;
            }
        });

            return  product;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
