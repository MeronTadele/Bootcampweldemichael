package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<Product> readFile() {

        //use file reader class and buffered reader to load the file
        //loop through file live by line
        // take each line and split it on the |
        // we need to converse date as needed ( price to string from double)
        // create a product object to the hold date
        //put it the product in a list
        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //skip the first line
            bufferedReader.readLine();
            String input;
            List<Product> productList= new ArrayList<>();
            while ((input = bufferedReader.readLine()) != null) {
                String[] row =input.split("\\|");
                //index 0 is sku, index 1 is prouductName index2 is price and index 3 is department
                String sku =row[0];
                String productname=row[1];
                double price =Double.parseDouble(row[2]);
                String department=row[3];
                Product product=new Product(sku,productname,price,department);
                productList.add(product);
            }
            bufferedReader.close();
            return productList;
        }
            catch (IOException ex) {
                System.out.println("filed to load new file");
                return new ArrayList<>();// this a empty list in case we fail



        }
    }
}
