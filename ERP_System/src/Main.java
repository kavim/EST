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

        productController = new ProductController(loadData.getProducts(), loadData.populateTree());

        menu();
    }

    public static void menu(){
        System.out.println("\n1 – Buscar produto por código");
        System.out.println("2 – Buscar produto por nome.");
        System.out.println("3 – Retirar Produtos por Código.");
        System.out.println("4 – showStock");
        System.out.println("5 – Buscar por produtos em árvore binária");

        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();

        if(choice == 1){

            System.out.println("Digite o codigo do produto");

            int id = input.nextInt();
            Product found = productController.findById(id);

            if(found == null){
                System.out.println("Nenhum produto encontrado :(");
                menu();
            }

            System.out.println(found.productInfo());

            found.ImpStock();

            menu();

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
                System.out.println(p.productInfo());
            }
            System.out.println(founds.size() + " produtos encontrados");

            menu();
        }

        if (choice == 3){

            System.out.println("Digite o codigo do produto para remover");
            int id = input.nextInt();
            System.out.println("\n" + "Ingrese la cantidad");
            int quant = input.nextInt();
            productController.remove(id, quant);
            menu();

        }

        if (choice == 4){

            System.out.println("Digite o codigo do produto");
            int id = input.nextInt();
            productController.showStock(id);

            menu();

        }

        if (choice == 5){

            System.out.println("Digite o codigo do produto");
            int id = input.nextInt();

            Product found = productController.binarySearch(id);

            if(found == null){
                System.out.println("Nenhum produto encontrado :(");
                menu();
            }

            System.out.println(found.productInfo());

            menu();

        }

        input.close();

        menu();
    }

}
