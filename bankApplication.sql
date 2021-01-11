 
 -- customer table for store customer's basic information and customer ID
create table t_customer (
	customer_id SERIAL PRIMARY KEY, 
	customer_name VARCHAR(40),
	customer_email VARCHAR(40),
	customer_login VARCHAR(20),
	customer_password VARCHAr(20),
	dob date
);

 -- employee table for storing employee's basic information and employee ID
create table t_employee (
	employee_id SERIAL PRIMARY KEY,
	employee_name varchar(40),
	employee_email varchar(20),
	employee_login varchar(40),
	employee_password varchar(40)
);

 -- employee table for recording customer's account and balance
create table t_account (
	account_id SERIAL PRIMARY KEY,
	customer_id int,
	balance float,
	create_date date,
	approved boolean not null, 
	foreign key(customer_id) references t_customer (customer_id)
);

 -- transaction table for recording transactions from customer or employee
create table t_transaction(
	transaction_id SERIAL PRIMARY KEY,
	from_account int not null,
	to_account int,
	amount float,
	transaction_time date,
	foreign key(from_account) references t_account (account_id),
	foreign key(to_account) references t_account (account_id)
);

 
