create database vehicle_db;

use vehicle_db;

describe vehicle;

insert into vehicle(make, model, year, color, mileage)
	values ('Toyota', 'Tacoma', '2012', 'red', '80000'),
			('Toyota', 'Tundra', '2015', 'dark grey', '115000'),
            ('Chevy', 'Malibu', '2020', 'white', '20000'),
            ('Jeep', 'Wrangler', '2018', 'black', '85000'),
            ('Toyota', 'Tacoma', '2012', 'black', '150000'),
            ('Toyota', 'Tacoma', '2012', 'white', '145000'),
            ('Ford', 'Ranger', '2015', 'dark grey', '80000'),
            ('Ford', 'F-150', '2016', 'blue', '80000'),
            ('Ford', 'Explorer', '2019', 'white', '80000'),
            ('Ford', 'Fusion', '2017', 'silver', '80000'),
            ('Nissan', 'Altima', '2014', 'silver', '80000'),
            ('Nissan', 'Sentra', '2014', 'black', '80000'),
            ('Nissan', 'Rouge', '2017', 'tan', '80000'),
            ('Nissan', 'GTR', '2021', 'Black', '1000');
            
select * from vehicle;