package model.db;

import model.*;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> productList = new ArrayList<>();

    public void Shop(){
    }

    public void addProduct(String title, String type) throws DomainException {
        int id = productList.size();
        Product p;

        switch(type){
            case "M":
                p = new Movie(title, id);
                productList.add(p);
                break;
            case "G":
                p = new Game(title, id);
                productList.add(p);
                break;
            case "C":
                p = new CD(title, id);
                productList.add(p);
                break;
            default:
                throw new DomainException("Not a category");
        }

        System.out.println("Added product: " + p);
    }

    public String showProduct(int id){
        Product p  = searchDB(id);
        if (p == null) return null;
        return p.toString();
    }

    public double showPrice(int id, int days){
        Product p = searchDB(id);
        return p.getPrice(days);
    }

    public String showInventory(){
        //Dit is echt de lelijkste shit ooit
        //pls refactor
        ArrayList<Product> out = new ArrayList<>();
        for (Product p: productList){
            if (p.getClass().equals(Movie.class)) out.add(p);
        }
        for (Product p: productList){
            if (p.getClass().equals(Game.class)) out.add(p);
        }
        for (Product p: productList){
            if (p.getClass().equals(CD.class)) out.add(p);
        }

        String outString = "";
        for (Product p: productList){
            outString += p.toString() + "\n";
        }

        return outString;
    }

    public boolean isIdAvailable(int id){
        Product p = searchDB(id);
        return p.isAvailable();
    }

    public String loanProduct(int id){
        for (Product p: productList){
            if (p.getID() == id){
                if(p.loan()) return "Product is now loaned out";
                else return "Product could not be loaned";
            }
        }
        return "No product with this id was found";
    }

    private Product searchDB(int id){
        for (Product p: productList){
            if (p.getID() == id) return p;
        }
        return null;
    }

}
