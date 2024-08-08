CREATE SEQUENCE AuditLog_seq
START WITH 1
INCREMENT BY 1;
CREATE SEQUENCE AuditLog_seq
START WITH 1
INCREMENT BY 1;
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
 
    INSERT INTO AuditLog (LogID, TransactionID, AccountID, TransactionDate, Amount, TransactionType, LogTimestamp)
    VALUES (AuditLog_seq.NEXTVAL, :NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType, SYSDATE);
END LogTransaction;
/

