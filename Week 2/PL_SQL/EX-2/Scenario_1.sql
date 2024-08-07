DECLARE
    CURSOR c_monthly_transactions IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, c.Name
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TO_CHAR(t.TransactionDate, 'YYYY-MM') = TO_CHAR(SYSDATE, 'YYYY-MM');
    
    transaction_rec c_monthly_transactions%ROWTYPE;
BEGIN
    OPEN c_monthly_transactions;
    LOOP
        FETCH c_monthly_transactions INTO transaction_rec;
        EXIT WHEN c_monthly_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || transaction_rec.Name);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || TO_CHAR(transaction_rec.TransactionDate, 'YYYY-MM-DD'));
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || transaction_rec.TransactionType);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || transaction_rec.Amount);
        DBMS_OUTPUT.PUT_LINE('-----------------------------------');
    END LOOP;

    CLOSE c_monthly_transactions;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
        IF c_monthly_transactions%ISOPEN THEN
            CLOSE c_monthly_transactions;
        END IF;
END;
/
