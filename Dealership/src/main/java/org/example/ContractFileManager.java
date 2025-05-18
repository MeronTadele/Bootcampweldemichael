package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private final String File_Path="src/main/resources/contracts.csv";
   public void saveContract(Contract contract){
       File file=new File(File_Path);

       try {
           File folder = file.getParentFile();
           if (!folder.exists()) {
               folder.mkdirs();
           }
           FileWriter fileWriter = new FileWriter(file,true );
           if (contract instanceof SalesContract) {
               fileWriter.write("Sale|" +contract.toString()+"\n");
               fileWriter.write(contract.getVehicle().toString()+"\n");
               fileWriter.write(String.valueOf(((SalesContract) contract).toString1())+"\n");
           } else if (contract instanceof LeaseContract) {
               fileWriter.write("Lease|"+contract.toString()+"\n");
               fileWriter.write(contract.getVehicle().toString()+"\n");
               fileWriter.write(String.valueOf(((LeaseContract) contract).toString())+"\n");

           }
           fileWriter.close();
       }
         catch (IOException ex) {
           System.out.println("Failed to write to csv file.");
           ex.printStackTrace();
       }

   }
}
