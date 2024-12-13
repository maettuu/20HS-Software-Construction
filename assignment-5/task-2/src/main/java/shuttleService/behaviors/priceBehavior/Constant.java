package shuttleService.behaviors.priceBehavior;

/**
 * fixed price model
 */
public class Constant implements PriceBehavior {
    private int amount;

    /**
     * Constant constructor
     * @param amount set fixed price
     */
    public Constant(int amount) {
        this.amount = amount;

        if (amount < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    /**
     * Get the price
     * @return
     */
    @Override
    public String getPrice() {
        return amount + " CHF";
    }
}
