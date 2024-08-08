CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id NUMBER,
    p_to_account_id NUMBER,
    p_amount NUMBER
)
IS
    v_balance_from NUMBER;
    v_balance_to NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    -- Get balance of the from account
    SELECT Balance INTO v_balance_from FROM Accounts WHERE AccountID = p_from_account_id FOR UPDATE;
    
    -- Check if there are sufficient funds
    IF v_balance_from < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Perform the transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account_id;

    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
    
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the from account.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/

