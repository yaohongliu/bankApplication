 
 -- customer table for store customer's basic information and customer ID
create table t_customer (
	customer_id INT NOT NULL, 
	customer_name VARCHAR(40),
	customer_phone int,
	customer_email VARCHAR(40),
	address VARCHAR(80),
	customer_login VARCHAR(20),
	customer_password VARCHAr(20),
	dob date,
	PRIMARY KEY (customer_id)
);
 -- employee table for storing employee's basic information and employee ID
create table t_employee (
	employee_id int not null,
	employee_name varchar(40),
	employee_phone int,
	employee_email varchar(20),
	employee_login varchar(40),
	employee_password varchar(40)
	primary key(employee_id),
	
);
 -- employee table for recording customer's account and balance
create table t_account (
	account_id int not null,
	customer_id int,
	balance float,
	create_date date
	primary key(account_id),
	foreign key(customer_id)
);
 -- transaction table for recording transactions from customer or employee
create table t_transaction(
	transaction_id int not null,
	from_account int not null,
	to_account int default,
	amount float,
	transaction_time date,
	primary key(transaction_id),
	foreign key(from_account),
	foreign key(to_account)
);