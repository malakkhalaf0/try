package malak;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

class Transaction {
    private String traderName;
    private int year;
    private int value;

    public Transaction(String traderName, int year, int value) {
        this.traderName = traderName;
        this.year = year;
        this.value = value;
    }

    public String getTraderName() {
        return traderName;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "traderName='" + traderName + '\'' +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}

public class StreamAdvancedChallenge2 {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Alice", 2012, 1000),
                new Transaction("Bob", 2011, 1500),
                new Transaction("Charlie", 2012, 800),
                new Transaction("David", 2011, 1200),
                new Transaction("Eve", 2012, 1600)
        );

        // Your task:
        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
      List<Integer> v=  transactions.stream().filter(t -> t.getYear()==2011).map( t-> t.getValue()).sorted().collect(Collectors.toList());
        // 2. Get a comma-separated string of trader names in 2012.
      String s=   transactions.stream().filter(t -> t.getYear()==2012).map(t->t.getTraderName()).collect(Collectors.joining(" , "));
        // 3. Find the highest value of all transactions.
          int m= transactions.stream().mapToInt(t->t.getValue()).max().orElse(0);
        // Your stream pipeline here...

        // Output the results
        System.out.println("1. Transactions in 2011, sorted by value: " + v.toString());
        System.out.println("2. Comma-separated trader names in 2012: " +s);
        System.out.println("3. Highest value of all transactions: " +m);
    }
}
