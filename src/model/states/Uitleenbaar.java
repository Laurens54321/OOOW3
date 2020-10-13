package model.states;

import model.Product;

public class Uitleenbaar implements State {
    private Product product;

    public Uitleenbaar(Product product){
        this.product = product;
    }

    @Override
    public String approve() {
        product.changeState((State) new Uitgeleend(product));
        return "Product is uitgeleend";
    }

    @Override
    public String reject() {
        product.changeState((State) new Verwijderd(product));
        return "Product is verwijderd";
    }



    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean loan() {
        product.changeState((State) new Uitgeleend(product));
        return true;
    }

    @Override
    public String verwijder() {
        product.changeState((State) new Verwijderd(product));
        return "Product is verwijderd";
    }


    @Override
    public String toString() {
        return "Status: Uitleenbaar";
    }
}
