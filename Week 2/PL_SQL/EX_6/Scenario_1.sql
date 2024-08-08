CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
    invalid_deposit EXCEPTION;
BEGIN
    
    IF :NEW.TransactionType = 'Withdrawal' THEN
     
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID
        FOR UPDATE;

     
        IF v_balance < :NEW.Amount THEN
            RAISE insufficient_funds;
        END IF;

    ELSIF :NEW.TransactionType = 'Deposit' THEN
        
        IF :NEW.Amount <= 0 THEN
            RAISE invalid_deposit;
        END IF;
    END IF;

EXCEPTION
    WHEN insufficient_funds THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for this withdrawal.');

    WHEN invalid_deposit THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
END CheckTransactionRules;
/
