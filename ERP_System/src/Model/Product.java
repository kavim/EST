package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Product {

    protected int id;
    protected String name;
    protected int total = 0;

    protected Queue<ProductStock> queue = new LinkedList<>();

    private final Random generator = new Random();

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
        this.ImpStock();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void ImpStock(){

        String initialDate = "06/05/2015";

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        LocalDate data = LocalDate.parse(initialDate, parser);

        int NumEntradas = generator.nextInt(19)+1;

        while (NumEntradas > 0){

            data = data.plusDays(1);

            int randQuant = generator.nextInt(99)+1;

            this.total += randQuant;

            queue.add(new ProductStock(randQuant, data));

            NumEntradas--;
        }

    }

    public Queue<ProductStock> getQueue() {
        return queue;
    }

    public String productInfo(){

        return  "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
                +"\n id: " + getId()
                + "\n nome: " + this.getName()
                + "\n quantidadeTotal: " + this.getTotal()
                + "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";

    }
}
