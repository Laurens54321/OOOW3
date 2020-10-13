package model.states;

import model.Product;

public class Uitgeleend implements State{
    private Product product;

    public Uitgeleend(Product product){
        this.product = product;
    }

    @Override
    public String approve() {
        product.changeState((State) new Uitleenbaar(product));
        return "Product is leenbaar";
    }

    @Override
    public String reject() {
        product.changeState((State) new Beschadigd(product));
        return "Product is beschadigd";
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
        return "Product is nog uitgeleend. \nHet product moet eerst teruggebracht worden";
    }



    @Override
    public String toString() {
        return "Status: Uitgeleend";
    }
}
