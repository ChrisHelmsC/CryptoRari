package com.cryptoRari.entities.Orders;

public class StopOrder {
    double price;
    double size;
    double funds;

    public StopOrder() {

    }

    public StopOrder(double price, double size, double funds) {
        this.price = price;
        this.size = size;
        this.funds = funds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "StopOrder{" +
                "price=" + price +
                ", size=" + size +
                ", funds=" + funds +
                '}';
    }
}
