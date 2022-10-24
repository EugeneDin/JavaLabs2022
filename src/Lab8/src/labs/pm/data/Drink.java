package labs.pm.data;

import java.math.BigDecimal;

public final class Drink extends Product{

    @Override
    public BigDecimal getDiscount() {
        return super.getDiscount();
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Drink(getId(), getName(), getPrice(), newRating);
    }

    Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }
}
