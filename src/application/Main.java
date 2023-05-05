package application;

import utilities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Product product;
        String path = "C:\\temp\\in.csv";
        out.println("Iniciando programa");


        try (BufferedReader br = new BufferedReader(new FileReader(path))){
           String line = br.readLine();
           while(line!=null){
               product = new Product();
               Product.validateThreeValues(line);
               if (Product.validateThreeValues(line)) {
                   product.lineSplit(line);
                   out.println(product.getPrice());
               }
                line = br.readLine();
           }





        }
        catch (IOException e){
            out.println("Error: " + e.getMessage());
        }
    }
}