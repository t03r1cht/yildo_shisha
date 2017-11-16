package de.shisha.yildo.yildoshisha_app;


public class Getraenk {

    private int _id;
    private String name;
    private double preis;

    public Getraenk() {

    }

    public Getraenk(String name, double preis) {
        this.name = name;
        this.preis = preis;
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
}
