package c6;
public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000; 
        double growthRate = 0.05; 
        int periods = 10; 

        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.printf("The future value after %d periods is: $%.2f%n", periods, futureValue);
    }
}
