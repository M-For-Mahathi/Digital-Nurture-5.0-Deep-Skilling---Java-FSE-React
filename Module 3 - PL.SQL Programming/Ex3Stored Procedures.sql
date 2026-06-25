CREATE TABLE Accounts (
    AccountID   NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    AccountType VARCHAR2(20),
    Balance     NUMBER(10,2)
);

CREATE TABLE Employees (
    EmployeeID   NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    DepartmentID NUMBER,
    Salary       NUMBER(10,2)
);

INSERT INTO Accounts VALUES (101, 'Ramesh Kumar', 'Savings', 10000);
INSERT INTO Accounts VALUES (102, 'Anita Sharma', 'Savings', 15000);
INSERT INTO Accounts VALUES (103, 'Suresh Reddy', 'Current', 20000);
INSERT INTO Accounts VALUES (104, 'Priya Nair', 'Savings', 8000);
INSERT INTO Accounts VALUES (105, 'Venkat Rao', 'Current', 12000);

INSERT INTO Employees VALUES (1, 'Rahul Verma', 10, 50000);
INSERT INTO Employees VALUES (2, 'Sneha Gupta', 10, 45000);
INSERT INTO Employees VALUES (3, 'Arjun Reddy', 20, 60000);
INSERT INTO Employees VALUES (4, 'Meera Nair', 20, 55000);
INSERT INTO Employees VALUES (5, 'Kiran Rao', 30, 40000);

COMMIT;

-- Scenario 1: Process Monthly Interest
-- Apply 1% interest to all savings accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied successfully.');

    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

-- Scenario 2: Update Employee Bonus
-- Add bonus percentage to employees in a department

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_DepartmentID NUMBER,
    p_BonusPercent NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE DepartmentID = p_DepartmentID;

    DBMS_OUTPUT.PUT_LINE('Bonus updated for Department '
                         || p_DepartmentID);

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus(10, 10);
END;
/

-- Scenario 3: Transfer Funds
-- Transfer amount from one account to another

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccount NUMBER,
    p_ToAccount NUMBER,
    p_Amount NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');
        DBMS_OUTPUT.PUT_LINE('Amount Transferred: ' || p_Amount);

    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Source Account Not Found');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

BEGIN
    TransferFunds(101, 102, 2000);
END;
/

-- View Updated Data

SELECT * FROM Accounts;
SELECT * FROM Employees;