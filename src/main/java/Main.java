import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@FunctionalInterface
interface checkDealsFunction {
    boolean check(Deal deal, double recommendedPrice);
}

public class Main {

    public static List<Deal> generateDeals(int numberOfDeals, Random rand) {
        List<Deal> deals = new ArrayList<>();
        int length;
        int width;
        double pricePerMeter;
        for (int i = 0; i < numberOfDeals; i++) {
            length = rand.nextInt(100);
            width = rand.nextInt(100);
            pricePerMeter = 10000 * rand.nextDouble();
            deals.add(new Deal(length, width, pricePerMeter));
        }
        return deals;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        checkDealsFunction honesty = (deal, price) -> {
            return deal.getPrice() < price ? false : true;
        };


        int numberOfDeals = 1 + rand.nextInt(100);
        List<Deal> deals = generateDeals(numberOfDeals, rand);
        System.out.println("Hello! Please, enter the recommended price for 1 square meter of land:");
        String input = scan.nextLine();
        final Double recommendedPrice = Double.parseDouble(input);

        deals.stream()
                .map(x -> x.toString() + (honesty.check(x, recommendedPrice) ? " is honest" : " is not honest"))
                .forEach(System.out::println);
    }
}
