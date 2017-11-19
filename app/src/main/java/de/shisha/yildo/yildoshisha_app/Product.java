package de.shisha.yildo.yildoshisha_app;


public class Product {

    private int _id;
    private String name;
    private double preis;
    private String typ;

    public Product() {

    }

    public Product(String name, double preis, String typ) {
        this.name = name;
        this.preis = preis;
        this.typ = typ;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
