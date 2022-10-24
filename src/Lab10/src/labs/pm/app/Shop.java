package labs.pm.app;

import labs.pm.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

public class Shop {
    public static void main(String[] args) {

        ProductManager pm = new ProductManager("en-GB");

        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99),
                Rating.NOT_RATED);
        //pm.printProductReport(101);
        pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
        pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Good tea");
        pm.reviewProduct(101, Rating.FIVE_STAR, "Perfect tea");
        pm.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");
        //pm.printProductReport(101);

        //pm.changeLocale("ru-RU");

        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99),
                Rating.NOT_RATED);

        pm.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
        pm.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?!");
        pm.reviewProduct(102, Rating.FIVE_STAR,
                "It’s perfect with ten spoons of sugar!");
        //pm.printProductReport(102);
        pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99),
                Rating.NOT_RATED, LocalDate.now().plusDays(2));
        pm.reviewProduct(103, Rating.FIVE_STAR, "Very nice cake");
        pm.reviewProduct(103, Rating.FOUR_STAR,
                "It good, but I've expected more chocolate");
        pm.reviewProduct(103, Rating.FIVE_STAR, "This cake is perfect!");
        //pm.printProductReport(103);
        pm.createProduct(104, "Cookie", BigDecimal.valueOf(2.99),
                Rating.NOT_RATED, LocalDate.now());
        pm.reviewProduct(104, Rating.THREE_STAR, "Just another cookie");
        pm.reviewProduct(104, Rating.THREE_STAR, "Ok");
        //pm.printProductReport(104);
        pm.createProduct(105, "Hot Chocolate", BigDecimal.valueOf(2.50),
                Rating.NOT_RATED);
        pm.reviewProduct(105, Rating.FOUR_STAR, "Tasty!");
        pm.reviewProduct(105, Rating.FOUR_STAR, "No bad at all");
        //pm.printProductReport(105);
        pm.createProduct(106, "Chocolate", BigDecimal.valueOf(2.50),
                Rating.NOT_RATED, LocalDate.now().plusDays(3));
        pm.reviewProduct(106, Rating.TWO_STAR, "Too sweet");
        pm.reviewProduct(106, Rating.THREE_STAR, "Better than cookie");
        pm.reviewProduct(106, Rating.TWO_STAR, "Too bitter");
        pm.reviewProduct(106, Rating.ONE_STAR, "I don't get it!");
        //pm.printProductReport(106);

        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal()-p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1,p2) -> p2.getPrice().compareTo(p1.getPrice());

        pm.printProducts(ratingSorter.thenComparing(priceSorter));

        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());

//        Product p2 = pm.createProduct(102, "Coffee",
//                BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
//        Product p3 = pm.createProduct(103, "Ice Cream",
//                BigDecimal.valueOf(3.99), Rating.FIVE_STAR,
//                LocalDate.now().plusDays(2));
//        Product p4 = pm.createProduct(105, "Cake",
//                BigDecimal.valueOf(3.99), Rating.TWO_STAR,
//                LocalDate.now());
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);
//        Product p9 = p1.applyRating(Rating.TWO_STAR);
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(p5);
//        System.out.println(p8);
//        System.out.println(p9);
//        Product p6 = pm.createProduct(104, "Chocolate",
//        BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = pm.createProduct(104, "Chocolate",
//                BigDecimal.valueOf(2.99), Rating.FIVE_STAR,
//                LocalDate.now().plusDays(2));
//        System.out.println(p6.equals(p7));
//        System.out.println(p3.getBestBefore());
//        System.out.println(p1.getBestBefore());


//        Product p1 = new Drink(101,"Tea",BigDecimal.valueOf(1.99), Rating.THREE_STAR);
//
//        Product p2 = new Drink(102, "Coffee",
//                BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
//
//        Product p3 = new Food(103, "Cake",
//                BigDecimal.valueOf(3.99), Rating.FIVE_STAR,
//                LocalDate.now().plusDays(2));
//
//        Product p4 = new Food(105,"Cookie",BigDecimal.valueOf(3.99),
//                Rating.TWO_STAR,LocalDate.now());
//
//        Product p5 = p3.applyRating(Rating.THREE_STAR);
//
//        System.out.println(p3);
//        System.out.println(p5);
//
//        Product p6 = new Drink(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
//        Product p7 = new Food(104,"Chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//
//        System.out.println(p6.equals(p7));
//
//        Product p8 = p4.applyRating(Rating.FIVE_STAR);
//        Product p9 = p1.applyRating(Rating.TWO_STAR);
//
//        System.out.println(p8);
//        System.out.println(p9);
//
//        System.out.println(p3.getBestBefore());
//        System.out.println(p1.getBestBefore());

    }
}
