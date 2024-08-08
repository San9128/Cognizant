DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;

    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee NUMBER := 50; 
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_annual_fee
        WHERE AccountID = v_account_id;

        DBMS_OUTPUT.PUT_LINE('Applied annual fee to Account ID: ' || v_account_id || ', New Balance: ' || (v_balance - v_annual_fee));
    END LOOP;

    COMMIT;
    CLOSE c_accounts;
END;
/
