package com.shoffers;

public class Product {
    String name;
    String price;
    String sex;
    String category;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Product(String name, String price, String sex, String category, String subcategory) {
        this.name = name;
        this.price = price;
        this.sex = sex;
        this.category = category;
        this.subcategory = subcategory;
    }

    String subcategory;



}
