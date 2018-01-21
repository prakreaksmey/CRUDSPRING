package com.memorynotfound.model;

public class Product {
    private  int id;
    private  String name;
    private  float qty;
    private  float unitprice;

    public Product() {
    }

    public Product(int id, String name, float qty, float unitprice) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.unitprice = unitprice;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQty() {
        return qty;
    }

    public int getId()
    {
        return  id;
    }


    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }
}
