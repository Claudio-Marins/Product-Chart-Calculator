package utilities;

import com.sun.source.tree.IfTree;

import javax.sound.sampled.Line;

public class Product {
    private String line;
    private String name;
    private Double price;
    private Integer quantity;


    public Product() {
    }
    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public void lineSplit(String line) {
        String[] parts = line.split(",");
        this.name = parts[0];
        this.price = Double.parseDouble(parts[1]);
        this.quantity = Integer.parseInt(parts[2]);
    }

    public static boolean validateThreeValues(String line) {
        int commaCounter = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                commaCounter++;
            }
        }
        if (commaCounter != 2){
            return false;
        }
        return true;
    }


    public static boolean validateTypeValue(Double price, Integer quantity) {
        if (price != null || quantity != null) {
            if (price instanceof Double || quantity instanceof Integer) {
                return true;
            }
        }
        return false;
    }


    public String nameReturn(){
        double sum = price*quantity;
        return name + ", " + sum + ".";
    }



}
