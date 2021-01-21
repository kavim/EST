package Controller;

import Model.Product;
import Model.ProductStock;

import java.util.*;

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

    public void showStock(int id){

        System.out.println("\n- - - - - - - - - - - - - - - - - - - -\n Consultando stock \n- - - - - - - - - - - - - - - - - - - -\n");

        Product p = this.findById(id);

        if (p == null){
            System.out.println("Produto não encontrado");
            return;
        }

        if(p.getQueue().isEmpty()){
            System.out.println("Fora de estoque");
        }else {
            for (ProductStock ps : p.getQueue()) {
                System.out.println("Quant: " + ps.getQuantidade() + "\t data : "+ps.getData());
            }
            System.out.println("Total: "+p.getTotal());
        }

    }

    public void remove(int id, int quant){

        Product p = this.findById(id);

        if(p == null){
            System.out.println("O produto não existe");
        }

        if(p.getQueue().isEmpty()){
            System.out.println("fora de estoque");
        }

        while (quant > 0){
            ProductStock productStock = p.getQueue().element();

            if(quant > productStock.getQuantidade() && quant <= p.getTotal()){

                p.setTotal( p.getTotal() - productStock.getQuantidade());

                quant -= productStock.getQuantidade();

                System.out.println("\nRemovendo entrada: " + p.getQueue().element().getInfo());

                p.getQueue().remove();

                continue;
            }

            if(quant == productStock.getQuantidade()){
                System.out.println("\nRemovendo entrada: " + p.getQueue().element().getInfo());

                p.setTotal( p.getTotal() - productStock.getQuantidade());

                p.getQueue().remove();
                quant = 0;

                continue;
            }

            if(quant < productStock.getQuantidade()){
                p.setTotal( p.getTotal() - quant);

                if((productStock.getQuantidade() - quant) < 1){
                    p.getQueue().remove();
                }else{
                    productStock.setQuantidade( productStock.getQuantidade() - quant );
                }

                quant = 0;

                continue;
            }

            if(quant > p.getTotal()){

                try {
                    System.out.println("A quantidade Insuficiente, deseja remover apenas "+p.getTotal()+" ?");


                    Scanner i = new Scanner(System.in);
                    System.out.println("\n" + "1 - Sim | 2 - Não");
                    int choise = i.nextInt();

                    if(choise == 1){

                        quant = p.getTotal();

                    }
                    if(choise == 2){
                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Números inteiros por favor: ");
                    continue;
                } catch (NoSuchElementException e) {

                    continue;
                }



            }

        }

        System.out.println("\n- - - - - - - - - - - - - - - - - - - -\nSucesso!\n- - - - - - - - - - - - - - - - - - - -\n");

    }
}
