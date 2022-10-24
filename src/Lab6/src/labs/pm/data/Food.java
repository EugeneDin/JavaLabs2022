package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public final class Food extends Product{

    private LocalDate bestBefore;

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(), getName(), getPrice(),
                newRating, bestBefore);
    }

    @Override
    public BigDecimal getDiscount() {
        LocalTime now = LocalTime.now();
        return (now.isAfter(LocalTime.of(17,30)) &&
                now.isBefore(LocalTime.of(18,30)))
                ? super.getDiscount() : BigDecimal.ZERO;
    }

    Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }
}
