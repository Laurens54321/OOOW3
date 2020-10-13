package model.states;

import model.Product;

public class Verwijderd implements State {
    private Product product;

    public Verwijderd(Product product){
        this.product = product;
    }

    @Override
    public String approve() {
        return "Product is verwijderd";
    }

    @Override
    public String reject() {
        return "Product is verwijderd";
    }



    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean loan() {
        return isAvailable();
    }

    @Override
    public String verwijder() {
        return "Product is verwijderd";
    }


    @Override
    public String toString() {
        return "Status: Verwijderd";
    }


}
