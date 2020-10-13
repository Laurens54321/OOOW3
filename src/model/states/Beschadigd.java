package model.states;

import model.Product;
import model.db.DomainException;

public class Beschadigd implements State {

    private Product product;

    public Beschadigd(Product product){
        this.product = product;
    }


    @Override
    public String approve() {
        product.changeState((State) new Uitleenbaar(product));
        return "Product is leenbaar";
    }

    @Override
    public String reject() {
        product.changeState((State) new Verwijderd(product));
        return "Product is verwijderd";
    }



    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public boolean loan() {
        return isAvailable();
    }

    @Override
    public String verwijder() {
        product.changeState((State) new Verwijderd(product));
        return "Product is verwijderd";
    }

    @Override
    public String toString() {
        return "Status: Beschadigd";
    }
}
