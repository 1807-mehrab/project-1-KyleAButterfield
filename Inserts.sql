Insert into Users(User_ID, First_Name, Last_Name) Values (1, 'Mark', 'Bedoya');
Insert into User_Login_Credentials(Login_Credentials_ID, Username, Password, User_ID)
Values (1, 'MBedoya', 'password', 1);
Insert into Users(User_ID, First_Name, Last_Name) Values (2, 'Adam', 'Fines');
Insert into User_Login_Credentials(Login_Credentials_ID, Username, Password, User_ID)
Values (2, 'AFines', 'password', 2);
Insert into Users(User_ID, First_Name, Last_Name) Values (3, 'Derrick', 'Cheung');
Insert into User_Login_Credentials(Login_Credentials_ID, Username, Password, User_ID)
Values (3, 'DCheung', 'password', 3);
Insert into Users(User_ID, First_Name, Last_Name) Values (4, 'Michelle', 'Mercer');
Insert into User_Login_Credentials(Login_Credentials_ID, Username, Password, User_ID)
Values (4, 'MMercer', 'password', 4);
commit;

Insert into User_Info(Info_ID, Address, Phone_Number, User_ID) 
Values(1, '101 Fast ST, Tuscan AZ 65463', 5205798890,1);
Insert into User_Info(Info_ID, Address, Phone_Number, User_ID) 
Values(2, '654 Hipster Lane CA 78952', 9998884561,2);
Insert into User_Info(Info_ID, Address, Phone_Number, User_ID) 
Values(3, '179 Happy Trails MI 45693', 4445551234,3);
Insert into User_Info(Info_ID, Address, Phone_Number, User_ID) 
Values(4, '546 This ST ThisTown, ThisState 78951', 123456789,4);
commit;

INSERT into Reimbursement_Requests(Reimbursement_ID, Description, Status, Amount, User_ID, Updater_Name)
Values (1, 'Lunch', 'Denied', 15.95, 1, 'John Oberholtzer');
INSERT into Reimbursement_Requests(Reimbursement_ID, Description, Status, Amount, User_ID)
Values (2, 'Office Supplies', 'Pending', 150.65, 1);
INSERT into Reimbursement_Requests(Reimbursement_ID, Description, Status, Amount, User_ID, Updater_Name)
Values (3, 'Hotel and Travel for event', 'Resolved', 1500.95, 1, 'Kyle Butterfield');
INSERT into Reimbursement_Requests(Reimbursement_ID, Description, Status, Amount, User_ID, Updater_Name)
Values (4, 'Hotel and Travel for event', 'Resolved', 1500.95, 2, 'John Oberholtzer');
INSERT into Reimbursement_Requests(Reimbursement_ID, Description, Status, Amount, User_ID, Updater_Name)
Values (5, 'Hotel and Travel for event', 'Resolved', 1500.95, 3, 'Kyle Butterfield');
INSERT into Reimbursement_Requests(Reimbursement_ID, Description, Status, Amount, User_ID)
Values (6, 'Hotel and Travel for event', 'Pending', 1500.95, 4);
INSERT into Reimbursement_Requests(Reimbursement_ID, Description, Status, Amount, User_ID)
Values (7, 'Paper for printer', 'Pending', 49.95, 2);
commit;

Insert into Admins(Admin_ID, First_Name, Last_Name) Values(1, 'Kyle', 'Butterfield');
Insert into Admin_Login_Credentials(Admin_Credentials_ID, Username, Password, Admin_ID)
Values(1, 'KButterfield', 'password', 1);
Insert into Admin_Info(Info_ID, Address, Phone_Number, Admin_ID)
VALUES(1, '999 Happy St FunTown WY, 9964', 546289177, 1);
Insert into Admins(Admin_ID, First_Name, Last_Name) Values(2, 'John', 'Oberholtzer');
Insert into Admin_Login_Credentials(Admin_Credentials_ID, Username, Password, Admin_ID)
Values(2, 'JOberholtzer', 'password', 2);
Insert into Admin_Info(Info_ID, Address, Phone_Number, Admin_ID)
VALUES(2, '123 Easy ST, NoWhere WA 66758', 546289177, 2);
commit;