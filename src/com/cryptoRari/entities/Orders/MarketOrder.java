package com.cryptoRari.entities.Orders;

public class MarketOrder extends AccountOrder {
    double size;
    double funds;

    public MarketOrder() {

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
        return "MarketOrder{" +
                "size=" + size +
                ", funds=" + funds +
                ", client_oid='" + client_oid + '\'' +
                ", type='" + type + '\'' +
                ", side='" + side + '\'' +
                ", product_id='" + product_id + '\'' +
                ", stp='" + stp + '\'' +
                '}';
    }
}
