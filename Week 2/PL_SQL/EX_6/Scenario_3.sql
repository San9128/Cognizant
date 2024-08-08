DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;

    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_interest_rate NUMBER;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN c_loans%NOTFOUND;

        v_new_interest_rate := v_interest_rate - 0.5;

        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loan_id;

        DBMS_OUTPUT.PUT_LINE('Updated Loan ID: ' || v_loan_id || ', New Interest Rate: ' || v_new_interest_rate);
    END LOOP;

    COMMIT;
    CLOSE c_loans;
END;
/
