import Controller.ProductController;
import DB.LoadData;
import Model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ProductController productController;

    public static void main(String[] args) {

        LoadData loadData = new LoadData();

        loadData.run(); //carregar informação na memoria

        productController = new ProductController(loadData.getProducts());

//        productController.get();

        menu();
    }

    public static void menu(){
        System.out.println("\n\n 1 – Buscar produto por código");
        System.out.println("2 – Buscar produto por nome.");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        System.out.println("\n------------------------------------------------------------------------------------------------------------------\n");

        if(choice == 1){

            System.out.println("Digite o codigo do produto");
            int id = input.nextInt();
            Product found = productController.findById(id);
            System.out.println(found.getName());

        }
        if(choice == 2){

            System.out.println("Digite o nome do produto");
            String nome = input.next();
            ArrayList<Product> founds = productController.findByName(nome);

            if(founds.isEmpty()){
                System.out.println("Nenhum produto encontrado :(");
                menu();
            }
            System.out.println("Buscando por : "+nome);
            for (Product p : founds ) {

                System.out.println("\n\t"+p.getName());

            }

            System.out.println(founds.size() + " produtos encontrados");

        }

        System.out.println("------------------------------------------------------------------------------------------------------------------");
        menu();
    }

}
