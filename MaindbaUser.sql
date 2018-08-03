
/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER erskMAINDBA CASCADE;

/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER erskMAINDBA 
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to erskMAINDBA;
GRANT resource to erskMAINDBA;
GRANT create view TO erskMAINDBA;
GRANT create table TO erskMAINDBA;
GRANT create view TO erskMAINDBA;

--conn erskMAINDBA/p4ssw0rd
