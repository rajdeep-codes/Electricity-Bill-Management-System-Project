# Electricity-Billing-System-Project

It’s a GUI-based project used with the Swing module to manage Electricity Bill Management System in Java.

There are two aspects of this application – Admin and Customer.

The admin can create a new customer with new meter information assigned to the customer, view all customer details, and calculate the bills of all the customers. 
The user can create his own account after the admin has created his meter information and once the account is created user can view his account information.


It lets User perform multiple operations like:-

1- User can Signup and create account to track all bill details.

2- User can Calculate and pay their Electricity Bill .

3- User can update their own personal details.

4- User can Generate Bill.

5- User can see their meter info and the payment status of the bill. 


## About Project:
This Java application has been created using IntelliJ IDEA.
Additional library was added for the support of JDBC (Required to setup the connection between the Database and Java Application).

It contains multiple numbers of different classes which works together to create a better user experience .

->Splash Screen class

->Signup Screen class

->Login Screen class

->Main class

->New Customer class

->Pay Bill class

->Generate Bill class

->Customer Details class

->Calculate Bill class

->Bill details class

->Deposit details class

->Meter info class

->Update information class

->View information class

->Database class(JDBC - MySQL)


## Database (MySQL)
Database for this Electricity Billing System contains 5 Tables


->Signup Table (UserName,Password)

->New Customer Table(Name, MeterNumber, Address, State, City, Email, Phone)

->Meter Info Table(Meter Number, Meter Location, Meter Type, Phase Code, Bill Type, Days)

->Tax Table(Cost per unit, Meter Rent, Service Charge, Service Tax, Swacch Bharat Tax, Fixed Tax)

->Bill Table (Meter Number, Month, Unit, Total bill, status) 


Java communicates with MySQL tables using JDBC which stands for Java Database Connectivity.
