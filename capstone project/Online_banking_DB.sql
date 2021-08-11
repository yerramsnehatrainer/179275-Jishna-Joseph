show databases;
use online_banking;
show tables;
create table customer(
customer_id			varchar(6),
first_name			varchar(30),
middle_name			varchar(30),
last_name			varchar(30),
city 				date,
mobile_num 			varchar(10),
occupation 			varchar(10),
date_of_birth		date,
CONSTRAINT customer_customer_id_pk PRIMARY KEY(customer_id)
);
select * from customer;

create table Branch(
branch_id 			varchar(6),
branch_name 		varchar(10),
branch_city 		varchar(10),
CONSTRAINT branch_branch_id_pk PRIMARY KEY(branch_id)
);
select * from Branch;

create table Account(
account_number 		varchar(6),
customer_id 		varchar(6),
branch_id 			varchar(6),
opening_balance 	int,
account_opening_date	 date,
account_type 		varchar(10),
account_status 		varchar(10),
CONSTRAINT account_account_number_ok PRIMARY KEY(account_number),
CONSTRAINT account_customer_id_fk FOREIGN KEY(customer_id) REFERENCES Customer(customer_id),
CONSTRAINT account_branch_id_fk FOREIGN KEY(branch_id) REFERENCES Branch(branch_id)
);
select * from Account;

create  table Loan(
customer_id			varchar(6),
branch_id			varchar(6),
loan_amount 		int,
CONSTRAINT Loan_customer_id_branch_id_pk PRIMARY KEY(customer_id,branch_id	),
CONSTRAINT Loan_customer_id_fk FOREIGN KEY(customer_id) REFERENCES  Customer(customer_id),
CONSTRAINT Loan_branch_id_fk FOREIGN KEY(branch_id) REFERENCES  Branch(branch_id)
);
select  * from Loan;

create  table Transaction_details(
transaction_number			varchar(6),
account_num				varchar(6),
date_of_transaction		date,
medium_of_transaction	varchar(20),
transaction_type		varchar(20),
transaction_amount 		int,
CONSTRAINT transaction_details_transaction_number_pk PRIMARY KEY(transaction_number),
 CONSTRAINT transaction_details_account_num_fk FOREIGN KEY(account_num) REFERENCES account(account_num)
);
select  * from Transaction_details;

