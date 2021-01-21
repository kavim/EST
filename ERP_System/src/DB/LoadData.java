/*
    Esse caminho pode ser escrito de melhor forma implementando um metodo para ler o caminho a partir de qualquer maquina que tente exutar esse codigo
    csv path = C:\Users\kevin\Documents\GitHub\EST\Products.csv
 */

package DB;

import Model.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadData {

    protected ArrayList<Product> products;
    public static final String csvDivisor = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    public void run() {

//        String arquivoCSV = "C:\\Users\\kevin\\Documents\\GitHub\\EST\\Products.csv";
        String arquivoCSV = System.getProperty("user.dir")+"\\Products.csv"; //no windows funciona assim
        BufferedReader br = null;
        String line = "";

        try {
            ArrayList<Product> records = new ArrayList();

            br = new BufferedReader(new FileReader(arquivoCSV));
            indexingCSV(br.readLine());

            System.out.println("\nCarregando...\n");

            int iii = 0;

            // Limit to save time :).
            while ((line = br.readLine()) != null && iii < 1000) {

                String[] row = line.split(csvDivisor);

                records.add(new Product(Integer.parseInt(row[0].trim()), row[21]));

                iii++;

            }

            System.out.println("\nPronto! \n");

            this.setProducts(records);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void indexingCSV(String firstLine) {

        String[] SplitedFirstLine = firstLine.split(csvDivisor);

        for (int i = 0; i < SplitedFirstLine.length; i++) {
//            System.out.print("\t\t" + i);
//            System.out.print(" : "+SplitedFirstLine[i]);
        }

    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


}
