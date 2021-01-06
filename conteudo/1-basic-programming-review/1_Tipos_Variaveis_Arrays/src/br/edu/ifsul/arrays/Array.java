package br.edu.ifsul.arrays;

public class Array {

    public static void main(String[] args) {

        int[] numeros = new int[5];

        numeros[0] = 900;

        System.out.println(numeros[0]);

        int[] valores = {1, 2, 3, 4, 5};

        for (int i = 0; i < valores.length; i++) {
            System.out.println(valores[i]);
        }
    }
}
