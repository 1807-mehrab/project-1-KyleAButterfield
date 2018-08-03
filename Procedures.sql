/*******************************************************************************
   Sequence and Trigger
********************************************************************************/
--users
CREATE SEQUENCE SQ_User_ID_PK START WITH 5 INCREMENT BY 1;
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_INSERT_User
BEFORE INSERT ON Users
FOR EACH ROW
BEGIN
    SELECT SQ_User_ID_PK.NEXTVAL INTO :NEW.User_ID FROM DUAL;
END;
/

--Admins
CREATE SEQUENCE SQ_Admin_ID_PK START WITH 3 INCREMENT BY 1;
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_INSERT_Admin
BEFORE INSERT ON Admins
FOR EACH ROW
BEGIN
    SELECT SQ_Admin_ID_PK.NEXTVAL INTO :NEW.Admin_ID FROM DUAL;
END;
/

-- User Login Credentials
CREATE SEQUENCE SQ_User_Login_Credentials_PK START WITH 5 INCREMENT BY 1;
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_INSERT_Login_Credentials
BEFORE INSERT ON User_Login_Credentials
FOR EACH ROW
BEGIN
    SELECT SQ_User_Login_Credentials_PK.NEXTVAL INTO :NEW.Login_Credentials_ID FROM DUAL;
END;
/
-- Reimburesment Requests
CREATE SEQUENCE SQ_Reimbursement_Requests_PK START WITH 8  INCREMENT BY 1;
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_INS_REIMB_RQST
BEFORE INSERT ON Reimbursement_Requests
FOR EACH ROW
BEGIN
    SELECT SQ_Reimbursement_Requests_PK.NEXTVAL INTO :NEW.Reimbursement_ID FROM DUAL;
END;
/
-- User Info
CREATE SEQUENCE SQ_User_Info_PK START WITH 5  INCREMENT BY 1;
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_User_Info
BEFORE INSERT ON User_Info
FOR EACH ROW
BEGIN
    SELECT SQ_User_Info_PK.NEXTVAL INTO :NEW.Info_ID FROM DUAL;
END;
/
--Admin Info
CREATE SEQUENCE SQ_Admin_Info_PK START WITH 3  INCREMENT BY 1;
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_Admin_Info
BEFORE INSERT ON User_Info
FOR EACH ROW
BEGIN
    SELECT SQ_Admin_Info_PK.NEXTVAL INTO :NEW.Info_ID FROM DUAL;
END;
/

--Admin Login Credentials
CREATE SEQUENCE SQ_Admin_Login_Credentials_PK START WITH 3 INCREMENT BY 1;
-- Trigger (before insert, use sequence)
CREATE OR REPLACE TRIGGER TR_INS_Admin_Creds
BEFORE INSERT ON Admin_Login_Credentials
FOR EACH ROW
BEGIN
    SELECT SQ_Admin_Login_Credentials_PK.NEXTVAL INTO :NEW.Admin_Credentials_ID FROM DUAL;
END;
/
--images
CREATE SEQUENCE SQ_IMAGE_PK START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_IMAGE
BEFORE INSERT ON Images
FOR EACH ROW
BEGIN
    SELECT SQ_IMAGE_PK.NEXTVAL INTO :NEW.Image_ID FROM DUAL;
END;
/
/*******************************************************************************
   Procedure
********************************************************************************/

--Alter the status of a request from pending to 'Resolved'
CREATE OR REPLACE Procedure SP_Update_Rqst
(R_ID IN Number, A_Name IN VARCHAR2) AS
BEGIN
	UPDATE  Reimbursement_Requests SET Status = 'Resolved', Updater_Name = A_Name
		WHERE Reimbursement_ID = R_ID;
	commit;
END;
/

--Deny a request
CREATE OR REPLACE Procedure SP_Deny_Rqst
(R_ID IN Number, A_Name in VARCHAR2) AS
BEGIN
	UPDATE Reimbursement_Requests SET Status = 'Denied', Updater_Name = A_Name
		WHERE Reimbursement_ID = R_ID;
	commit;
END;
/

--Create a new Reimbursement Request
CREATE OR REPLACE PROCEDURE SP_New_Reimburse_rqst
(User_ID IN NUMBER,V_Desc IN VARCHAR2, T_Amount IN NUMBER) AS
BEGIN
    --SAVEPOINT;
    
    INSERT INTO Reimbursement_Requests (Reimbursement_ID, Description, Status, Amount, User_ID)
	VALUES (1, V_Desc,'Pending', T_Amount, User_ID);
    COMMIT;
END;
/


-- Stored Procedure to create a new User
create or replace PROCEDURE SP_CREATE_User
(First IN VARCHAR2, Last IN VARCHAR2, Username IN VARCHAR2, Pass IN VARCHAR2,
Address IN VARCHAR2, Phone IN NUMBER) 
IS
    V_User_ID NUMBER;

BEGIN
    --SAVEPOINT;


    INSERT INTO Users (User_ID, First_Name, Last_Name) VALUES (1,First, Last);
    SELECT MAX(User_ID) INTO V_User_ID from Users;
    INSERT INTO User_Login_Credentials (Login_Credentials_ID, Username, Password, User_ID)
    VALUES (1, Username, Pass, V_User_ID);
	INSERT INTO User_Info(Info_ID, Address, Phone_Number, User_ID) 
	VALUES (1, Address, Phone, V_User_ID);


    --ROLLBACK    
    COMMIT;
END;

/
--Stored Procedure to create a new Admin
create or replace PROCEDURE SP_CREATE_Admin
(First IN VARCHAR2, Last IN VARCHAR2, Username IN VARCHAR2, Pass IN VARCHAR2,
Address IN VARCHAR2, Phone IN NUMBER) 
IS
    V_Admin_ID NUMBER;

BEGIN
    --SAVEPOINT;


    INSERT INTO Admins (Admin_ID, First_Name, Last_Name) VALUES (1,First, Last);
    SELECT MAX(Admin_ID) INTO V_Admin_ID from Admins;
    INSERT INTO Admin_Login_Credentials (Admin_Credentials_ID, Username, Password, Admin_ID)
    VALUES (1, Username, Pass, V_Admin_ID);
	INSERT INTO Admin_Info(Info_ID, Address, Phone_Number, Admin_ID) 
	VALUES (1, Address, Phone, V_Admin_ID);


    --ROLLBACK    
    COMMIT;
END;
/



--update users address
create or replace procedure SP_Update_User_Address
(V_Address in VARCHAR2, V_USER_ID in Number) AS
BEGIN
	UPDATE User_Info set Address = V_Address WHERE User_ID = V_USER_ID;
	commit;
END;
/

--update users phone number
create or replace procedure SP_Update_User_Phone
(V_Phone in Number, V_USER_ID in Number) AS
BEGIN
	UPDATE User_Info set Phone_Number = V_Phone WHERE User_ID = V_USER_ID;
	commit;
END;
/

--update admin address
create or replace procedure SP_Update_Admin_Address
(V_Address in VARCHAR2, V_Admin_ID in Number) AS
BEGIN
	UPDATE Admin_Info set Address = V_Address WHERE Admin_ID = V_Admin_ID;
	commit;
END;
/

--update admin phone number
create or replace procedure SP_Update_Admin_Phone
(V_Phone in Number, V_Admin_ID in Number) AS
BEGIN
	UPDATE Admin_Info set Phone_Number = V_Phone WHERE Admin_ID = V_Admin_ID;
	commit;
END;
/


CREATE OR REPLACE PROCEDURE SP_CREATE_IMAGE
(RID IN NUMBER, IMAGE IN CLOB) AS
BEGIN
    --SAVEPOINT; --Needed for rollback if you want to test the procedure without commiting data
    INSERT INTO Images (Image_Id,Image, Reimbursement_ID) VALUES (1, IMAGE,RID);

    --ROLLBACK
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE SP_DEL_IMAGE
(IID IN NUMBER) AS
BEGIN
    DELETE FROM IMAGES WHERE Image_ID = IID;

    COMMIT;
END;
/

commit;