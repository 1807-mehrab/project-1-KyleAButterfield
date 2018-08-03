DROP Table User_Login_Credentials;
DROP TABLE Reimbursement_Requests;
DROP TABLE User_Info;
DROP Table Admin_Login_Credentials;
DROP TABLE Admin_Info;
DROP TABLE Images;
DROP Table Users;
DROP Table Admins;


CREATE TABLE Users(
    User_ID int Primary Key,
    First_Name varChar2(50) Not Null,
    Last_Name varChar2(50) Not Null
    
    );

CREATE TABLE User_Login_Credentials(
    Login_Credentials_ID NUMBER PRIMARY Key,
    Username varChar2(50) UNIQUE,
	Password varChar2(50),
	User_ID int,
    FOREIGN KEY (User_ID) REFERENCES Users (User_ID) on delete cascade	
);
	


CREATE TABLE User_Info(
	Info_ID int primary key,
	Address varChar(200),
	Phone_Number int,
	User_ID int,
	FOREIGN KEY (User_ID) REFERENCES Users (User_ID) on delete cascade
);

CREATE TABLE Admins(
    Admin_ID int Primary Key,
    First_Name varChar2(50) Not Null UNIQUE,
    Last_Name varChar2(50) Not Null
    
    );

CREATE TABLE Admin_Login_Credentials
(
    Admin_Credentials_ID NUMBER,
    Username varChar2(50),
	Password varChar2(50),
	Admin_ID int,
    CONSTRAINT PK_Admin_Credentials_ID PRIMARY KEY  (Admin_Credentials_ID),
	FOREIGN KEY (Admin_ID) REFERENCES Admins (Admin_ID) on delete cascade
	
);


	
	CREATE TABLE Admin_Info(
	Info_ID int primary key,
	Address varChar2(200),
	Phone_Number int,
	Admin_ID int,
	FOREIGN KEY (Admin_ID) REFERENCES Admins (Admin_ID) on delete cascade
);

CREATE TABLE Reimbursement_Requests(
    Reimbursement_ID int Primary Key,
	Description varChar(200),
    Status varChar2(8),
	Amount number,
	User_ID int,
	Updater_Name varChar2(100),
	FOREIGN KEY (User_ID) REFERENCES Users (User_ID) on delete cascade,
    check (Status in ('Pending','Resolved', 'Denied'))
	
);

CREATE Table Images(
	Image_Id int primary key,
	Image clob,
	Reimbursement_ID int,
	FOREIGN KEY (Reimbursement_ID) REFERENCES Reimbursement_Requests (Reimbursement_ID) on delete cascade
);