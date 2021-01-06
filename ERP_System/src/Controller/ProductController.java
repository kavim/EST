package Controller;

import Model.Product;
import java.util.ArrayList;

public class ProductController {

    protected ArrayList<Product> products;

    public ProductController(ArrayList<Product> products){
        this.products = products;
    }

    public Product findById(int id){
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public ArrayList<Product> findByNameRootsWay(String targetName) {

        ArrayList<Product> found = new ArrayList();

        for (Product p : products) {
            if (targetName.equals(p.getName())) {
                System.out.println("\n\n\n YES \n\n\n");
            }
        }

        return null;
    }

    public ArrayList<Product> findByName(String name){

        ArrayList<Product> found = new ArrayList();

        for (Product p : products){
            if (p.getName().contains(name)){
                found.add(p);
            }
        }

        return found;
    }


    public ArrayList<Product> get() {

        for (Product p : products) {

            System.out.println("\t id : "+p.getId()+"\t name : "+p.getName());

        }

        return null;
    }
}
