package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderFileManager {
    public void saveOrder(Order order){
        try{
        File file=new File("src/main/resources/receipts/"+ LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyyMMdd_HHmmss"))+".txt" );
        FileWriter fileWriter=new FileWriter(file);
        fileWriter.write("Welcome to Marry and the Sandwich");

        for (int i=0; i<order.getListOfSandwich().size(); i++) {
            Sandwich sandwich=order.getListOfSandwich().get(i);
            fileWriter.write(sandwich.toString() + "\n");
            fileWriter.write(order.getName() + "\n");
            fileWriter.write(order.getTotalprice() + "\n");
            fileWriter.write(order.getDrink() + "\n");
            fileWriter.write(order.getChips() + "\n");
        }
        fileWriter.close();
        }catch (IOException ex){
            System.out.println(" failed to upload order");
            ex.printStackTrace();
        }


    }

}
