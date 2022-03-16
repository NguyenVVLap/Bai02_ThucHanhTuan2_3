package com.example.bai02;

import java.util.ArrayList;

public class Catalog extends Goods{
    private ArrayList<Product> listSP = null;

    public Catalog(String id, String name) {
        super(id, name);
        this.listSP = new ArrayList<Product>();
    }

    public Catalog() {
    }
    public boolean isDuplicate(Product p) {
        for (Product p1 : listSP) {
            if (p1.getId().trim().equalsIgnoreCase(p.getId().trim())) {
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product p) {
        boolean isDup = isDuplicate(p);
        if (!isDup) {
            p.setDanhMuc(this);
            return listSP.add(p);
        }
        return false;
    }

    public ArrayList<Product> getListSP() {
        return this.listSP;
    }
    public int size() {
        return listSP.size();
    }
    public Product get(int i) {
        return listSP.get(i);
    }
}
