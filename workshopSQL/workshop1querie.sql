-- 1. Get all dealerships 
select * 
from dealership;
-- 2. Find all vehicles for a specific dealership
select * 
from vehicles
join inventory i on vehicles.vin_number=i.Vin_number
Where dealership_id=1;

-- 3. Find a car by VIN
select *
from vehicles
where vin_number= 'VIN0000001';
-- 4. Find the dealership where a certain car is located, by VIN
select *
from dealership
join inventory i on dealership.dealership_id=i.dealership_id
where vin_number='VIN0000003';
-- 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang)
select *
from dealership
join inventory i on dealership.dealership_id=i.dealership_id
join vehicles v on i.Vin_number=v.vin_number
where vehicle_type='suv';
-- 6. Get all sales information for a specific dealer for a specific date range
select *
from sales_contracts
join vehicles v on sales_contracts.vin_number=v.vin_number
join inventory i on v.vin_number=i.Vin_number
JOIN dealership d ON i.dealership_id = d.dealership_id
where d.dealership_id=4 and STR_TO_DATE(Date, '%Y-%m-%d') BETWEEN '2023-11-05' AND '2024-01-15';
 
