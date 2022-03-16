package com.example.bai02;

public class Product extends Goods{
    private Catalog danhMuc;

    public Catalog getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Catalog danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Product(String id, String name, Catalog danhMuc) {
        super(id, name);
        this.danhMuc = danhMuc;
    }

    public Product(String id, String name) {
        super(id, name);
    }

    public Product() {
    }
}
