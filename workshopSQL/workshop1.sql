drop Database if exists cardealership;
CREATE DATABASE if not exists cardealership;
use cardealership;

 Create TABLE dealership (
Dealership_id int auto_increment PRIMARY KEY,
Name varchar(50) not null,
Address varchar(50),
phone varchar(12)
);
INSERT INTO dealership (Name, Address, phone) VALUES
('City Motors', '123 Main St, Cityville', '555-111-2222'),
('Town Autos', '456 Oak Rd, Townsville', '555-222-3333'),
('Suburb Cars', '789 Pine Ln, Suburbia', '555-333-4444'),
('Metro Vehicles', '321 Cedar St, Metro City', '555-444-5555'),
('Auto Plaza', '654 Spruce Ave, Autoville', '555-555-6666');

Create Table vehicles(
Vin_number varchar(50)  primary key,
vehicle_make varchar(50) not null,
vehicle_type varchar(50) not null,
vehicle_model varchar(50) not null,
vehicle_year int,
price decimal(15,2),
sold bit

);
INSERT INTO vehicles (Vin_number, vehicle_make, vehicle_type, vehicle_model, vehicle_year, price, sold) VALUES
('VIN0000001', 'Toyota', 'SUV', 'Rav4', 2021, 32000.00, 1),
('VIN0000002', 'Honda', 'Sedan', 'Accord', 2020, 27000.00, 0),
('VIN0000003', 'Ford', 'Truck', 'F-150', 2019, 35000.00, 1),
('VIN0000004', 'BMW', 'Coupe', 'M4', 2022, 54000.00, 0),
('VIN0000005', 'Chevrolet', 'SUV', 'Tahoe', 2021, 48000.00, 1),
('VIN0000006', 'Nissan', 'Sedan', 'Altima', 2021, 28000.00, 0),
('VIN0000007', 'Mazda', 'SUV', 'CX-5', 2020, 29000.00, 1),
('VIN0000008', 'Subaru', 'Wagon', 'Outback', 2019, 28500.00, 0),
('VIN0000009', 'Audi', 'Sedan', 'A4', 2022, 31000.00, 1),
('VIN0000010', 'Mercedes', 'SUV', 'GLC', 2021, 31500.00, 0),
('VIN0000011', 'Kia', 'Sedan', 'Optima', 2020, 25000.00, 0),
('VIN0000012', 'Hyundai', 'SUV', 'Santa Fe', 2021, 30000.00, 1),
('VIN0000013', 'Volkswagen', 'Hatchback', 'Golf', 2019, 22000.00, 0),
('VIN0000014', 'Jeep', 'SUV', 'Wrangler', 2022, 40000.00, 0),
('VIN0000015', 'Tesla', 'Sedan', 'Model 3', 2021, 45000.00, 1),
('VIN0000016', 'Chevrolet', 'Truck', 'Silverado', 2020, 36000.00, 0),
('VIN0000017', 'Ford', 'SUV', 'Explorer', 2019, 34000.00, 1),
('VIN0000018', 'Honda', 'Sedan', 'Civic', 2022, 26000.00, 0),
('VIN0000019', 'BMW', 'Sedan', '3 Series', 2021, 41000.00, 1),
('VIN0000020', 'Toyota', 'Truck', 'Tacoma', 2020, 33000.00, 0);


Create Table inventory(
dealership_id int,
FOREIGN KEY (dealership_id) REFERENCES dealership (dealership_id),
vin_number varchar(50),
FOREIGN KEY (vin_number) REFERENCES vehicles (vin_number) 

);
INSERT INTO inventory (dealership_id, vin_number) VALUES
(1, 'VIN0000001'),
(1, 'VIN0000002'),
(2, 'VIN0000003'),
(2, 'VIN0000004'),
(3, 'VIN0000005'),
(3, 'VIN0000006'),
(4, 'VIN0000007'),
(4, 'VIN0000008'),
(5, 'VIN0000009'),
(5, 'VIN0000010'),
(1, 'VIN0000011'),
(2, 'VIN0000012'),
(3, 'VIN0000013'),
(4, 'VIN0000014'),
(5, 'VIN0000015'),
(1, 'VIN0000016'),
(2, 'VIN0000017'),
(3, 'VIN0000018'),
(4, 'VIN0000019'),
(5, 'VIN0000020');


Create Table sales_contracts(
Sales_id  int auto_increment primary key,
vin_number varchar(50),
FOREIGN KEY (vin_number) REFERENCES vehicles (vin_number),
Name varchar(50),
Email_address varchar(50),
Address varchar(50),
phone varchar(12),
date varchar(12),
ProcessingFee decimal(15,2),
TaxAmount decimal(15,2),
Financed bit,
Total_price decimal(15,2),
Monthly_Payment decimal(15,2)
);
INSERT INTO sales_contracts (vin_number, Name, Email_address, Address, phone, date, ProcessingFee, TaxAmount, Financed, Total_price, Monthly_Payment) VALUES
('VIN0000001', 'Emma Johnson', 'emma.johnson@example.com', '123 Main St, Cityville', '555-123-4567', '2024-05-12', 350.00, 2800.00, 1, 35150.00, 583.33),
('VIN0000003', 'Liam Smith', 'liam.smith@example.com', '456 Oak Rd, Townville', '555-234-5678', '2023-12-01', 400.00, 3200.00, 0, 35400.00, NULL),
('VIN0000005', 'Olivia Brown', 'olivia.brown@example.com', '789 Pine Ln, Villageville', '555-345-6789', '2024-01-15', 375.00, 3000.00, 1, 48375.00, 806.25),
('VIN0000007', 'Noah Davis', 'noah.davis@example.com', '321 Cedar St, Hamletville', '555-456-7890', '2024-03-22', 360.00, 2900.00, 1, 32260.00, 537.67),
('VIN0000009', 'Ava Miller', 'ava.miller@example.com', '654 Spruce Ave, Boroughville', '555-567-8901', '2023-11-05', 390.00, 3100.00, 0, 34690.00, NULL),
('VIN0000012', 'James Wilson', 'james.wilson@example.com', '987 Elm Blvd, Metropolis', '555-678-9012', '2024-02-28', 340.00, 2750.00, 1, 33090.00, 551.50),
('VIN0000015', 'Isabella Moore', 'isabella.moore@example.com', '213 Birch Rd, Capital City', '555-789-0123', '2024-04-11', 370.00, 2950.00, 0, 48320.00, NULL),
('VIN0000017', 'Benjamin Taylor', 'benjamin.taylor@example.com', '546 Walnut St, Suburbia', '555-890-1234', '2023-10-20', 355.00, 2850.00, 1, 37205.00, 620.08),
('VIN0000019', 'Sophia Anderson', 'sophia.anderson@example.com', '879 Chestnut Ln, Town', '555-901-2345', '2024-05-05', 380.00, 3000.00, 0, 44480.00, NULL);


Create Table lease_contracts(
lease_id  int auto_increment primary key,
vin_number varchar(50),
FOREIGN KEY (vin_number) REFERENCES vehicles (vin_number),
Name varchar(50),
Email_address varchar(50),
Address varchar(50),
phone varchar(12),
date varchar(12),
lease_Fee decimal(15,2),
TaxAmount decimal(15,2),
endingValue int,
Total_price decimal(15,2),
Monthly_Payment decimal (15,2)
);
INSERT INTO lease_contracts (vin_number, Name, Email_address, Address, phone, date, lease_Fee, TaxAmount, endingValue, Total_price, Monthly_Payment) VALUES
('VIN0000002', 'Charlotte Lee', 'charlotte.lee@example.com', '432 Aspen Way, Cityville', '555-111-2222', '2024-06-15', 600.00, 2800.00, 15000, 32000.00, 533.33),
('VIN0000004', 'Ethan Harris', 'ethan.harris@example.com', '765 Fir Rd, Townville', '555-222-3333', '2024-03-10', 620.00, 2900.00, 16000, 33000.00, 550.00),
('VIN0000006', 'Amelia Clark', 'amelia.clark@example.com', '987 Willow Blvd, Villageville', '555-333-4444', '2023-12-20', 610.00, 2850.00, 15500, 32500.00, 540.00),
('VIN0000008', 'Logan Lewis', 'logan.lewis@example.com', '654 Cypress Ln, Hamletville', '555-444-5555', '2024-01-15', 580.00, 2750.00, 14500, 31000.00, 516.67),
('VIN0000010', 'Mia Robinson', 'mia.robinson@example.com', '321 Redwood St, Boroughville', '555-555-6666', '2024-05-01', 590.00, 2800.00, 14800, 31500.00, 525.00);
