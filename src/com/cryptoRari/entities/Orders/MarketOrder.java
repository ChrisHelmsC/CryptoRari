package com.cryptoRari.entities.Orders;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketOrder extends AccountOrder {
    String size;
    String funds;

    public MarketOrder() {
        super();
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
