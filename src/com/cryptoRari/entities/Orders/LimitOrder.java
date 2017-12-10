package com.cryptoRari.entities.Orders;

public class LimitOrder extends AccountOrder{
    double price;
    double size;
    String time_in_force;
    String cancel_after;
    boolean post_only;

    public LimitOrder() {

    }

    public LimitOrder(double price, double size, String time_in_force, String cancel_after, boolean post_only) {
        this.price = price;
        this.size = size;
        this.time_in_force = time_in_force;
        this.cancel_after = cancel_after;
        this.post_only = post_only;
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

    public String getTime_in_force() {
        return time_in_force;
    }

    public void setTime_in_force(String time_in_force) {
        this.time_in_force = time_in_force;
    }

    public String getCancel_after() {
        return cancel_after;
    }

    public void setCancel_after(String cance_after) {
        this.cancel_after = cance_after;
    }

    public boolean isPost_only() {
        return post_only;
    }

    public void setPost_only(boolean post_only) {
        this.post_only = post_only;
    }

    @Override
    public String toString() {
        return "LimitOrder{" +
                "price=" + price +
                ", size=" + size +
                ", time_in_force='" + time_in_force + '\'' +
                ", cancel_after='" + cancel_after + '\'' +
                ", post_only=" + post_only +
                ", client_oid='" + client_oid + '\'' +
                ", type='" + type + '\'' +
                ", side='" + side + '\'' +
                ", product_id='" + product_id + '\'' +
                ", stp='" + stp + '\'' +
                '}';
    }
}
