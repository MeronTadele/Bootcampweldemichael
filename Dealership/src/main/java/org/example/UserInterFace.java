package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterFace {

    Dealership  dealership;

    public void display(){
    init();
        Scanner scanner=new Scanner(System.in);
    while (true){ //display menu
        System.out.println(" Enter your choice please.");
        System.out.println("1)Find vehicles within a price range");
        System.out.println("2)Find vehicles by make / model");
        System.out.println("3)Find vehicles by color");
        System.out.println("4)Find vehicles by mileage range");
        System.out.println("5)Find vehicles by year range");
        System.out.println("6)Find vehicles by type(car,truck,SUV,van)");
        System.out.println("7)List All vehicles");
        System.out.println("8)Add a vehicles");
        System.out.println("9)Remove a vehicle");
        System.out.println("0)quit");
        System.out.println("10) Sale or Lease A vehicle.");
        int ask=Integer.parseInt(scanner.nextLine());
        switch (ask){ // switch statement for user to input
            case 1:GetByPriceRequest(scanner);

            break;
            case 2:GetByMakeModelRequest(scanner);

            break;
            case 3:GetByColorRequest(scanner);


            break;
            case 4:GetByMileageRequest(scanner);

            break;
            case 5:GetByYearRequest(scanner);


            break;
            case 6:GetByVehicleTypeRequest(scanner);


            break;
            case 7:GetAllVehicleRequest();

            break;
            case 8:AddVehiclesRequest(scanner);

            break;
            case 9:RemoveVehicleRequest(scanner);

            break;
            case 0:
             System.exit(0);

            case 10:saleOrLeaseVehicle(scanner);
            break;
            default:
                System.out.println("invalid");


        }

    }
    }

    private void init(){
        DealershipFileManager dealershipFileManager=new DealershipFileManager();
      dealership=dealershipFileManager.getDealership();
    }

    public void GetByPriceRequest(Scanner scanner){
        System.out.println("Enter your min price range.");
        double min=Double.parseDouble(scanner.nextLine());
        System.out.println("Enter your max price range");
        double max=Double.parseDouble(scanner.nextLine());
        helpermethod(dealership.getVehiclesByPrice(min,max));

    }
    public void GetByMakeModelRequest(Scanner scanner){
        System.out.println("Enter what type of make you want.");
        String make=scanner.nextLine().toLowerCase();
        System.out.println("Enter what type od model you want.");
        String model=scanner.nextLine().toLowerCase();
       helpermethod( dealership.getVehiclesByMakeModel(make,model));

    }
    public void GetByYearRequest(Scanner scanner){

        System.out.println("Enter min year  you want.");
        int yearMin=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter max Year you want");
        int yearMax=Integer.parseInt(scanner.nextLine());
       helpermethod(dealership.getVehiclesByYear(yearMin,yearMax));
    }
    public void GetByColorRequest(Scanner scanner){
        System.out.println("Enter your color. ");
        String color=scanner.nextLine().toLowerCase();
        helpermethod(dealership.getVehiclesByColor(color));

    }
    public void GetByMileageRequest(Scanner scanner){
        System.out.println("Enter your min mileage.");
        double miMin=Double.parseDouble(scanner.nextLine());
        System.out.println("Enter your max mileage");
        double mxMin=Double.parseDouble(scanner.nextLine());
      helpermethod(dealership.getVehiclesByMileage(miMin,mxMin));

    }
    public void GetByVehicleTypeRequest(Scanner scanner) {
        try {

            System.out.println("Enter your vehicle type.");
            VehicleType vehicleType = VehicleType.valueOf(scanner.nextLine().toLowerCase());// converting to String
            helpermethod(dealership.getVehiclesByVehicleType(vehicleType));
        }catch (Exception exception){
            System.out.println("invalid");
        }
    }
    public void GetAllVehicleRequest(){
        System.out.println("All our Vehicle List.");
        helpermethod(dealership.getAllVehicles());
    }
    public void AddVehiclesRequest(Scanner scanner){
        VehicleType vehicleType1;
        System.out.println("Add your Vehicle vin.");
        int vin=Integer.parseInt(scanner.nextLine());
        System.out.println("Add your Vehicle year");
        int year=Integer.parseInt(scanner.nextLine());
        System.out.println("Add your Vehicle make");
        String makeVehicle=scanner.nextLine();
        System.out.println("Add your Vehicle model");
        String modelVehicle=scanner.nextLine();
        try {
            System.out.println("Add your VehicleType: from your VehicleType class list ");// todo here is the enum list whem error happen


        }catch (Exception ex){
            System.out.println(" try again from the VehicleType list.");
        }
        vehicleType1 = VehicleType.valueOf(scanner.nextLine().toLowerCase());
        System.out.println("Add your Vehicle color");
        String colorVehicle=scanner.nextLine();
        System.out.println("Add your Vehicle odometer");
        int odometer=Integer.parseInt(scanner.nextLine());
        System.out.println("Add your Vehicle price");
        double priceVehicle=Double.parseDouble(scanner.nextLine());
        System.out.println("Vehicle has been added!");
        dealership.addVehicle(new Vehicle(vin,year,makeVehicle,modelVehicle,vehicleType1,colorVehicle,odometer,priceVehicle));
    }
    public void RemoveVehicleRequest(Scanner scanner){
        System.out.println("Add your Vehicle vin.");
        int vin1=Integer.parseInt(scanner.nextLine());
        System.out.println("Add your Vehicle year");
        int year1=Integer.parseInt(scanner.nextLine());
        System.out.println("Add your Vehicle make");
        String makeVehicle2=scanner.nextLine();
        System.out.println("Add your Vehicle model");
        String modelVehicle2=scanner.nextLine();
        System.out.println("Add your VehicleType( from your VehicleType class list)");
        VehicleType vehicleType2=VehicleType.valueOf(scanner.nextLine().toLowerCase());
        System.out.println("Add your Vehicle color");
        String colorVehicles=scanner.nextLine();
        System.out.println("Add your Vehicle odometer");
        int odometer1=Integer.parseInt(scanner.nextLine());
        System.out.println("Add your Vehicle price");
        double priceVehicles=Double.parseDouble(scanner.nextLine());
        System.out.println("vehicle has been removed!");
        DealershipFileManager dealershipFileManager=new DealershipFileManager();
      dealership.removeVehicle(new Vehicle(vin1,year1,makeVehicle2,modelVehicle2,vehicleType2,colorVehicles,odometer1,priceVehicles));
      dealershipFileManager.saveDealership(dealership.getVehicles());

    }
    public void helpermethod(List<Vehicle> vehicles){ // this method will get all the list from file
        for(int i=0; i<vehicles.size(); i++){
            System.out.println(vehicles.get(i).toString());//todo
        }

    }



public void saleOrLeaseVehicle(Scanner scanner){
    System.out.println("do you want to sale or lease");
    System.out.println("1) for sale Vehicle");
    System.out.println("2) for lease Vehicle");
    int choice=Integer.parseInt(scanner.nextLine());
    int finance=0;
    if(choice==1) {
        System.out.println("do you want to finance? 1) yes 2) no");
        finance = Integer.parseInt(scanner.nextLine());
    }

    System.out.println("what is your name?");
    String name=scanner.nextLine();
    System.out.println("what is your email?");
    String email=scanner.nextLine();
    try {


        System.out.println("Enter your vin number");
        int vin = Integer.parseInt(scanner.nextLine());

        dealership.getSaleOrLeaseVehicle(choice, vin, name, email, finance);
    }catch(Exception ex){
        System.out.println("Enter the right vin number.");
    }
}
}
