package TestMethods;

import java.util.ArrayList;


public class MySpace {

    private String whatBuy;
    private int count;
    private int price;
    private String action;

    public MySpace(String whatBuy, int count, int price, String action) {
        this.whatBuy = whatBuy;
        this.count = count;
        this.price = price;
        this.action = action;
    }

    public MySpace() {

    }

    public void setWhatBuy(String whatBuy) {
        this.whatBuy = whatBuy;
    }

    public String getWhatBuy() {
        return whatBuy;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}




