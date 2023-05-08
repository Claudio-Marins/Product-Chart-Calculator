package application;

import utilities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Product product;
        String sourcePath = "C:\\temp\\in.csv";
        String targetPath = "C:\\temp\\summary.csv";
        out.println("Iniciando programa");
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourcePath))){
           String line = br.readLine();
           while(line!=null){
               product = new Product();
               Product.validateThreeValues(line);
               if (Product.validateThreeValues(line)) {
                   product.lineSplit(line);
                   Product.validateTypeValue(product.getPrice(),product.getQuantity());
                   list.add(product.nameReturn());

               }
                line = br.readLine();
           }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath))){
                for (String lines:list){
                    bw.write(lines);
                    bw.newLine();
                }

            }
            catch (IOException e){
                out.println("Error: " + e.getMessage());
            }

        }
        catch (IOException e){
            out.println("Error: " + e.getMessage());
        }























    }
}