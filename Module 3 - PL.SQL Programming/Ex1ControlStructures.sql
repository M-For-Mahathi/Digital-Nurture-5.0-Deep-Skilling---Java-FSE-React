CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Age          NUMBER,
    Balance      NUMBER(10, 2),
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER REFERENCES Customers(CustomerID),
    InterestRate NUMBER(5, 2),
    DueDate      DATE
);

INSERT INTO Customers VALUES (1, 'Ramesh Kumar',   65, 15000.00, 'FALSE');
INSERT INTO Customers VALUES (2, 'Anita Sharma',   45, 8000.00,  'FALSE');
INSERT INTO Customers VALUES (3, 'Suresh Reddy',   70, 12000.00, 'FALSE');
INSERT INTO Customers VALUES (4, 'Priya Nair',     30, 500.00,   'FALSE');
INSERT INTO Customers VALUES (5, 'Venkat Rao',     62, 20000.00, 'FALSE');

INSERT INTO Loans VALUES (101, 1, 9.50, SYSDATE + 20);
INSERT INTO Loans VALUES (102, 2, 8.00, SYSDATE + 45);
INSERT INTO Loans VALUES (103, 3, 7.50, SYSDATE + 10);
INSERT INTO Loans VALUES (104, 4, 10.00, SYSDATE + 5);
INSERT INTO Loans VALUES (105, 5, 9.00, SYSDATE + 28);

COMMIT;

-- Scenario 1: Apply 1% discount on loan interest rate for customers above 60 years old

DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, c.CustomerName, c.Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;

    v_customer c_customers%ROWTYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer;
        EXIT WHEN c_customers%NOTFOUND;

        IF v_customer.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = v_customer.LoanID;

            DBMS_OUTPUT.PUT_LINE('Discount applied for ' || v_customer.CustomerName ||
                                 ' (Age: ' || v_customer.Age || ')' ||
                                 ' | New Interest Rate: ' || (v_customer.InterestRate - 1) || '%');
        ELSE
            DBMS_OUTPUT.PUT_LINE('No discount for ' || v_customer.CustomerName ||
                                 ' (Age: ' || v_customer.Age || ')');
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/

-- Scenario 2: Set IsVIP to TRUE for customers with balance over $10,000

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, CustomerName, Balance
        FROM Customers;

    v_customer c_customers%ROWTYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer;
        EXIT WHEN c_customers%NOTFOUND;

        IF v_customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = v_customer.CustomerID;

            DBMS_OUTPUT.PUT_LINE(v_customer.CustomerName ||
                                 ' has been promoted to VIP status.' ||
                                 ' (Balance: $' || v_customer.Balance || ')');
        ELSE
            DBMS_OUTPUT.PUT_LINE(v_customer.CustomerName ||
                                 ' does not qualify for VIP status.' ||
                                 ' (Balance: $' || v_customer.Balance || ')');
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/


-- Scenario 3: Print reminders for loans due within the next 30 days 

DECLARE
    CURSOR c_loans IS
        SELECT c.CustomerName, l.LoanID, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_loan c_loans%ROWTYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan;
        EXIT WHEN c_loans%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_loan.CustomerName ||
                             ', your loan (ID: ' || v_loan.LoanID ||
                             ') is due on ' || TO_CHAR(v_loan.DueDate, 'DD-MON-YYYY') ||
                             '. Please ensure timely payment.');
    END LOOP;
    CLOSE c_loans;
END;
/