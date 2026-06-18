import java.util.HashMap;

public class FinancialForecasting {

    // Recursive method to calculate future value
    // Formula: futureValue = presentValue * (1 + growthRate) ^ years
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: no years left, return present value as-is
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: apply growth for one year, then recurse for remaining years
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized version using memoization to avoid recomputing the same subproblems
    static HashMap<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = calculateFutureValueMemo(presentValue * (1 + growthRate), growthRate, years - 1);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {

        double presentValue = 10000.0;
        double growthRate = 0.08; // 8% annual growth
        int years = 5;

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Present Value  : Rs." + presentValue);
        System.out.println("Growth Rate    : " + (growthRate * 100) + "%");
        System.out.println("Years          : " + years);
        System.out.println();

        // Plain recursive approach
        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value (Recursive)    : Rs.%.2f%n", futureValue);

        // Memoized recursive approach
        memo.clear();
        double futureValueMemo = calculateFutureValueMemo(presentValue, growthRate, years);
        System.out.printf("Future Value (Memoized)     : Rs.%.2f%n", futureValueMemo);

        System.out.println();
        System.out.println("=== Year-by-Year Forecast ===");
        for (int i = 1; i <= years; i++) {
            System.out.printf("Year %d : Rs.%.2f%n", i, calculateFutureValue(presentValue, growthRate, i));
        }

        System.out.println();
        System.out.println("=== Time Complexity Analysis ===");
        System.out.println("Plain Recursive : O(n) - one call per year, no repeated work here");
        System.out.println("Memoized        : O(n) time, O(n) space - avoids recomputation if called multiple times");
        System.out.println("Iterative       : O(n) time, O(1) space - most efficient for this specific problem");
    }
}