package launcher;

import model.db.DomainException;
import model.db.Shop;
import view.ShopUi;

public class main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ShopUi shopUI = new ShopUi(shop);
        addProduct(shop);

        shopUI.openShop();
    }

    private static void addProduct(Shop shop){
        try{
            shop.addProduct("MarioCart", "G");
            shop.addProduct("Europa Universalis IV", "G");
            shop.addProduct("The Matrix", "M");

        } catch (DomainException e){
            System.out.println(e.getMessage());
        }
    }
}
