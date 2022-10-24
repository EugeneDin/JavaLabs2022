package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;

/**
 * {@code Product} class represents properties and behaviours of
 * product objects in the Product Management System.
 * <br>
 * Each product has an id, name, and price
 * <br>
 * @version 4.0
 * @author Burdin Evgeny
 */
public abstract class Product {

    /**
     * A constant that defines a
     * {@link java.math.BigDecimal BigDecimal} value of the discount rate
     * <br>
     * Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE=BigDecimal.valueOf(0.1);

    private int id;
    private String name;
    private BigDecimal price;

    private Rating rating;

     Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return id+", "+name+", "+price+", "+getDiscount()+", " + rating.getStars()+" "+getBestBefore();
    }

    @Override
    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Product other = (Product) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        return true;
        if (this==obj) { return true; }
        if (obj instanceof Product) {
            final Product other = (Product)obj;
            return this.id==other.id && Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

//    public Product(int id, String name, BigDecimal price) {
//        this(id, name, price, Rating.NOT_RATED);
//    }
//
//    public Product() {
//        this(0,"no name",BigDecimal.ZERO);
//    }

    public int getId() {
        return id;
    }

//    public void setId(final int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

//    public void setName(final String name) {
//        this.name = name;
//    }

    public BigDecimal getPrice() {
        return price;
    }

//    public void setPrice(final BigDecimal price) {
//        this.price = price;
//    }

    public BigDecimal getDiscount() {
        // discount calculation logic will be added here
        return  price.multiply(DISCOUNT_RATE).setScale(2,HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public abstract Product applyRating(Rating newRating);

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }
}
