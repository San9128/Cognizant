CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id NUMBER,
    p_to_account_id NUMBER,
    p_amount NUMBER
)
IS
    v_balance_from NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    -- Get balance of the source account
    SELECT Balance INTO v_balance_from 
    FROM Accounts 
    WHERE AccountID = p_from_account_id 
    FOR UPDATE;

    -- Check if there are sufficient funds
    IF v_balance_from < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Deduct amount from source account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add amount to destination account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/
