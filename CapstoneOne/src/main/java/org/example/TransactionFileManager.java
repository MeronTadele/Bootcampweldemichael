package org.example;

import javax.imageio.IIOException;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {
    public static List<Transaction> readFile(){
        try {
            FileReader fileReader= new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            bufferedReader.readLine();
            String input;
            List<Transaction> transactionList=new ArrayList<>();
            while ((input = bufferedReader.readLine()) !=null){
                String[] row= input.split("\\|");
                LocalDate date = LocalDate.parse(row[0]);
                LocalTime time= LocalTime.parse(row[1]);
                String description=row[2];
                String vendor=row[3];
                double amount=Double.parseDouble(row[4]);
                Transaction transaction=new Transaction(date,time,description,vendor,amount);
                transactionList.add(transaction);

            }
            bufferedReader.close();
            return transactionList;

        } catch (IOException ex) {
            System.out.println("filed to load new file");
            return new ArrayList<>();
        }
    }
    public static void appendTransaction(Transaction transaction){
        String filepath="src/main/resources/transactions.csv";
        File file = new File(filepath);

        try {
            //  create a folder exists
            File folder = file.getParentFile();
            if (!folder.exists()){
                folder.mkdirs();
            }
            // check if the file exists and is empty
            boolean fileExists =file.exists();
            boolean isEmpty = !fileExists || file.length() == 0;

            //open file in append mode
            FileWriter writer = new FileWriter(file, true);

            // write header if a new or empty file
            if(isEmpty) {
                writer.write("date|time|description|vendor|amount\n");
            }
            // write transaction
            writer.write(transaction.toString() + "\n");
            // close writer
            writer.close();
        }
        catch (IOException ex){
            System.out.println(" failed to write to csv file.");
            ex.printStackTrace();
        }
    }
}
