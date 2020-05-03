package com.gzj.express_transportation.entity;

public class Orders{
    int ywc;

    public int getYwc() {
        return ywc;
    }

    public void setYwc(int ywc) {
        this.ywc = ywc;
    }

    public int getYsz() {
        return ysz;
    }

    public void setYsz(int ysz) {
        this.ysz = ysz;
    }

    public int getDls() {
        return dls;
    }

    public void setDls(int dls) {
        this.dls = dls;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    int ysz;
    int dls;
    String price;

    public String getZs() {
        return zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }

    String zs;
}
