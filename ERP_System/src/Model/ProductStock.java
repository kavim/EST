package Model;

import java.time.LocalDate;
import java.util.Date;

public class ProductStock{

    private int quantidade;
    private LocalDate data;

    public ProductStock(int quantidade, LocalDate data) {
        this.quantidade = quantidade;
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getInfo(){
        return "\t Quantidade: "+this.getQuantidade()+" Data : "+this.getData();
    }
}
