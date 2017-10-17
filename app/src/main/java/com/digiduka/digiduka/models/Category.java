package com.digiduka.digiduka.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by victor on 10/11/17.
 */
@Parcel
public class Category {
    private String categoryTitle;
    private String categoryDescription;
    private String categoryId;
    private String shopId;
    private Date date;
    private ArrayList<Product> products;

    public Category(){}

    public Category(String categoryTitle, String categoryDescription,ArrayList<Product> products) {
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        date = new Date();
        this.products=products;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getShopId() {
        return shopId;
    }

    public Date getDate() {
        return date;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public ArrayList<Product> getProducts(){
        return products;
    }
}
