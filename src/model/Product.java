package model;

import model.db.DomainException;
import model.states.*;

import java.util.Objects;

public abstract class Product {
    protected String title;
    protected int ID;

    State beschadigd;
    State uitgeleend;
    State uitleenbaar;
    State verwijderd;

    protected State state;

    public Product(String title, int ID) throws DomainException {
        setTitle(title);
        setID(ID);

        beschadigd = new Beschadigd(this);
        uitgeleend = new Uitgeleend(this);
        uitleenbaar = new Uitleenbaar(this);
        verwijderd = new Verwijderd(this);
        state = uitleenbaar;

    }

    private void setTitle(String title) throws DomainException {
        if (title.strip().isEmpty()) throw new DomainException("Title cannot be empty");
        else this.title = title;
    }

    private void setID(int ID) throws DomainException{
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public abstract double getPrice(int days);

    public void changeState(State s){
        state = s;
    }

    public boolean loan() {
         if (state.loan()) return true;
         else return false;
    }

    public boolean isAvailable() {
        return state.isAvailable();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID == product.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
