CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    CURSOR c_savings_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
        FOR UPDATE;
BEGIN
    FOR account_rec IN c_savings_accounts LOOP
        -- Calculate interest
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = account_rec.AccountID;
    END LOOP;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END ProcessMonthlyInterest;
/
