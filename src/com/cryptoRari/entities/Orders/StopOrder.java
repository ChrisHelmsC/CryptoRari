package com.cryptoRari.entities.Orders;

public class StopOrder extends AccountOrder{
    String price;
    String size;
    String funds;

    public StopOrder() {

    }

    public StopOrder(String price, String size, String funds) {
        this.price = price;
        this.size = size;
        this.funds = funds;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
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
